package company;

public class Main {
    public static void main(String[] args) {
// Create an Employee
        Employee emp1 = new Employee(1, "John Doe", 20000);
// Create a Department
        Department dept = new Department("Engineering");
// Add employee to the department
        dept.addEmployee(emp1);
// search for valid employee
        try {
            Employee foundEmployee = dept.searchForEmployee(1);
            System.out.println("Employee found: " +
                    foundEmployee.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
// search for invalid employee
        try {
            Employee foundEmployee = dept.searchForEmployee(2);
            System.out.println("Employee found: " +
                    foundEmployee.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
// Test deleteEmployee
        boolean deleted = dept.deleteEmployee(1);
        System.out.println("Employee deleted: " + deleted);
    }
}
