package com.efostach.io;

public class MyClass {
    int a;
    int b;

    MyClass(int i, int j){
        a = i;
        b = j;
    }

    MyClass(int i){
        this(i, i);
    }

    MyClass(int i, double v){
        this(0);
    }
}
