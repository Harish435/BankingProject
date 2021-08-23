package com.hclmini.bankingapp.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="CONTACT_ID")
    private Long id;

    private String emailId;

    private String homePhone;

    private String workPhone;

    public Contacts() {
    }

    public Contacts(Long id, String emailId, String homePhone, String workPhone) {
        this.id = id;
        this.emailId = emailId;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
}
