package com.efostach.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String args[]) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // проверка, что указаны имена обоих файлов
        if(args.length != 2){
            System.out.println("Использование: CopyFile откуда куда");
            return;
        }

        // копировать файл
        try{
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }finally {
            try{
                if(fin != null) fin.close();
            }catch (IOException e2){
                System.out.println("Ошибка закрытия файла вывода");
            }
            try{
                if(fout != null) fout.close();
            }catch (IOException e3){
                System.out.println("Ошибка закрытия файла ввода");
            }
        }
    }
}