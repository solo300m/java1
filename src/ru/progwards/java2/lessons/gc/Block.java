package ru.progwards.java2.lessons.gc;

public class Block{
    public int ptr;
    public int size;
    private int endBlock;
    public boolean free;

    public Block(int ptr, int size) {
        this.ptr = ptr;
        this.size = size;
        this.endBlock = getEndBlock();
        this.free = true;
    }

    public int getEndBlock(){
        return ptr + size;
    }
    public void setEndBlock(int endBlock){
        this.endBlock = endBlock;
    }

    @Override
    public String toString() {
        return "Block{" +
                "ptr=" + ptr +
                ", size=" + size +
                ", endBlock=" + endBlock +
                ", free=" + free +
                '}';
    }
}
