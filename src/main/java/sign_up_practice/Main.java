package sign_up_practice;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    private User user = null;
    UserDataManager manager = UserDataManager.getInstance();

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        printMenu();
    }

    public void printMenu() {
        while (true) {
            if (user == null) {
                System.out.println("1. 로그인");
                System.out.println("2. 회원가입");
            } else {
                System.out.println("1. 로그아웃");
                System.out.println("2. 회원 탈퇴");
            }
            System.out.print("메뉴 선택: ");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    if (user == null) login();
                    else logout();
                    break;
                case 2:
                    if (user == null) register();
                    else unregister();
                    break;
            }
        }
    }
    public void login() {
        System.out.print("id: ");
        String id = sc.next();
        System.out.print("pw: ");
        String pw = sc.next();
        if(!manager.isMember(id)){
            System.out.println("존재하지 않는 id입니다!");
        }else{
            if(!pw.equals(manager.getUser(id).getPw())){
                System.out.println("비밀번호가 일치하지 않습니다!");
            } else{
                user = manager.getUser(id);
                System.out.println("로그인 되었습니다.");
            }
        }
    }

    public void register() {
        while (true) {
            System.out.print("id: ");
            String id = sc.next();
            if (manager.isMember(id)) {  // 입력한 id와 map의 id가 이미 존재하는 경우
                System.out.println("이미 존재하는 id입니다!");
            } else {
                while(true) {
                    System.out.print("pw: ");
                    String pw1 = sc.next();
                    System.out.print("pw 재입력: ");
                    String pw2 = sc.next();
                    if (!pw1.equals(pw2)) {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    } else {
                        manager.register(id, pw1);
                        System.out.println("회원 등록이 완료되었습니다!");
                        return;
                    }
                }
            }
        }
    }
    public void logout() {
        user = null;
        System.out.println("로그아웃 되었습니다!");
    }

    public void unregister() {
        System.out.print("pw: ");
        String pw = sc.next();
        if(pw.equals(user.getPw())){
            manager.unregister(user);
            user = null;
            System.out.println("회원 탈퇴 되었습니다!");
        }else{
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
}
