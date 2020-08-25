package ru.progwards.java2.lessons.tests.calc;

public class SimpleСalculator implements ISimpleCalculator {
    @Override
    public int sum(int val1, int val2) throws ArithmeticException{
        long rez = (long) val1 + val2;
        if(rez > Integer.MAX_VALUE || rez < Integer.MIN_VALUE)
            throw new ArithmeticException("Произошло переполнение по операции sum");
        return val1 + val2;
    }

    @Override
    public int diff(int val1, int val2) {
        long rez = (long) val1 - val2;
        if(rez < Integer.MIN_VALUE || rez > Integer.MAX_VALUE)
            throw new ArithmeticException("Произошло переполнение по операции diff");
        return val1 - val2;
    }

    @Override
    public int mult(int val1, int val2) {
        long rez = (long)val1 * val2;
        if(rez > Integer.MAX_VALUE || rez < Integer.MIN_VALUE)
            throw new ArithmeticException("Произошло переполнение по операции mult");
        return (int) val1 * val2;
    }

    @Override
    public int div(int val1, int val2) {
        if(val2 == 0)
            throw new ArithmeticException("Произошло деление на 0");
        return (int) val1/val2;
    }
}

