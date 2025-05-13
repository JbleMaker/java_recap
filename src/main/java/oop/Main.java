package oop;

public class Main {
    public static void main(String[] args) {
//        BasicUserRepository basicUserRepository = new BasicUserRepository();
//        CustomUserRepository customUserRepository = new CustomUserRepository();

        BasicUserService userService = new BasicUserService(new CustomUserRepository());

        userService.addUser();
    }
}
