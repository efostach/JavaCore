package com.efostach.exceptions;

public class ChainExDemo {
    static void demoproc(){
        //создать исключение
        NullPointerException e = new NullPointerException("Верхний уровень");

        //добавить причину исключения
        e.initCause(new ArithmeticException("причина"));
        throw e;
    }

    public static void main(String args[]){
        try {
            demoproc();
        }catch (NullPointerException e){
            System.out.println("Перехвачено исключение: " + e);
            System.out.println("Первопричина: " + e.getCause());
        }
    }
}
