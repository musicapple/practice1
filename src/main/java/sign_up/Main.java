package sign_up;

import java.util.InputMismatchException;
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
        new Main();
    }

    private final Scanner sc;
    User user = null;
    UserDataManager manager = UserDataManager.getInstance();

    private Main() {
        sc = new Scanner(System.in);
        while (true) {
            printMenu();
        }
    }

    private void printMenu() {
        if (user == null) {
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.print("선택: ");
        } else {
            System.out.println("1. 로그아웃");
            System.out.println("2. 회원 탈퇴");
        }
        try {
            int select = sc.nextInt();
            // 오류가 없는 구역
            switch (select) {
                case 1:
                    if (user == null) login();
                    else logout();
                    break;
                case 2:
                    if (user == null) register();
                    else unregister();
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
                    break;
            }

        } catch (InputMismatchException exception) {
            System.out.println("숫자를 입력하세요!!");
        }

    }

    // 로그인 성공하면 멤버 변수 user에 해당 유저 대입
    private void login() {
        System.out.print("id: ");
        String id = sc.next();
        System.out.print("pw: ");
        String pw = sc.next();
        if (!manager.isMember(id)) {
            System.out.println("회원이 아닙니다.");
        } else {
            if (manager.getUser(id).getPw().equals(pw)) {
                System.out.println(manager.getUser(id).getId() + "님 환영합니다!");
                user = manager.getUser(id);
            } else {
                System.out.println("비밀번호가 틀렸습니다 ㅠ");
            }
        }
    }

    // 회원가입 할 때, 비밀번호를 두 번 입력받음
    private void register() {
        while (true) {
            System.out.print("id: ");
            String id = sc.next();
            if (manager.isMember(id)) {
                System.out.println("이미 존재하는 아이디입니다!");
            } else {
                // id가 존재하지 않으면 else로 넘어감
                while (true) {
                    System.out.print("pw: ");
                    String pw1 = sc.next();
                    System.out.println("pw를 한번 더 입력하세요!");
                    System.out.print("pw: ");
                    String pw2 = sc.next();
                    if (pw1.equals(pw2)) {
                        manager.register(id, pw1);
                        System.out.println("회원이 등록되었습니다!!");
                        return;
                    } else {
                        System.out.println("입력하신 비밀번호가 서로 다릅니다!");
                    }
                }
            }
        }
    }
        // 멤버 변수의 user를 null값으로 대입
        private void logout () {
            user = null;
            System.out.println("로그아웃 되었습니다!");
        }

        // 회원 탈퇴인데, 비밀번호를 입력받고 멤버변수의 user의 비밀번호와 일치하면 탈퇴시킴
        private void unregister () {
            System.out.println("pw : ");
            String pw = sc.next();
            if (pw.equals(user.getPw())) {
                manager.unregister(user);
                user = null;
                System.out.println("회원 탈퇴되었습니다.");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }