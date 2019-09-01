package com.efostach.io;

import java.io.*;

public class SerializationDemo {
    public static void main(String args[]) {
        try (ObjectOutputStream objStrm = new ObjectOutputStream(new FileOutputStream("serial"))) {
            SerializableClass object1 = new SerializableClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);

            objStrm.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Исключение при сериализации: " + e);
        }

        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial"))) {
            SerializableClass object2 = (SerializableClass) objIStrm.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("Исключение при десериализации: " + e);
            System.exit(0);
        }
    }
}

    class SerializableClass implements Serializable {
        String s;
        int i;
        double d;

        public SerializableClass(String s, int i, double d) {
            this.s = s;
            this.i = i;
            this.d = d;
        }

        public String toString() {
            return "s=" + s + "; i=" + i + "; d=" + d;
        }
    }

