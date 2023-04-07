package com.courseoffering.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long empId;

    @Column
    private String empName;

    @Column(name = "MOBILE_NUMBER")
    @NotEmpty(message = "Please provide a mobileNumber")
    private String mobileNumber;

}
