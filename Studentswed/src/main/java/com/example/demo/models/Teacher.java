
package com.example.demo.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  @Column(name ="id")
    private  Long id;

    private String name;
    private String email;




    // @ManyToOne
    // @JoinColumn(name = "subject_id", nullable = false)
    // private Subject subject;


    @OneToMany(mappedBy="teacher" ,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Subject>subjects;

}