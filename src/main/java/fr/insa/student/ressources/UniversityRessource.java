package fr.insa.student.ressources;

import fr.insa.student.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("university")
public class UniversityRessource extends CommonResource {

    @Autowired
    UniversityService universityService;

    @GetMapping("{id}/count-student")
    public int getNumberOfStudent(@PathVariable("id") int id){
        return this.universityService.numberOfStudents(id);
    }
}
