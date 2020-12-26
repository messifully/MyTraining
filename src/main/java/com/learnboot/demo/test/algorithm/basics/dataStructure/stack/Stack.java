package com.learnboot.demo.test.algorithm.basics.dataStructure.stack;

import java.util.Arrays;

public class Stack {

    int[] elements;

    public Stack() {
        this.elements = new int[0];
    }

    public int push(int element) {
        int[] newArr = Arrays.copyOf(elements, elements.length + 1);
        newArr[newArr.length-1]=element;
        elements=newArr;
        return element;
    }

    public int pop() {
        if (elements.length==0) {
            throw new RuntimeException("Stock is Empty");
        }
        int value = elements[elements.length-1];
        int[] newArr = Arrays.copyOf(elements, elements.length - 1);

        elements=newArr;
        return value;
    }

    public int peek(){
        return elements[elements.length-1];
    }

    public boolean isEmpty(){
        return elements.length==0 ? true:false;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
