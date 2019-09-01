package exceptions;

import java.util.Random;

public class HandleError {
    public static void main(String args[]){
        int a = 0, b = 0, c = 0;
        int d[] = {1};

        Random r = new Random();

        for (int i = 0; i < 3000; i++){
            try {
                b = r.nextInt();
                c = r.nextInt();
                a = 12345 / (b/c);
                d[42] = 99;

            } catch (ArithmeticException e){
                System.out.println("Исключение: " + e);
                a = 0;
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Исключение: " + e);
            }
            System.out.println("После блока catch");
        }
    }
}
