package lambda;

interface StrFunc{
    String func(String n);
}

class MyStringOps {
    static String strReverse(String str){
        String result = "";
        int i;

        for(i = str.length()-1; i >=0; i--)
            result += str.charAt(i);

        return result;
    }
}

class MethodRefDemo{
    static String stringOp(StrFunc sf, String s){
        return sf.func(s);
    }

    public static void main(String args[]){
        String inStr = "Лямба-выражение";
        String outStr;

        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Измененная строка: " + outStr);
    }
}
