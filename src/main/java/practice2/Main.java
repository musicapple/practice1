package practice2;

public class Main {

    public static void main(String[] args) {

        // 1번 방법
        ABC number = (a) -> {
            if(a>=100){
                return true;
            }else{
                return false;
            }
        };
        System.out.println(number.abc(55));
    }
    // 2번 방법
    ABC d = new ABC() {
        @Override
        public boolean abc(int a) {
            if(a>=100){
                return true;
            }else{
                return false;
            }
        }
    };

}

@FunctionalInterface
interface ABC{
    boolean abc(int a);
}
