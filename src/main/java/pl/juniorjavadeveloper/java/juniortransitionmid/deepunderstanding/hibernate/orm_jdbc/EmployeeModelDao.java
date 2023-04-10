package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc;

import pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.value_properties.JdbcPropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeModelDao {

    private static final String INSERT_EMPLOYEE_SQL =
            "INSERT INTO EMPLOYEES(FIRST_NAME, LAST_NAME, DEPARTMENT)" +
                    " VALUES(?, ?, ?);";

    public EmployeeModel create(EmployeeModel employeeModel) {
        EmployeeModel createdEmployeeModel = new EmployeeModel();

        createdEmployeeModel.setFirstName(employeeModel.getFirstName());
        createdEmployeeModel.setLastName(employeeModel.getLastName());
        createdEmployeeModel.setDepartment(employeeModel.getDepartment());

        // NOTE: Connection code must be moved to a separate class and reused!
        try (Connection connection = DriverManager.getConnection(
                JdbcPropertiesHelper.getProperty("jdbc.url"),
                JdbcPropertiesHelper.getProperty("jdbc.username"),
                JdbcPropertiesHelper.getProperty("jdbc.password"));
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_EMPLOYEE_SQL,
                             Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, employeeModel.getFirstName());
            preparedStatement.setString(2, employeeModel.getLastName());
            preparedStatement.setString(3, employeeModel.getDepartment());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                Long generatedKeyId = resultSet.getLong(1);
                createdEmployeeModel.setId(generatedKeyId);
            }

            return createdEmployeeModel;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return createdEmployeeModel;
    }
}
