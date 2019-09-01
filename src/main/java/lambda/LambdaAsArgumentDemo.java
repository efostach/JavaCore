package lambda;

interface StringFunc{
    String func(String n);
}

public class LambdaAsArgumentDemo {

    static String stringOp(StringFunc sf, String s){
        return  sf.func(s);
    }

    public static void main(String args[]){
        String inStr = "Лямбда-выражения повышают эффективность Java.";
        String outStr;

        System.out.println("Это исходная строка: " + inStr);

        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("Это строка в верхнем регистре: " + outStr);

        outStr = stringOp((str) -> {
            String result = "";
            int i;

            for(i = 0; i < str.length(); i++)
                if(str.charAt(i) != ' ')
                    result += str.charAt(i);
                return result;
        }, inStr);

        System.out.println("Это строка с удаленным пробелами: " + outStr);



        StringFunc reverse = (str) -> {
            String result = "";
            int i;

            for (i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        System.out.println("Это измененная строка" + stringOp(reverse, inStr));
    }
}
