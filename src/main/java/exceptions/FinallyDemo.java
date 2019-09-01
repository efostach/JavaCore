package exceptions;

public class FinallyDemo {
    static void procA(){
        try{
            System.out.println("В теле метода procA()");
                    throw new RuntimeException("демонстрация");
        }
        finally {
            System.out.println("Блок оператора finally в теле метода procA()");
        }
    }

    static void procB(){
        try{
         System.out.println("В теле метода procB()");
         return;
        }
        finally {
            System.out.println("Блок оператора finally в теле метода procB()");
        }
    }

    static void procC(){
        try{
            System.out.println("В теле метода procC()");
        }
        finally {
            System.out.println("Блок оператора finally в теле метода procC()");
        }
    }

    public static void main(String args[]){
        try{
            procA();
        } catch (Exception e){
            System.out.println("Исключение перехвачено");
        }

        procB();
        procC();
    }
}
