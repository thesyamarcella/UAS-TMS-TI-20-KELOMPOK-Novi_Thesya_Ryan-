package com.acarainservices.acarainservices.user;

import java.io.Serializable;
// import java.util.HashSet;
import java.util.Set;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
// import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
// import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.acarainservices.acarainservices.events.Events;
import com.acarainservices.acarainservices.orders.Orders;

@Entity
@Table(name = "user") // ini nama table
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(length = 15)
    @NotEmpty(message = "Username is required")
    private String username;

    @Column(length = 30)
    @NotEmpty(message = "Full name is required")
    private String fullName;

    @Column(length = 50)
    @NotEmpty(message = "Email is required")
    private String email;

    // @ManyToMany
    // @JoinTable(name = "users_orders", joinColumns = @JoinColumn(name =
    // "user_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    // private Set<Orders> orders;

    // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    // @JoinColumn
    // private Orders orders;

    // @OneToOne(targetEntity = Events.class, mappedBy = "user", cascade =
    // CascadeType.ALL)
    // private Set<Events> events = new HashSet<>();

    public User() {
    }

    public User(int id, @NotEmpty(message = "Password is required") String password,
            @NotEmpty(message = "Username is required") String username,
            @NotEmpty(message = "Full name is required") String fullName,
            @NotEmpty(message = "Email is required") String email, Orders orders, Set<Events> events) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        // this.orders = orders;
        // this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public Orders getOrders() {
    // return orders;
    // }

    // public void setOrders(Orders orders) {
    // this.orders = orders;
    // }

    // public Set<Events> getEvents() {
    // return events;
    // }

    // public void setEvents(Set<Events> events) {
    // this.events = events;
    // }

    // public Set<Events> getEvents() {
    // return events;
    // }

    // public void setEvents(Set<Events> events) {
    // this.events = events;
    // }

}
