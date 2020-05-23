package Sergey.Ekkel;

import java.util.ArrayDeque;

public class DequeClass {
    public static void main(String[] args) {
        /*Deque<String> stack = new ArrayDeque<>();
        stack.push("мороз");
        stack.push("и");
        stack.push("солнце");
        stack.push("день");
        stack.push("чудесный");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }*/
        ArrayDeque<Integer> integ = new ArrayDeque<>();
        /*for(int i = 0; i<=10; i++)
            integ.offerLast(i);*/
        integ.offer(1);
        var a = new DequeClass().sumLastAndFirst(integ);
        System.out.println(a);
    }
    //14 модуль тест 2
    int sumLastAndFirst(ArrayDeque<Integer> deque){
        if(!deque.isEmpty()) {
            int sum = 0;
            sum = deque.getFirst() + deque.getLast();
            return sum;
        }
        else
            return 0;
    }

}
