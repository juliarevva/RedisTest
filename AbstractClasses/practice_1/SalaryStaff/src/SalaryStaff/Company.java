package SalaryStaff;

import java.util.*;

public class Company {

    protected int managersCount;
    protected int topManagersCount;
    protected int operatorsCount;

    public void setManagersCount(int managersCount) {
        this.managersCount = managersCount;
    }

    public void setTopManagersCount(int topManagersCount) {
        this.topManagersCount = topManagersCount;
    }

    public void setOperatorsCount(int operatorsCount) {
        this.operatorsCount = operatorsCount;
    }

    private int incomeCompany;

    public Company(int managersCount, int topManagersCount, int operatorsCount) {
        this.managersCount = managersCount;
        this.topManagersCount = topManagersCount;
        this.operatorsCount = operatorsCount;
    }

    public void income(int amount) {
        incomeCompany += amount;
    }

    public int getIncomeCompany() {
        return incomeCompany;
    }

    ArrayList<Employee> listOfSalary = new ArrayList<>();

    public void hire(Employee employee) {
        listOfSalary.add(employee);
    }

    public void hireALL(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            hire(employee);
        }
    }

    public void fire(Employee employee) {
        listOfSalary.remove(employee);
    }

    Comparator<Employee> employeeComparator = Comparator.comparing(Employee::getMonthSalary);

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        listOfSalary.sort(employeeComparator);
        Collections.reverse(listOfSalary);
        ArrayList<Employee> topSalary = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            topSalary.add(listOfSalary.get(i));
        }
        return topSalary;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        listOfSalary.sort(employeeComparator);
        ArrayList<Employee> topSalary = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            topSalary.add(listOfSalary.get(i));
        }
        return topSalary;
    }


}
