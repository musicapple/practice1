package lambda2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {1,10,20,30,40,50,60};

        Arrays.stream(numbers).filter(a->a>20).map(a -> a*2).forEach(a-> System.out.println(a));
    }
}
