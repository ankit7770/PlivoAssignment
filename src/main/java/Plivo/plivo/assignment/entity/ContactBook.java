package Plivo.plivo.assignment.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Table
@Entity
@SequenceGenerator(name="id", sequenceName="id")
public class ContactBook {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="id")
    private int id;

    @Column
    private String name;

    @Column(unique=true)
    private String emailAddress;

    @Column
    private String mobileNumber;

    @Column
    private String address;

    ContactBook(){

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

    public ContactBook(String name, String emailAddress, String mobileNumber, String address) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ContactBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
