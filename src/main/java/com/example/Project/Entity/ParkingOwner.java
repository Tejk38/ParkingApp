package com.example.Project.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="parking_owner")
public class ParkingOwner

{

//    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
//    private List<ParkingLot> parkingLots;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ParkingOwner{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}