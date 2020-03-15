package ru.progwards.java1.lessons.classes;

class programm{
    public static void main(String[] args) {
        ComplexNum a = new ComplexNum(1,2);
        ComplexNum b = new ComplexNum(3,4);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.add(b));
        System.out.println(a.sub(b));
        System.out.println(a.mul(b));
        System.out.println(a.div(b));
    }
}

public class ComplexNum {
    private int d_part;
    private int m_part;
    public ComplexNum(){};
    public ComplexNum(int a, int b){
        d_part = a;
        m_part = b;
    }
    public int getA(){
        return d_part;
    }
    public int getB(){
        return m_part;
    }
    public void setD_part(int a){
        this.d_part = a;
    }
    public void setM_part(int b){
        this.m_part = b;
    }

    @Override
    public String toString(){
        return getA()+"+"+getB()+"i";
    }
    public ComplexNum add(ComplexNum num){
        ComplexNum rez = new ComplexNum();
        rez.setD_part(this.getA()+num.getA());
        rez.setM_part(this.getB()+num.getB());
        return rez;
    }
    public ComplexNum sub(ComplexNum num){
        ComplexNum rez = new ComplexNum();
        rez.setD_part(this.getA()-num.getA());
        rez.setM_part(this.getB()-num.getB());
        return rez;
    }
    public ComplexNum mul(ComplexNum num){
        ComplexNum rez = new ComplexNum();
        rez.setD_part(this.getA()*num.getA() - this.getB()*num.getB());
        rez.setM_part(this.getB()*num.getA() + this.getA()*num.getB());
        return rez;
    }
    public ComplexNum div(ComplexNum num){
        ComplexNum rez = new ComplexNum();
        rez.setD_part((this.getA()*num.getA() + this.getB()*num.getB())/(num.getA()*num.getA()+num.getB()*num.getB()));
        rez.setM_part((this.getB()*num.getA()-this.getA()*num.getB())/(num.getA()*num.getA()+num.getB()*num.getB()));
        return rez;
    }
}
