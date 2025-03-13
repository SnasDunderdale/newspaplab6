package company;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;

public class Department {
    ArrayList<Employee> employees = new ArrayList();
    String deptName;
    int noOfEmployees = 0;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public int getNoOfEmployees() {
        return this.noOfEmployees;
    }

    public void addEmployee(Employee e) {
        ++this.noOfEmployees;
        this.employees.add(e);
        if(logger.isInfoEnabled()){
            logger.info("Employee added : " + e.getName());
        }
    }

    public Employee searchForEmployee(int empNo) throws Exception {
        Iterator i$ = this.employees.iterator();

        Employee e;
        do {
            if (!i$.hasNext()) {
                logger.error("Error in employee search : " + empNo);
                throw new Exception("Employee not found");
            }

            e = (Employee)i$.next();
        } while(e.getEmployeeNo() != empNo);

        return e;

    }

    public boolean deleteEmployee(int empNo) {
        Iterator iter = this.employees.listIterator();

        for(int i = 0; iter.hasNext(); ++i) {
            Employee e = (Employee)iter.next();
            if (e.getEmployeeNo() == empNo) {
                this.employees.remove(i);
                --this.noOfEmployees;
                return true;
            }
        }

        return false;
    }
    final static Logger logger = Logger.getLogger(Department.class);
}
