package Task1;

public interface EmployeeService {
    default double getBonusSalary(){
        return 0;
    }
    default boolean getProvidentFund(){
        return false;
    }
    default double roundSalary(double salary) {
        return Math.round(salary * 100) / 100.0;
    }
}
