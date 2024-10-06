package sign_up;

import java.util.HashMap;
import java.util.Map;

public class UserDataManager {
    // 유저의 등록, 확인, 삭제 같은 중요한 기능을 제공
    // 만약 여러 인스턴스가 생성된다면 서로 다른 객체가 서로 다른 유저 데이터를 관리할 수 있게 되고,
    // 데이터가 일관되지 않을 수 있음
    private static UserDataManager instance;
    public static UserDataManager getInstance(){
        if(instance == null){
            instance = new UserDataManager();
        }
        return instance;
    }
    private UserDataManager(){}

    Map<String, User> map = new HashMap<>();

    public void register(String id, String pw){
        map.put(id,new User(id,pw));
    }

    public boolean isMember(String id){
        return map.containsKey(id);
    }

    public User getUser(String id){
        return map.get(id);
    }

    public boolean unregister(User user){
        if(isMember(user.getId())){
            map.remove(user.getId());
            return true;
        } else{
            System.out.println("회원 정보가 없습니다");
            return false;
        }
    }
}