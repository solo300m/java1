package ru.progwards.java2.lessons.gc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap <T>{
    byte[]heapByte;
    List<Element> structHeap = new ArrayList<>();

    public Heap(int syze){
        heapByte = new byte[syze];
    }

    public int malloc(int size) throws OutOfMemoryError{
        if(structHeap.size() == 0){
            return 0;
        }
        else if(structHeap.size() == 1 && structHeap.get(0).free == true){
            return structHeap.get(0).getEndBlock();
        }
        else{
            defrag();
            int block = 0;
            int startFreeBlock = 0;
            int endFreeBlock = 0;
            for (int i = 0; i < structHeap.size(); i++) {
                if(structHeap.get(i).free == false && structHeap.get(i).endBlock - structHeap.get(i).startBlock >= size) {
                    block = structHeap.get(i).getStartBlock();
                    startFreeBlock = block + size;
                    endFreeBlock = structHeap.get(i).endBlock;
                    if (startFreeBlock < structHeap.get(i).endBlock) {
                        structHeap.get(i).setEndBlock(startFreeBlock);
                        structHeap.add(new Element(startFreeBlock, endFreeBlock));
                    }
                    return block;
                }
            }
        }
        compact();
        if(heapByte.length - structHeap.get(structHeap.size()-1).getEndBlock() >= size)
            return structHeap.get(structHeap.size()-1).getEndBlock();
        else
            throw new OutOfMemoryError("Нет свободного места для размещения данных!");
    }
    public void free(int ptr){
        Element elem = structHeap.get(ptr);
        for(int i = elem.getStartBlock(); i < elem.getEndBlock(); i++) {
            heapByte[i] = 0;
        }
        structHeap.get(ptr).free = false;
        defrag();
    }
    public void defrag(){
        for(int i = 1; i < structHeap.size(); i++){
            if(structHeap.get(i-1).free == false && structHeap.get(i).free == false){
                structHeap.get(i-1).setEndBlock(structHeap.get(i).getEndBlock());
                structHeap.remove(i);
            }
        }
        if(structHeap.get(structHeap.size()-1).free == false)
            structHeap.remove(structHeap.size()-1);
    }
    public void compact(){
        byte[]tmpHeapByte = new byte[heapByte.length];
        freeFalseBlocks();
        int step = 0;
        for(Element elem:structHeap){
            int tmpStart = step;
            for(int i = elem.getStartBlock(); i< elem.getEndBlock(); i++){
                tmpHeapByte[step] = heapByte[i];
                step++;
            }
            int tmpEnd = step;
            elem.setStartBlock(tmpStart);
            elem.setEndBlock(tmpEnd);
        }
        heapByte = tmpHeapByte;
    }
    //_____________Служебные функции и интерфейсы доступа к Heap____________________________//
    private void freeFalseBlocks(){
        for(int i = 0; i < structHeap.size(); i++){
            if(structHeap.get(i).free == false)
                structHeap.remove(i);
        }
    }
    public Element<T> getHeap(int ptr){
        Element<T> elem = new Element<>();
        int elemTrue = 0;
        for(int i = 0; i<structHeap.size(); i++){
            if(structHeap.get(i).free == true){
                if(elemTrue == ptr) {
                    elem = structHeap.get(ptr);
                    break;
                }
                elemTrue++;
            }
            else
                elemTrue--;

        }
        elem.bytes = new byte[elem.getEndBlock()-elem.getStartBlock()];
        int step = 0;
        for(int i = elem.getStartBlock(); i < elem.getEndBlock(); i++){
            elem.bytes[step] = heapByte[i];
            step++;
        }
        String tmp = new String(elem.bytes);
        System.out.println(tmp);
        return elem;
    }
    public void addHeap(Element<T> element){
        element.setStartBlock(malloc(element.byteSize()));
        element.setEndBlock(element.getStartBlock() + element.byteSize());
        int step = 0;
        for(int i = element.getStartBlock();i< element.getEndBlock();i++){
            heapByte[i] = element.bytes[step];
            step++;
        }
        boolean registre = false;
        for(Element elem:structHeap){
            if(element.equals(elem)) {
                elem.setStartBlock(element.getStartBlock());
                elem.setEndBlock(element.getEndBlock());
                elem.setTypeElem(element.getTypeElem());
                elem.setItem(null);
                elem.setBytes(null);
                elem.setFree(true);
                registre = true;
            }
        }
        if(registre == false){
            structHeap.add(element);
            structHeap.get(structHeap.size()-1).setItem(null);
            structHeap.get(structHeap.size()-1).setFree(true);
            structHeap.get(structHeap.size()-1).setBytes(null);
        }

        sortHeap();
    }


    private void sortHeap(){
        structHeap.sort(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.getEndBlock() <= o2.getStartBlock())
                    return -1;
                else if(o1.getEndBlock() >= o2.getStartBlock())
                    return 1;
                return 0;
            }
        });
    }

}
class Test{
    public static void main(String[] args) {
        /*String str = "Моя строка для преобразования";
        double a = 123456.45;
        String aStr = Double.toString(a);
        byte[]bytesDouble = aStr.getBytes();
        System.out.println("Длина массива aStr = "+aStr.length());
        aStr = new String(bytesDouble);
        System.out.println(aStr);
        a = Double.parseDouble(aStr);
        System.out.println(a);
        System.out.println("______________________________");
        byte[] bytes = str.getBytes();
        System.out.println(bytes+" длинна массива "+bytes.length);
        for(int i=0;i<bytes.length;i++)
            System.out.print(" "+bytes[i]);
        System.out.println();
        System.out.println(bytes.toString());
        String s = new String(bytes);
        System.out.println(s);*/
        /*char intMy = 'A';
        String tmp = Character.toString(intMy);
        System.out.println(tmp);
        Class clazz = Float.class;
        String cl = clazz.getSimpleName();
        System.out.println(clazz+" "+cl);*/
        /*byte[]bytes = new byte[10];
        for (int i = 0; i < bytes.length; i++){
            System.out.print(bytes[i]+" ");
        }*/
        Heap nat = new Heap<>(200);
        nat.addHeap(new Element<>("Привет, Мир!"));
        nat.addHeap(new Element<String>("Hello!"));
        nat.addHeap(new Element("Problems"));
        nat.addHeap(new Element<Integer>(2569));
        nat.addHeap(new Element<Double>(25.6586));
        for(int i=0; i<nat.structHeap.size(); i++){
            System.out.println(nat.structHeap.get(i));
        }
        System.out.println();
        Element<String> tt = nat.getHeap(3);
        nat.free(0);
        nat.addHeap(new Element("Hy!!!"));
        nat.addHeap(new Element(56.896));
        //nat.sortHeap();
        tt = nat.getHeap(3);
        for(int i=0; i<nat.structHeap.size(); i++){
            System.out.println(nat.structHeap.get(i));
        }

        //System.out.println(nat.structHeap.get(0));
        /*for(int i=0; i < nat.heapByte.length; i++) {
            System.out.print(nat.heapByte[i]+" ");
        }*/
        tt = nat.getHeap(3);
        nat.compact();
        System.out.println("__________________________");
       /* for(int i=0; i < nat.heapByte.length; i++) {
            System.out.print(nat.heapByte[i]+" ");
        }*/
        System.out.println("___________________________");
        /*for(int i=0; i<nat.structHeap.size(); i++){
            System.out.println(nat.structHeap.get(i));
        }*/
        tt = nat.getHeap(3);
    }
}