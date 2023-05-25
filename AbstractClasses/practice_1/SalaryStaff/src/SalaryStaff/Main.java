package SalaryStaff;

public class Main {
    public static void main(String[] args) {
        Company company = new Company(80, 10, 180);

        for (int i = 0; i < company.managersCount; i++) {
            Manager manager = new Manager(company);
            company.hire(manager);
            company.income(manager.getIncomeManager());
        }

        for (int i = 0; i < company.operatorsCount; i++) {
            Operator operator = new Operator();
            company.hire(operator);
        }

        for (int i = 0; i < company.topManagersCount; i++) {
            TopManager topManager = new TopManager(company);
            company.hire(topManager);
        }

        System.out.println("Самые высокие зарплаты:\n" + company.getTopSalaryStaff(15));
        System.out.println("Самые низкие зарплаты:\n" + company.getLowestSalaryStaff(30));

        company.setManagersCount(80 / 2);
        company.setOperatorsCount(180 / 2);
        company.setTopManagersCount(10 / 2);

        for (int i = 0; i < company.managersCount; i++) {
            Manager manager = new Manager(company);
            company.fire(manager);
            company.income(-manager.getIncomeManager());
        }

        for (int i = 0; i < company.operatorsCount; i++) {
            Operator operator = new Operator();
            company.fire(operator);
        }

        for (int i = 0; i < company.topManagersCount; i++) {
            TopManager topManager = new TopManager(company);
            company.fire(topManager);
        }

        System.out.printf("После сокращения: " + "Самые высокие зарплаты\n" + company.getTopSalaryStaff(15));
        System.out.println("После сокращения: " + "Самые низкие зарплаты\n" + company.getLowestSalaryStaff(30));
    }
}
