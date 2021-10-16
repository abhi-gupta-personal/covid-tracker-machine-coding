package com.abhishek.covidproj.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERPATIENT")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "PINCODE")
    private String pinCode;
    @Column(name = "RESULT")
    private String result;
}
