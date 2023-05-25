package SalaryStaff;

public class TopManager implements Employee{

    private final Company company;
    private int fixedPartOfSalary = 100_000;

    public TopManager (Company company) {
        this.company = company;
    }

    private int bonus() {
        if (company.getIncomeCompany() > 10_000_000) {
            return (int) (fixedPartOfSalary * 1.5);
        }
        return 0;
    }

    @Override
    public int getMonthSalary() {
        return fixedPartOfSalary + bonus();
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.\n";
    }
}
