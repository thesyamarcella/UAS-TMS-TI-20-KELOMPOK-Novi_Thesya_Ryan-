package com.acarainservices.acarainservices.orders;

import java.io.Serializable;
// import java.util.Set;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
// import javax.persistence.ManyToMany;
// import javax.persistence.OneToMany;
// import javax.persistence.MapsId;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToOne;
// import javax.persistence.JoinTable;
// import javax.validation.constraints.Min;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.acarainservices.acarainservices.ticket.Ticket;
// import com.acarainservices.acarainservices.events.Events;
import com.acarainservices.acarainservices.user.User;

@Entity
@Table(name = "user_orders") // anotasi berisi nama table

public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    // atribut berisi nama field/column pada tabel
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserOrder;

    @Column(length = 20)
    @NotEmpty(message = "Jumlah Ticket is required")
    private String jumlahTicket;

    @Column(length = 20)
    @NotEmpty(message = "Total is required")
    private String Total;

    // @ManyToMany(mappedBy = "orders")
    // private Set<User> user;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Orders() {
    }

    public Orders(int idUserOrder, @NotEmpty(message = "Jumlah Ticket is required") String jumlahTicket,
            @NotEmpty(message = "Total is required") String total, User user, Ticket ticket) {
        this.idUserOrder = idUserOrder;
        this.jumlahTicket = jumlahTicket;
        Total = total;
        this.user = user;
        this.ticket = ticket;
    }

    public int getIdUserOrder() {
        return idUserOrder;
    }

    public void setIdUserOrder(int idUserOrder) {
        this.idUserOrder = idUserOrder;
    }

    public String getJumlahTicket() {
        return jumlahTicket;
    }

    public void setJumlahTicket(String jumlahTicket) {
        this.jumlahTicket = jumlahTicket;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}
