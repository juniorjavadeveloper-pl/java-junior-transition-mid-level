package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc;

public class EmployeeModel {
    private Long id;

    private String firstName;
    private String lastName;

    private String department;

    public EmployeeModel() {
    }

    public EmployeeModel(Long id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    // getters/setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
