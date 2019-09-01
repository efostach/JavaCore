package com.efostach.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String args[]) {
        int i;
        FileInputStream fin;

        if (args.length != 1) {
            System.out.println("Использование: ShowFile имя_файла");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл");
            return;
        }

        try {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        } finally {
            // закрыть файл при выходе из блока try
            try {
                fin.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}
