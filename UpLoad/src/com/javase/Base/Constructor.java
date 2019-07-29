package com.javase.Base;

public class Constructor {
    Constructor(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {
        Constructor cons = new Constructor(5);
    }
}
