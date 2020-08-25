package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.calc.SimpleСalculator;


public class SimpleСalculatorExceptionTest {
    public static SimpleСalculator calc;
    @BeforeClass
    public static void init(){
        calc = new SimpleСalculator();
    }
    @Test(expected = RuntimeException.class)
    public void SumWithException(){
        calc.sum(Integer.MAX_VALUE,1);
    }
    @Test(expected = RuntimeException.class)
    public void DiffWithException(){
        calc.diff(Integer.MIN_VALUE,1);
    }
    @Test(expected = RuntimeException.class)
    public void MultWithException(){
        calc.mult(Integer.MAX_VALUE,2);
    }
    @Test(expected = RuntimeException.class)
    public void DivWithException(){
        calc.div(1,0);
    }
    @AfterClass
    public static void Distroed(){
        calc = null;
    }
}

