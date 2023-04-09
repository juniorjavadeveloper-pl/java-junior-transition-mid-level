package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc;

import pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.value_properties.JdbcPropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModelDao {

    private static final String DB_URL = "jdbc:h2:~/jdbc-database";
    private static final String INSERT_EMPLOYEE_SQL =
            "INSERT INTO EMPLOYEES(ID, FIRST_NAME, LAST_NAME, DEPARTMENT)" +
                    " VALUES(?, ?, ?, ?);";

    public void create(EmployeeModel employeeModel) {
        // NOTE: Connection code must be moved to a separate class and reused!
        try (Connection connection = DriverManager.getConnection(
                JdbcPropertiesHelper.getProperty("jdbc.url"),
                JdbcPropertiesHelper.getProperty("jdbc.username"),
                JdbcPropertiesHelper.getProperty("jdbc.password"));
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            preparedStatement.setLong(1, employeeModel.getId());
            preparedStatement.setString(2, employeeModel.getFirstName());
            preparedStatement.setString(3, employeeModel.getLastName());
            preparedStatement.setString(4, employeeModel.getDepartment());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
