package department;

import company.Department;
import company.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {
    Department accounts = new Department("Accounts");

    @BeforeEach
    public void setUp() throws Exception {
        int [] empIDs = {647, 789, 895};
        String[] empNames = {"Smith, John", "Bloggs, Fred",
                "Jones, Thadeus"};
        int[] salaries = {5000, 30000, 60000};
        for (int x = 0; x<empIDs.length;x++){
            accounts.addEmployee(new Employee(empIDs[x],empNames[x],
                    salaries[x]));
        }
    }

    @Test
    public void testGetName(){
        assertEquals("Accounts",accounts.getDeptName(),"Test get name");
    }

    @Test
    public void testNoOfEmployees(){
        assertEquals(3,accounts.getNoOfEmployees(), "Test no of employees");
    }

    @Test
    public void testSearchForValidEmployee(){
        try {
            Employee e = accounts.searchForEmployee(789);
            assertEquals("Bloggs, Fred",e.getName(),"Test valid search");
        } catch (Exception e) {
            fail("search exception incorrectly thrown");
        }
    }

    @Test
    public void testSearchForInvalidEmployee(){
        try {
            Employee e = accounts.searchForEmployee(999);
            fail("Test invalid search not detected");
        } catch (Exception e) {}
    }

    @Test
    public void testDeleteValidEmployee(){
        boolean result = accounts.deleteEmployee(789);
        assertTrue(result, "testing delete valid employee");
        try {
            Employee e = accounts.searchForEmployee(789);
            fail("employee not deleted");
        } catch (Exception e) {}
    }

    @Test
    public void testDeleteInvalidEmployee(){
        boolean result = accounts.deleteEmployee(999);
        assertFalse(result,"testing delete valid employee");
    }
}