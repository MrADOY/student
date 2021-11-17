INSERT INTO UNIVERSITY (id) VALUES (1);

INSERT INTO STUDENT (id, name_student, firstname_student, email, date_of_birth, registration_date, university_id) VALUES
    (1, 'Elliot', 'Alderson', 'eliot.alderson@fsociety.com', TIMESTAMP '1970-01-01T10:00:00', NOW(), 1),
    (2, 'Aurelien', 'Pietrzak', 'pietrzak.aurelien@gmail.com', TIMESTAMP '1970-01-01T10:00:00', NOW() , 1);