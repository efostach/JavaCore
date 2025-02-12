package com.efostach.lambda;

interface NumericFunc<T>{
    T func(T t);
}

public class BlockLambdaDemo {
    public static void main(String args[]){
        NumericFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++){
                result = i * result;
            }
            return result;
        };

        System.out.println("Факториал числа 3 равен " + factorial.func(3));
        System.out.println("Факториал числа 5 равен " + factorial.func(5));
    }
}
