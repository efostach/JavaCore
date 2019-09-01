package com.efostach.lambda;

interface  MyFunc{
    int func(int n);
}

public class VarCapture {
    public static void main(String args[]){
        // локальная переменная
        int num = 10;

        MyFunc myLambda = (n) -> {
            int v = num + n;
//            num++;
            return v;
        };

//        num = 9;
    }
}
