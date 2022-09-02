package Task1;

public class PermanentEmployee extends Employee {

    public PermanentEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    public PermanentEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    public double getBonusSalary() {
        return roundSalary(getSalary()/2);
    }

    @Override
    public boolean getProvidentFund() {
        return true;
    }
}