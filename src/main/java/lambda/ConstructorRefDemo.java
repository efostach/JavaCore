package lambda;

interface ClassFunc{
    ClassDemo func(int n);
}

class ClassDemo{
    private int val;

    ClassDemo(int v) { val = v; }
    ClassDemo() { val = 0; }

    int getVal() { return val; }
}

class ConstructorRefDemo {
    public static void main(String args[]){
        ClassFunc cf = ClassDemo::new;

        ClassDemo cd = cf.func(100);

        System.out.println("Значение val в объекте ClassDemo равно: "+ cd.getVal());
    }

}
