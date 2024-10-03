package lambda3;

public class Main {

    public static void main(String[] args) {

        StringLengthCalculator calculator = str -> str.length();
        System.out.println(calculator.getLength("Lambda Expressions"));
    }
}


@FunctionalInterface
interface StringLengthCalculator {
    int getLength(String str);
}