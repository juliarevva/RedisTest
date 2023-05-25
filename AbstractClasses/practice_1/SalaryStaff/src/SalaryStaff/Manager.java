package SalaryStaff;

public class Manager implements Employee{

    private int incomeManager = (int) (115_000 + Math.random() * (140_000 - 115_000));
    private int monthSalary;
    private int fixedPartOfSalary = 60_000;

    private final Company company;

    public Manager(Company company) {
        this.company = company;
        this.monthSalary = (int) (fixedPartOfSalary + incomeManager * 0.05);
    }

    public int getIncomeManager() { return incomeManager; }

    @Override
    public int getMonthSalary() { return monthSalary; }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.\n";
    }
}
