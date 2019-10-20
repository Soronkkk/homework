package com.simbirsoft.homework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class User extends AbstractCreatedInfo {


    /**
     * Логин пользователя.
     */
    @Column(unique = true, name = "LOGIN", nullable = false)
    private String login;

    /**
     * Пароль пользователя.
     */
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    /**
     * Имя пользователя.
     */
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    /**
     * Роли пользователя.
     */
    @OneToMany(mappedBy = "user")
    private List<Role> roles;

    public User() {
    }

    public User(Long id, String login, String password, String firstName, String lastName) {
        super(id);
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.roles = new ArrayList<Role>(Collections.singleton(RoleConstants.ROLE_USER));
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, firstName, lastName, roles);
    }
}
