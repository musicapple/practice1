package singleton;

public class SingletonExample {

    private int number;

    public static SingletonExample instance;
    public static SingletonExample getInstance(){
        if(instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    private SingletonExample(){
      System.out.println("SingletonExample 생성자가 호출되었습니다.");
    }

    public void setNumber(int number){
        this.number = number;
    }
    public void info(){
        System.out.println("Example의 number: " + number);
    }
}
