package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.hibernate.orm_jdbc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

    public UserEntity() {
    }

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
