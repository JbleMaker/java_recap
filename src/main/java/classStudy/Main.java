package classStudy;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

class UserAndAdminRepository {
    List<User> userList = new ArrayList<>();
    private static UserAndAdminRepository instance;
    // 단일 객체를 참조할 정적 참조변수

    private UserAndAdminRepository(){}
    // new 키워드를 사용할 수 없도록 생성자에 private 지정.

    static UserAndAdminRepository getInstance(){
        if(instance == null){
            instance = new UserAndAdminRepository();
        }
        return instance;
        // 단일 객체 반환을 위한 정적 메서드
    }

    void insert() {
        userList.add(new User());
        System.out.println("사용자 또는 관리자 정보 추가");
    }

    void delete() {
        userList.remove(new User());
            System.out.println("사용자 또는 관리자 정보 삭제");
    }
}

class UserService {
    void addUser(){
        UserAndAdminRepository.getInstance().insert();
    }
    void deleteUser(){
        UserAndAdminRepository.getInstance().delete();
    }
}

class AdminService{
    void addAdmin(){
        UserAndAdminRepository.getInstance().insert();
    }
    void deleteAdmin(){
        UserAndAdminRepository.getInstance().delete();
    }
}


class User {
    static String userType = "사용자";
    String username = "";
    String password = "";
}

public class Main {
    public static void main(String[] args) {
        System.out.println(User.userType);
        User user = new User();

        user.username = "김종보";
        user.password = "1234";

        UserService userService = new UserService();
        AdminService adminService = new AdminService();

        userService.addUser();
        userService.deleteUser();

        adminService.addAdmin();
        adminService.deleteAdmin();
    }
}
