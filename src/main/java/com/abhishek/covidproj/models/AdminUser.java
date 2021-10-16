package com.abhishek.covidproj.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADMINUSER")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "PINCODE")
    private String pinCode;
}

