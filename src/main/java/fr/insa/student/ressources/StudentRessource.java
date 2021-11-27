package fr.insa.student.ressources;

import fr.insa.student.exception.FonctionnalProcessException;
import fr.insa.student.exception.ModelNotValidException;
import fr.insa.student.models.Student;
import fr.insa.student.ressources.dto.StudentCreateModel;
import fr.insa.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentRessource extends CommonResource {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudent(@RequestParam(name = "marks", required = false, defaultValue = "0") Integer age) {
        return this.studentService.getAllStudent(age);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable("id") int id) throws Exception {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentCreateModel studentToCreate) throws FonctionnalProcessException {
        validateStudentModel(studentToCreate);
        return this.studentService.saveStudent(studentToCreate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    private void validateStudentModel(StudentCreateModel studentToCreate) throws ModelNotValidException {
        ModelNotValidException ex = new ModelNotValidException();

        if(studentToCreate == null) {
            ex.getMessages().add("StudentCreateModel : null");
        }

        if(studentToCreate.getEmail() == null || studentToCreate.getEmail().isBlank()) {
            ex.getMessages().add("email est vide");
        }
        if(studentToCreate.getName() == null || studentToCreate.getName().isBlank()) {
            ex.getMessages().add("name est vide");
        }
        if(studentToCreate.getFirstName() == null ||  studentToCreate.getFirstName().isBlank()) {
            ex.getMessages().add("firstname est vide");
        }
        if(studentToCreate.getDateOfBirth() == null) {
            ex.getMessages().add("dateOfBirth null");
        }
        if(studentToCreate.getAdresse() == null) {
            ex.getMessages().add("Adresse null");
        }
        if(!ex.getMessages().isEmpty()) {
            throw ex;
        }
    }
}
