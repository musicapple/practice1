package sign_up;

import java.util.HashMap;
import java.util.Map;

public class UserDataManager {
    // 유저의 등록, 확인, 삭제 같은 중요한 기능을 제공
    // 만약 여러 인스턴스가 생성된다면 서로 다른 객체가 서로 다른 유저 데이터를 관리할 수 있게 되고,
    // 데이터가 일관되지 않을 수 있음
    private static UserDataManager instance;
    private static UserDataManager getInstance(){
        if(instance == null){
            instance = new UserDataManager();
        }
        return instance;
    }
    private UserDataManager(){}



    public void register(String id, String pw){

    }

    public boolean isMember(String id){

    }

    public User getUser(String id){

    }

    public boolean unregister(User user){

    }
}