package company;

public class Employee {
    private int empNo;
    private String name;
    private int salary;

    public Employee(int empNo, String name, int salary) {
        this.empNo = empNo;
        this.name = name;
        this.salary = salary;
    }

    public int getEmployeeNo() {
        return empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int calculateAnnualBonus() {
        int annualSalary = getSalary();
        int bonus;
        if (annualSalary <= 10000) {
            bonus = (int) (annualSalary * 0.10);
        } else if (annualSalary <= 50000) {
            bonus = (int) (annualSalary * 0.07);
        } else {
            bonus = (int) (annualSalary * 0.05);
        }
        return bonus;
    }

    public void increaseSalaryPercent(double percentageIncrease) {
        double increaseFactor = 1 + (percentageIncrease / 100);
        int newSalary = (int) Math.round(getSalary() * increaseFactor);
        setSalary(newSalary);
    }

    public void increaseSalary(int amountIncrease) {
        int newSalary = getSalary() + amountIncrease;
        setSalary(newSalary);
    }
}