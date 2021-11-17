package fr.insa.student.service;

import fr.insa.student.exception.FonctionnalProcessException;
import fr.insa.student.models.Student;
import fr.insa.student.models.University;
import fr.insa.student.repositories.StudentRepository;
import fr.insa.student.ressources.dto.StudentCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityService universityService;

    /**
     * Save a student in the databse
     * @param studentToCreate Model of the student to create.
     * @return The entity saved in database @see Student
     */
    @Transactional(rollbackOn = Exception.class)
    public Student saveStudent(StudentCreateModel studentToCreate) throws FonctionnalProcessException {

        University university = universityService.getUniversityById(studentToCreate.getUniversityId());

        Student s = Student.builder()
                .email(studentToCreate.getEmail())
                .firstName(studentToCreate.getFirstName())
                .name(studentToCreate.getName())
                .dateOfBirth(studentToCreate.getDateOfBirth())
                .registrationDate(new Date())
                .university(university)
                .adresse(studentToCreate.getAdresse())
                .build();

        return this.studentRepository.save(s);
    }

    public Student getStudentById(int id) throws Exception {
        return this.studentRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Student> getAllStudent(int age) {
        return this.studentRepository
                .findAll()
                .stream()
                .filter(s -> {
                    Calendar registrationDateInCalender = Calendar.getInstance();
                    registrationDateInCalender.setTime(s.getRegistrationDate());
                    registrationDateInCalender.get(Calendar.YEAR);
                    return age >= Calendar.getInstance().get(Calendar.YEAR) - registrationDateInCalender.get(Calendar.YEAR);
                })
                .collect(Collectors.toList());
    }

    public void deleteStudent(int id) {
        this.studentRepository.deleteById(id);
    }
}
