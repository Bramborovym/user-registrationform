package com.xvitcoder.springmvcangularjs.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:19 AM
 */
@Entity
@Table(name = "USER")
public class User {


    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column(name="USERNAME", nullable=false)
    private String username;

    @NotEmpty
    @Column(name="EMAIL", nullable=false)
    private String emailAddress;

    @NotEmpty
    @Column(name="PASSWORD", nullable=false)
    private String password;

    public User() { }

    public User(Long id, String username, String emailAddress, String password) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {return emailAddress;}

    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}





}
