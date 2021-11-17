package fr.insa.student.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity // La table
// Lombok
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_student")
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    @Column(name = "firstname_student")
    private String firstName;

    @Email
    @NotBlank
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    private String adresse;

    @ManyToOne
    @JsonIgnore
    private University university;
}
