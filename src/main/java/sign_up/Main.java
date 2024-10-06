package sign_up;

import java.util.Scanner;

/*
 유저의 데이터를 저장하는 UserDataManager 클래스 작성
 UserDataManager 는 User 객체의 register를 도와줌 (가입)
 UserDataManager 는 User 객체가 이미 회원인지 확인 가능 (id를 통해)
 UserDataManager 는  User 객체를 가져올 수 있음 (id를 통해)
 UserDataManager 는 User 객체의 unregister 를 도와줌 (탈퇴)
 */
 public class Main {

    public static void main(String[] args) {

/*
        방법 1

        UserDataManager manager = UserDataManager.getInstance();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String id = sc.next();
            String pw = sc.next();

            if (!manager.isMember(id)) {
                manager.register(id, pw);
                System.out.println("멤버가 아니여서 등록하였습니다.");
            } else if (manager.isMember(id) && manager.getUser(id).getPw().equals(pw)) {
                System.out.println("로그인 성공!");
                break;
            } else if (manager.isMember(id) && !manager.getUser(id).getPw().equals(id)) {
                System.out.println("비밀번호가 다릅니다.");
                break;
            }
        }*/

        // 방법 2
        UserDataManager manager = UserDataManager.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("ID: ");
            String id = sc.next();
            System.out.print("PW: ");
            String pw = sc.next();

            if (!manager.isMember(id)) {
                manager.register(id, pw);
                System.out.println("멤버가 아니여서 등록하였습니다.");
            } else {
                User user = manager.getUser(id);
                if (user.getPw().equals(pw)) {
                    System.out.println("로그인 되었습니다!");
                } else {
                    System.out.println("비밀번호가 다릅니다.");
                }
            }
        }
    }
}