package com.efostach.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    public static void main(String args[]) throws Exception {
        int c;

        Socket s = new Socket("whois.internic.net", 43);

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        String str = (args.length == 0 ? "MHProfessional.com" : args[0]) + "\n";

        byte buf[] = str.getBytes();

        // послать запрос
        out.write(buf);

        // прочитать ответ
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
        s.close();
    }
}
