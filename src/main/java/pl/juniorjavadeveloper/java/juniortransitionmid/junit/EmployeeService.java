package pl.juniorjavadeveloper.java.juniortransitionmid.junit;

import pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc.EmployeeModel;
import pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc.EmployeeModelDao;

public class EmployeeService {
    private final EmployeeModelDao employeeModelDao;

    public EmployeeService(EmployeeModelDao employeeModelDao) {
        this.employeeModelDao = employeeModelDao;
    }

    public EmployeeModel register(EmployeeModel employeeModel) {
        return employeeModelDao.create(employeeModel);
    }
}
