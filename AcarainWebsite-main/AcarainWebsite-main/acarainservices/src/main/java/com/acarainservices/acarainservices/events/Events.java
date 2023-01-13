package com.acarainservices.acarainservices.events;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.acarainservices.acarainservices.user.User;

@Entity
@Table(name = "events") // anotasi berisi nama table
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;

    // atribut berisi nama field/column pada tabel

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(length = 100)
    @NotEmpty(message = "Title is required")
    private String title;

    @Column(length = 20)
    @NotEmpty(message = "Organizer is required")
    private String organizer;

    @Column(length = 20)
    private String tag;

    @Column(length = 20)
    @NotEmpty(message = "Type is required")
    private String type;

    @Column(length = 20)
    @NotEmpty(message = "tCategory is required")
    private String Category;

    @Column(length = 50)
    @NotEmpty(message = "Location is required")
    private String location;

    @Column(columnDefinition = "DATE")
    @NotEmpty(message = "Datestart is required")
    private Date dateStart;

    @Column(columnDefinition = "TIME")
    @NotEmpty(message = "Timestart is required")
    private Time timeStart;

    @Column(columnDefinition = "DATE")
    @NotEmpty(message = "Dateend is required")
    private Date dateEnd;

    @Column(columnDefinition = "TIME")
    @NotEmpty(message = "Timeend is required")
    private Time timeEnd;

    @Column(length = 500)
    @NotEmpty(message = "Description is required")
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Events() {
    }

    public Events(int id, @NotEmpty(message = "Title is required") String title,
            @NotEmpty(message = "Organizer is required") String organizer, String tag,
            @NotEmpty(message = "Organizer is required") String type,
            @NotEmpty(message = "type is required") String category,
            @NotEmpty(message = "Location is required") String location,
            @NotEmpty(message = "Datestart is required") Date dateStart,
            @NotEmpty(message = "Timestart is required") Time timeStart,
            @NotEmpty(message = "Dateend is required") Date dateEnd,
            @NotEmpty(message = "Timeend is required") Time timeEnd,
            @NotEmpty(message = "Description is required") String description, User user) {
        Id = id;
        this.title = title;
        this.organizer = organizer;
        this.tag = tag;
        this.type = type;
        Category = category;
        this.location = location;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.dateEnd = dateEnd;
        this.timeEnd = timeEnd;
        this.description = description;
        this.user = user;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}