package lambda;

interface Func<R, T> {
    R func(T n);
}

class MyClass1<T> {
    private T val;

    MyClass1(T v) { val = v; }

    MyClass1() { val = null; }

    T getVal() { return val; }

}

class MyClass2<T> {
    String str;

    MyClass2(String s) { str = s; }

    MyClass2() { str = ""; }

    String getVal() { return str; }
}

class ConstructorRefDemo2 {
    static <R,T> R myClassFactory(Func<R,T> cons, T v){
        return cons.func(v);
    }

    public static void main(String args[]){
        Func<MyClass1<Double>, Double> myClassCons = MyClass1<Double>::new;
        MyClass1<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("Значение val в объекте mc равно: " + mc.getVal());

        Func<MyClass2, String> myClassCons2 = MyClass2::new;
        MyClass2 mc2 = myClassFactory(myClassCons2, "Лямбда");
        System.out.println("Значение val в объекте mc2 равно: " + mc2.getVal());
    }

}
