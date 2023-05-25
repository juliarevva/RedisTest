package SalaryStaff;

public class Operator implements Employee{

    @Override
    public int getMonthSalary() {
        return 70_000;
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.\n";
    }
}

