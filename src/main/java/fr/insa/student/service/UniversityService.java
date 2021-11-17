package fr.insa.student.service;

import fr.insa.student.exception.FonctionnalProcessException;
import fr.insa.student.models.University;
import fr.insa.student.repositories.StudentRepository;
import fr.insa.student.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private static final String UNIVERSITY_NOT_FOUND = "Université non trouvée avec l'id : %s";

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private StudentRepository studentRepository;

    public University getUniversityById(Integer id) throws FonctionnalProcessException {
        University university =
                universityRepository
                        .findById(id)
                        .orElseThrow(() -> new FonctionnalProcessException(String.format(UNIVERSITY_NOT_FOUND, id)));
        return university;
    }

    public int numberOfStudents(int universityId) {
        return this.studentRepository.numberOfStudent(universityId);
    }

}
