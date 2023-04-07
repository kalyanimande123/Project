package com.courseoffering.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOffering {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String courseTitle;

    @Column
    private String instructor;

    @Column
    private LocalDate date;

    @Column
    private int minEmployees;

    @Column
    private int maxEmployees;




    @OneToMany
    private List<Employee> registrationList = new ArrayList<>();

    @OneToMany
    private List<Employee> allottedList = new ArrayList<>();


    private boolean isCancelled = false;

    public String registerEmployee(Employee employee) {

        return null;
    }

    public String cancelRegistration(Employee employee) {
        return null;
    }


    public void allotEmployees() {
    }
}
