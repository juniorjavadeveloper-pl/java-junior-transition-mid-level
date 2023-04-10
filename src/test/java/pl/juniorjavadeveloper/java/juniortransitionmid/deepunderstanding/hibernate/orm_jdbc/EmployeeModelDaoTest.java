package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeModelDaoTest {

    @Test
    void create() {
        // given
        EmployeeModelDao employeeModelDao = new EmployeeModelDao();
        EmployeeModel employeeModel= new EmployeeModel();
        employeeModel.setFirstName("John");
        employeeModel.setLastName("Doe");
        employeeModel.setDepartment("IT");

        // when
        EmployeeModel createdEmployeeModel = employeeModelDao.create(employeeModel);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdEmployeeModel, "createdEmployeeModel is NULL"),
                () -> Assertions.assertNotNull(createdEmployeeModel.getId(), "createdEmployeeModel ID is NULL")
        );
    }
}