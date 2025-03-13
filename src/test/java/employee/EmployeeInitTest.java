package employee;

import company.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeInitTest {

    Employee temp;

    @BeforeEach
    public void setUp(){
        temp = new Employee(647, "Smith, Jemima", 25000);
    }

    @Test
    @Tag("production")
    public void testEmployee(){
        assertEquals(647,temp.getEmployeeNo(),"test employee number");
        assertEquals("Smith, Jemima",temp.getName(), "test employee name");
        assertEquals(25000,temp.getSalary(), "test employee salary");
    }

    @Test
    @Tag("development")
    public void testSetName(){
        temp.setName("Bloggs, Jemima");
        assertEquals("Bloggs, Jemima",temp.getName(), "test set name");
    }

    @Test
    @Tag("development")
    public void testSetSalary(){
        temp.setSalary(30000);
        assertEquals(30000,temp.getSalary(), "test set salary");
    }
}
