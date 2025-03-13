package employee;

import company.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeSalaryTest {
    ArrayList<Employee> employees = new ArrayList<Employee>();

    @BeforeEach
    public void setUp(){
        int [] empIDs = {647, 789, 895};
        String[] empNames = {"Smith, John", "Bloggs, Fred",
                "Jones, Thadeus"};
        int[] salaries = {5000, 30000, 60000};
        for (int x = 0; x<empIDs.length;x++){
            employees.add(new Employee(empIDs[x],empNames[x],salaries[x]));
        } }

    @Test
    @Tag("production")
    public void testCalculateAnnualBonus(){
        int[] bonuses = {500,2100,3000};
        int i=0;
        for (Employee e : employees){
            int bonus = e.calculateAnnualBonus();
            assertEquals(bonuses[i],bonus, "Test annual bonus for "+e.getSalary());
            i++;
        }
    }

    @Test
    @Tag("development")
    public void testIncreaseSalaryPercent(){
        int[] newSalaries = {5250,31500,63000};
        int i=0;
        for (Employee e : employees){
            e.increaseSalaryPercent(5);
            assertEquals(newSalaries[i],e.getSalary(), "Test increase salary % for "+e.getSalary());
            i++;
        }
    }

    @Test
    @Tag("development")
    public void testIncreaseSalary(){
        int[] salaryIncreases = {300,2500,6000};
        int[] newSalaries = {5300,32500,66000};
        int i=0;
        for (Employee e : employees){
            e.increaseSalary(salaryIncreases[i]);
            assertEquals(newSalaries[i],e.getSalary(),"Test increase salary for "+e.getSalary());
            i++;
        }
    }
}