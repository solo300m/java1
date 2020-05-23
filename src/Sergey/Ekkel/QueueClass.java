package Sergey.Ekkel;

import java.util.ArrayDeque;
class Program3{
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        QueueClass s = new QueueClass();
        var d = s.array2queue(a);
        System.out.println(d);
        s.dequeueTest();
    }
}
//14 модуль тест 1
public class QueueClass {
    ArrayDeque<Integer> array2queue(int[] a){
        ArrayDeque<Integer> dec = new ArrayDeque<>();
        if(a != null){
            for(int i = 0; i<a.length; i++)
                dec.offer(Integer.valueOf(a[i]));
        }
        return dec;
    }
// это тоже из теста но не задание
    void dequeueTest() {
        ArrayDeque deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i%2 == 0)
                deque.poll();
        }

        System.out.println(deque);
    }
}
