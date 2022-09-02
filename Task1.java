import Task1.*;

public class Task1 {
    public static void main(String[] args) {
        Employee rahim = new PermanentEmployee(1, "Rahim", 80000);
        Employee zakir = new PermanentEmployee(2, "Zakir");
        Employee karim = new ContractualEmployee(3, "Karim", 20000);
        Employee habib = new TemporaryEmployee(4, "Habib");

        EmployeeList empList = new EmployeeList();
        empList.add(rahim);
        empList.add(zakir);
        empList.add(karim);
        empList.add(habib);

        empList.displayBonus();
        System.out.println("----------------------------------");
        empList.displayProvientFund();
    }
}