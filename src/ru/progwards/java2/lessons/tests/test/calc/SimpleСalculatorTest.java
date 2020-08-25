package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calc.SimpleСalculator;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class SimpleСalculatorTest {
    @RunWith(Parameterized.class)
    public static class SumCalculatorTest{
        public static SimpleСalculator calc;
        public int val1;
        public int val2;
        public int expected;

        @BeforeClass
        public static void init(){
            calc = new SimpleСalculator();
        }
        public SumCalculatorTest(int val1, int val2, int expected){
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }
        @Parameterized.Parameters(name = "Тест {index}: ({0}) + ({1}) = {2}")
        public static Iterable<Object[]> dataForTestSum(){
            return Arrays.asList(new Object[][] {
                    {0,0,0},
                    {5,0,5},
                    {-5,-5,-10},
                    {34,55,89},
                    {-34,-55,-89}
            });
        }
        @Test
        public void sum(){
            assertEquals(expected,calc.sum(val1,val2));
        }
        @AfterClass
        public static void Distroid(){
            calc = null;
        }
    }

    @RunWith(Parameterized.class)
    public static class DiffCalculatorTest{
        public static SimpleСalculator calc;
        public int val1;
        public int val2;
        public int expected;

        @BeforeClass
        public static void init(){
            calc = new SimpleСalculator();
        }
        public DiffCalculatorTest(int val1, int val2, int expected){
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }
        @Parameterized.Parameters(name = "Тест {index}: ({0}) - ({1}) = {2}")
        public static Iterable<Object[]> dataForTestSum(){
            return Arrays.asList(new Object[][] {
                    {0,0,0},
                    {5,0,5},
                    {-5,-5,0},
                    {34,55,-21},
                    {-34,-55,21}
            });
        }
        @Test
        public void diff(){
            assertEquals(expected,calc.diff(val1,val2));
        }
        @AfterClass
        public static void Distroid(){
            calc = null;
        }
    }

    @RunWith(Parameterized.class)
    public static class MultCalculatorTest{
        public static SimpleСalculator calc;
        public int val1;
        public int val2;
        public int expected;

        @BeforeClass
        public static void init(){
            calc = new SimpleСalculator();
        }
        public MultCalculatorTest(int val1, int val2, int expected){
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }
        @Parameterized.Parameters(name = "Тест {index}: ({0}) * ({1}) = {2}")
        public static Iterable<Object[]> dataForTestSum(){
            return Arrays.asList(new Object[][] {
                    {0,0,0},
                    {5,0,0},
                    {-5,-5,25},
                    {34,55,1870},
                    {-34,-55,1870}
            });
        }
        @Test
        public void mult(){
            assertEquals(expected,calc.mult(val1,val2));
        }
        @AfterClass
        public static void Distroid(){
            calc = null;
        }
    }

    @RunWith(Parameterized.class)
    public static class DivCalculatorTest{
        public static SimpleСalculator calc;
        public int val1;
        public int val2;
        public int expected;

        @BeforeClass
        public static void init(){
            calc = new SimpleСalculator();
        }
        public DivCalculatorTest(int val1, int val2, int expected){
            this.val1 = val1;
            this.val2 = val2;
            this.expected = expected;
        }
        @Parameterized.Parameters(name = "Тест {index}: ({0}) / ({1}) = {2}")
        public static Iterable<Object[]> dataForTestSum(){
            return Arrays.asList(new Object[][] {
                    {0,1,0},
                    {5,1,5},
                    {-5,-5,1},
                    {55,34,1},
                    {-36,6,-6}
            });
        }
        @Test
        public void div(){
            assertEquals(expected,calc.div(val1,val2));
        }
        @AfterClass
        public static void Distroid(){
            calc = null;
        }
    }
}

