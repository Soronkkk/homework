package com.simbirsoft.homework.model;

import com.simbirsoft.homework.constants.RoleConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class User extends AbstractIdEntity {

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
    @Column(name = "ROLE", nullable = false)
    private List<Role> roles;

    public User() {
    }

    public User(Long id, String login, String password, String firstName, String lastName) {
        super(id);
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<Role>(Collections.singleton(RoleConstants.ROLE_USER));
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
}
