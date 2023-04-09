package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModelDao {

    private static final String DB_URL =
            "jdbc:h2:~/h2database/hibernate-orm-jdbc-database";
    private static final String INSERT_EMPLOYEE_SQL =
            "INSERT INTO EMPLOYEES(ID, FIRST_NAME, LAST_NAME, DEPARTMENT)" +
                    " VALUES(?, ?, ?, ?);";

    public void create(EmployeeModel employeeModel) {
        // NOTE: Connection code must be moved to a separate class and reused!
        try (Connection connection = DriverManager.getConnection(DB_URL, "sa", "");
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
