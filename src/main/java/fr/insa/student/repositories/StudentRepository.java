package fr.insa.student.repositories;

import fr.insa.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT COUNT(s) FROM Student s WHERE s.university.id = :university_id")
    public int numberOfStudent(@Param("university_id") int universityId);

    public List<Student> findByName(String name);
}
