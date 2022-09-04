import Task2.*;

public class Task2 {
    public static void main(String[] args){
        UserList userList = new UserList();
        UserService userService = new UserService(userList);
        userService.start();
    }
}
