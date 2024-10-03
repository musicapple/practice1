package lambda.lambda1;

public class Main {

    public static void main(String[] args) {

        // 1번 방법
        ABC number = (a) -> a>=100;

        System.out.println(number.abc(55));
    }

}

@FunctionalInterface
interface ABC{
    boolean abc(int a);
}
