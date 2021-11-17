package fr.insa.student.ressources;

import fr.insa.student.exception.FonctionnalProcessException;
import fr.insa.student.exception.ModelNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CommonResource {

    @ExceptionHandler(ModelNotValidException.class)
    public ResponseEntity<String> handleModelNotValidException(
            ModelNotValidException ex
    ) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessages().toString());
    }

    @ExceptionHandler(FonctionnalProcessException.class)
    public ResponseEntity<String> handleFonctionnalProcessException(
            FonctionnalProcessException ex
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}
