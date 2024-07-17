package com.example.demo.models;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;




    // @JoinColumn: Specifies the foreign key column (teacher_id) in the subjects table that links to the primary key (id) in the teachers table.




    //  @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    // private Teacher teacher;

}