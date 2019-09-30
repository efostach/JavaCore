package com.efostach.files;

import java.io.File;

public class FileDemo {
    static void p(String s){
        System.out.println(s);
    }

    public static void main(String args[]){
        File fl = new File("/java/COPYRIGHT");
        p("Имя файла: " + fl.getName());
        p("Путь: " + fl.getPath());

        String dirname = "/Users";
        File fl1 = new File(dirname);

        if(fl1.isDirectory()){
            System.out.println("Каталог " + dirname);
            String s[] = fl1.list();

            for(int i = 0; i < s.length; i++){
                File f = new File(dirname + "/" + s[i]);
                if(f.isDirectory()){
                    System.out.println(s[i] + " является каталогом");
                } else {
                    System.out.println(s[i] + " является файлом");
                }
            }
        } else{
            System.out.println(dirname + " не является каталогом");
        }


    }
}
