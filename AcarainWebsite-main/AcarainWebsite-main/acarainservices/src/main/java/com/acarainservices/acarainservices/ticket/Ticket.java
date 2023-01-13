package com.acarainservices.acarainservices.ticket;

// import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

// import javax.persistence.CascadeType;
// import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.acarainservices.acarainservices.events.Events;
import com.acarainservices.acarainservices.orders.Orders;

@Entity
@Table(name = "ticket") // anotasi berisi nama table

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    @NotEmpty(message = "Name Title is required")
    private String name;

    @Column(length = 20)
    @NotEmpty(message = "Capacity is required")
    private String kapasitas;

    @Column(length = 200)
    @NotEmpty(message = "Description is required")
    private String deskripsi;

    @Column(length = 20)
    @NotEmpty(message = "Price is required")
    private Integer harga;

    @Column(length = 20)
    @NotEmpty(message = "Start Date is required")
    private Date startDate;

    @Column(length = 20)
    @NotEmpty(message = "End Date is required")
    private Date endDate;

    @Column(length = 20)
    @NotEmpty(message = "Start Time is required")
    private Time startTime;

    @Column(length = 20)
    @NotEmpty(message = "End Time is required")
    private Time endTime;

    @Column(length = 2)
    @NotEmpty(message = "Number of Orders is required")
    private Integer maxOrders;

    // @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    // @JoinColumn
    // private Orders orders;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events events;

    public Ticket() {
    }

    public Ticket(int id, @NotEmpty(message = "Name Title is required") String name,
            @NotEmpty(message = "Capacity is required") String kapasitas,
            @NotEmpty(message = "Description is required") String deskripsi,
            @NotEmpty(message = "Price is required") Integer harga,
            @NotEmpty(message = "Start Date is required") Date startDate,
            @NotEmpty(message = "End Date is required") Date endDate,
            @NotEmpty(message = "Start Time is required") Time startTime,
            @NotEmpty(message = "End Time is required") Time endTime,
            @NotEmpty(message = "Number of Orders is required") Integer maxOrders, Orders orders, Events events) {
        this.id = id;
        this.name = name;
        this.kapasitas = kapasitas;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxOrders = maxOrders;
        // this.orders = orders;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(Integer maxOrders) {
        this.maxOrders = maxOrders;
    }

    // public Orders getOrders() {
    // return orders;
    // }

    // public void setOrders(Orders orders) {
    // this.orders = orders;
    // }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

}
