package fr.insa.student.ressources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StudentCreateModel implements Serializable {
    private String name;
    private String firstName;
    private String email;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dateOfBirth;
    private Integer universityId;
    private String adresse;
}
