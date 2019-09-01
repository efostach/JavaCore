package com.efostach.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStream {
    public static void main(String args[]){
        String s = "Это знак авторского права &copy; " + ", a &copy - нет.\n";
        byte buf[] = s.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;
        boolean marked = false;

        try(java.io.BufferedInputStream f = new java.io.BufferedInputStream(in)){
            while ((c = f.read()) != -1){
                switch(c){
                    case '&':
                        if(!marked){
                            f.mark(32);
                            marked = true;
                        } else{
                            marked = false;
                        }
                        break;
                    case ';':
                        if(marked){
                            marked = false;
                            System.out.print("(c)");
                        } else{
                            System.out.println((char) c);
                        }
                        break;
                    case ' ':
                        if(marked){
                            marked = false;
                            f.reset();
                            System.out.print("&");
                        } else{
                            System.out.print((char) c);
                        }
                        break;
                        default:
                            if (!marked)
                                System.out.print((char) c);
                            break;
                }
            }
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
