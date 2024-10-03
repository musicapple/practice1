package singleton;

public class Main {

    public static void main(String[] args) {

//      SingletonExample se = new SingletonExample();   // 객체 생성 요청

        SingletonExample ex1 = SingletonExample.getInstance();
        SingletonExample ex2 = SingletonExample.getInstance();
        SingletonExample ex3 = SingletonExample.getInstance();

        ex1.setNumber(10);
        ex2.setNumber(20);
        ex3.setNumber(30);

        ex1.info();
        ex2.info();
        ex3.info();


    }
}

