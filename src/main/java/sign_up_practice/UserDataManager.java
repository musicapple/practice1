package sign_up_practice;

import java.util.HashMap;

public class UserDataManager {

    private static UserDataManager instance;

    public static UserDataManager getInstance(){
        if(instance == null){
            instance = new UserDataManager();
        }
        return instance;
    }

    private UserDataManager(){}

    private HashMap<String, User> map =  new HashMap<>();
    private User user;

    public void register(String id, String pw){
        map.put(id,new User(id,pw));
    }
    public boolean isMember(String id){
        return map.containsKey(id);
    }

  /*  public void login(String id, String pw){
        if(!isMember(id)){
            System.out.print("존재하지 않는 아이디입니다!");
        }else{
            if(!pw.equals(map.get(id).getPw())){
                System.out.print("비밀번호가 일치하지 않습니다!");
            }else{
                user = getUser(id);
                System.out.print("로그인 되었습니다.");
            }
        }
    }*/
    /*public void logout(){
        user = null;
        System.out.print("로그아웃 되었습니다!");
    }*/
    public void unregister(User user){
        map.remove(getUser(user.getId()));
    }

    public User getUser(String id){
        return map.get(id);
    }
}
