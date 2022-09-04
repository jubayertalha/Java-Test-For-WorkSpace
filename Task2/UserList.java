package Task2;

import java.util.ArrayList;

public class UserList extends ArrayList<User> implements SystemService{
    public UserList() {
        super();
    }

    public void createUser() {
        System.out.print("Enter user id: ");
        int id = takeIntInput();
        System.out.print("Enter user name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter user password: ");
        String password = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = takeIntInput();
        for(User user : this){
            if(user.getId() == id){
                showMessage("User already exists");
                return;
            }
        }
        showMessage("User created successfully");
        User user = new User(id, name, password, new Account(balance));
        super.add(user);
    }

    public User loginUser() {
        System.out.print("Enter user id: ");
        int id = takeIntInput();
        scanner.nextLine();
        System.out.print("Enter user password: ");
        String password = scanner.nextLine();
        for (User user : this) {
            if (user.getId() == id && user.getPassword().equals(password)) {
                showMessage("User logged in successfully");
                return user;
            }
        }
        showMessage("Invalid user id or password");
        return null;
    }

    public User getUser(int id){
        for (User user : this) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
