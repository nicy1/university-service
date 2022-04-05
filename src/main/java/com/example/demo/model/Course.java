package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String professor;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Faculty faculty;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Collection<Student> students;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
}
