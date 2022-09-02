package Task1;

import java.util.ArrayList;

public class EmployeeList extends ArrayList<Employee> {
    
    public EmployeeList() {
        super();
    }

    public void displayBonus() {
        for (Employee e : this) {
            System.out.println("Employee ID: " + e.getId() 
                                + " Employee Name : " + e.getName() 
                                + " Employee Bonus : " + e.getBonusSalary());
        }
    }

    public void displayProvientFund() {
        for (Employee e : this) {
            System.out.println("Employee ID: " + e.getId() 
                                + " Employee Name : " + e.getName() 
                                + " Employee s eligible for Proviennt Fund : " 
                                + e.getProvidentFund());
        }
    }
}
