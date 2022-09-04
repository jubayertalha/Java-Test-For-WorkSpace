package Task2;

import java.time.LocalDateTime;

import Task2.Transaction.TransactionType;

public class UserService implements SystemService {

    UserList users;
    User user;

    public UserService(UserList users) {
        this.users = users;
    }

    public void start(){
        mainMenuControl();
    }

    public void showMainMenu() {
        System.out.println("1. Create User");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void showUserMenu() {
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Show Details");
        System.out.println("5. Logout");
        System.out.print("Enter your choice: ");
    }

    public void mainMenuControl() {
        int choice;
        do {
            showMainMenu();
            choice = takeIntInput();
            switch (choice) {
                case 1:
                    users.createUser();
                    break;
                case 2:
                    user = users.loginUser();
                    if (user != null) {
                        userMenuControl();
                    }
                    break;
                case 3:
                    showMessage("Exited");
                    break;
                default:
                    System.out.println("\nInvalid choice\n");
            }
        } while (choice != 3);
    }

    public void userMenuControl(){
        int choice;
        do {
            showUserMenu();
            choice = takeIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = takeIntInput();
                    LocalDateTime date = LocalDateTime.now();
                    if(user.getAccount().addTransaction(new Transaction(TransactionType.CREDIT, amount, user.getAccount().getBalance()+amount, date)))
                        showMessage("Transaction successful"); 
                    else
                        showMessage("Transaction failed");
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    amount = takeIntInput();
                    if(user.getAccount().addTransaction(new Transaction(Transaction.TransactionType.DEBIT, amount, user.getAccount().getBalance()-amount, LocalDateTime.now())))
                        showMessage("Transaction successful");
                    else
                        showMessage("Transaction failed");
                    break;
                case 3:
                    System.out.print("Enter receiver id: ");
                    int receiverId = takeIntInput();
                    System.out.print("Enter amount: ");
                    amount = takeIntInput();
                    User reciever = users.getUser(receiverId);
                    if(reciever == null || user.getId() == receiverId) {
                        showMessage("Invalid receiver id");
                    }else{
                        if(user.getAccount().addTransaction(new Transaction(Transaction.TransactionType.DEBIT, amount, user.getAccount().getBalance()-amount, LocalDateTime.now()))){
                            reciever.getAccount().addTransaction(new Transaction(Transaction.TransactionType.CREDIT, amount, reciever.getAccount().getBalance()+amount, LocalDateTime.now()));
                            showMessage("Transaction successful");
                        }else{
                            showMessage("Transaction failed");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nUser Name: " + user.getName());
                    System.out.println("Balance: " + user.getAccount().getBalance());
                    System.out.println("Transactions: ");
                    if(user.getAccount().getTransactions().size() == 0){
                        System.out.println("\n***********************");
                        System.out.println("\nNo transactions\n");
                        System.out.println("***********************\n");
                    }
                    for (Transaction transaction : user.getAccount().getTransactions()) {
                        transaction.display();
                    }
                    System.out.println();
                    break;
                case 5:
                    showMessage("Logged out successfully");
                    break;
                default:
                    System.out.println("\nInvalid choice\n");
            }
        } while (choice != 5);
    }
}
