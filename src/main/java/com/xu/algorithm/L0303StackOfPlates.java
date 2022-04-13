package com.xu.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO
public class L0303StackOfPlates {

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(0);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);
        stackOfPlates.push(4);
        stackOfPlates.push(5);

        System.out.println(stackOfPlates.popAt(2));
        System.out.println(stackOfPlates.popAt(2));
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
    }
}
/*

["StackOfPlates", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop"]
[[0], [2], [8], [56], [1], [39], [40], [44], [63], [11], [38], [20], [55], [25], [14], [11], [1], [20], [16], [6], [18], [3], [39], [45], [2], [22], [64], [6], [30], [39], [3], [19], [63], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]

 */

class StackOfPlates {
    List<Stack<Integer>> list = new ArrayList<>();
    private int cap = 0;

    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (list.size() == 0) {
            addStack();
        }
        Stack<Integer> stack = list.get(list.size() - 1);
        if (stack.size() >= cap) {
            addStack();
            stack = list.get(list.size() - 1);
        }
        if (stack.size() < cap) {
            stack.push(val);
        }

    }

    public int pop() {
        if (list.size() <= 0) {
            return -1;
        }
        Stack<Integer> stack = list.get(list.size() - 1);
        while (stack.size() == 0 && list.size() > 1) {
            list.remove(stack);
            stack = list.get(list.size() - 1);
        }
        if(stack.size()==0){
            return -1;
        }
        Integer pop = stack.pop();
        if (stack.size() == 0) {
            list.remove(stack);
        }
        return pop;
    }

    public int popAt(int index) {
        if (list.size() - 1 >= index) {
            Stack<Integer> stack = list.get(index);
            if (stack.size() == 0) {
                return -1;
            }
            Integer pop = stack.pop();
            if (stack.size() == 0) {
                list.remove(stack);
            }
            return pop;

        } else return -1;

    }


    private void addStack() {
        list.add(new Stack<>());
    }


}
