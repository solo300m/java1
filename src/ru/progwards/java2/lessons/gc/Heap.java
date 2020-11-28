package ru.progwards.java2.lessons.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Heap {
    byte[]heapByte;
    List<Block> structHeap = new ArrayList<>();
    public Heap(int syze){
        heapByte = new byte[syze];
    }

    public int malloc(int size) throws OutOfMemoryError{
        if(structHeap.size() == 0){
            return 0;
        }
        else if(structHeap.size() == 1 && structHeap.get(0).free == false){
            return structHeap.get(0).getEndBlock();
        }
        else{
            defrag();
            int startBlock = 0;
            int endBlock = 0;
            int endFreeBlock = 0;
            int sizeFreeBlock = 0;
            for (int i = 0; i < structHeap.size(); i++) {
                sizeFreeBlock = structHeap.get(i).getEndBlock() - structHeap.get(i).ptr;
                if(structHeap.get(i).free == true && sizeFreeBlock >= size) {
                    startBlock = structHeap.get(i).ptr;
                    endBlock = startBlock + size;
                    endFreeBlock = structHeap.get(i).getEndBlock();
                    if (endBlock < endFreeBlock) {
                        structHeap.get(i).setEndBlock(endBlock);
                        structHeap.add(new Block(endBlock, sizeFreeBlock-size));
                    }
                    structHeap.get(i).free = false;
                    return startBlock;
                }
            }
        }
        compact();
        if(heapByte.length - structHeap.get(structHeap.size()-1).getEndBlock() >= size)
            return structHeap.get(structHeap.size()-1).getEndBlock();
        else
            throw new OutOfMemoryError("Нет свободного места для размещения данных!");
    }
    public void defrag(){
        for(int i = 1; i < structHeap.size(); i++){
            if(structHeap.get(i-1).free == true && structHeap.get(i).free == true){
                structHeap.get(i-1).setEndBlock(structHeap.get(i).getEndBlock());
                structHeap.remove(i);
            }
        }
        if(structHeap.get(structHeap.size()-1).free == true)
            structHeap.remove(structHeap.size()-1);
    }
    public void compact(){
        byte[]tmpHeapByte = new byte[heapByte.length];
        freeTrueBlocks();
        int step = 0;
        for(Block elem:structHeap){
            int tmpStart = step;
            for(int i = elem.ptr; i< elem.getEndBlock(); i++){
                tmpHeapByte[step] = heapByte[i];
                step++;
            }
            int tmpEnd = step;
            elem.ptr = tmpStart;
            elem.setEndBlock(tmpEnd);
        }
        heapByte = tmpHeapByte;
    }
    public void free(int p){
        List<Block>find = structHeap.stream().filter(w->w.ptr <= p && w.getEndBlock()>=p).collect(Collectors.toList());
        if(find.size() != 0 && (find.size() > 1) == false){
            for(int i = 0; i < structHeap.size(); i++){
                if(structHeap.get(i).ptr == find.get(0).ptr)
                    structHeap.get(i).free = true;
            }
        }

    }
    //______________________________________________________________
    private void freeTrueBlocks(){
        for(int i = 0; i < structHeap.size(); i++){
            if(structHeap.get(i).free == true)
                structHeap.remove(i);
        }
    }
}
