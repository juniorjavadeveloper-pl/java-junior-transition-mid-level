package pl.juniorjavadeveloper.java.juniortransitionmid.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc.EmployeeModel;
import pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc.EmployeeModelDao;

class EmployeeServiceMockTest {

    private static final long EMPLOYEE_MODEL_ID_1 = 1L;

    @Test
    void register() {
        // given
        EmployeeModelDao employeeModelDaoMock = Mockito.mock(EmployeeModelDao.class);
        EmployeeService employeeService = new EmployeeService(employeeModelDaoMock);

        EmployeeModel employeeModel = new EmployeeModel(null, "Tim", "Cook", "Sales");
        EmployeeModel registeredEmployeeModelMock = new EmployeeModel(EMPLOYEE_MODEL_ID_1, "Tim", "Cook", "Sales");

        // when
        Mockito.when(employeeService.register(employeeModel)).thenReturn(registeredEmployeeModelMock);
        EmployeeModel registeredEmployeeModel = employeeService.register(employeeModel);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(registeredEmployeeModel, "registeredEmployeeModel is NULL"),
                () -> Assertions.assertNotNull(registeredEmployeeModel.getId(), "registeredEmployeeModel ID is NULL"),
                () -> Assertions.assertEquals(EMPLOYEE_MODEL_ID_1, registeredEmployeeModel.getId(), "registeredEmployeeModel ID is not equals")
        );
    }
}