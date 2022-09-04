package Task2;

import java.util.Scanner;

public interface SystemService {
    public Scanner scanner = new Scanner(System.in);
    public default int takeIntInput(){
        try{
            int n = scanner.nextInt();
            if(n < 1){
                throw new Exception();
            }else{
                return n;
            }
        }catch(Exception e){
            System.out.println("Invalid input");
            System.out.print("Enter again: ");
            scanner.nextLine();
            return takeIntInput();
        }
    }
    public default void showMessage(String message){
        System.out.println();
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }
        System.out.println(message);
        System.out.println();
    }
}
