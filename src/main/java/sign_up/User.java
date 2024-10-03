package sign_up;

public class User {

    private String id;
    private String pw;
    private String name;

    public User(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public String getId(){
        return id;
    }
    public String getPw(){
        return pw;
    }
    public String getName(){
        return name;
    }
}
