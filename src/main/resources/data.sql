DELETE FROM Course;
DELETE FROM Etudiant;
DELETE FROM Inscriptions;
DELETE FROM User;
DELETE FROM Authority;

INSERT INTO Course (id, libelle, ects) VALUES ('INT1', 'Introductions', 10);
INSERT INTO Course (id, libelle, ects) VALUES ('MAT1', 'Mathématiques II', 3);
INSERT INTO Course (id, libelle, ects) VALUES ('CAI1', 'Anglais I', 2);
INSERT INTO Course (id, libelle, ects) VALUES ('DEV1', 'Développement I', 10);
INSERT INTO Course (id, libelle, ects) VALUES ('DEV2', 'Développement II', 10);
INSERT INTO Course (id, libelle, ects) VALUES ('WEBG2', 'Développement web I', 2);

INSERT INTO Etudiant (matricule, name) VALUES (43197, 'Philippe');
INSERT INTO Etudiant (matricule, name) VALUES (49737, 'Antony');
INSERT INTO Etudiant (matricule, name) VALUES (47993, 'Logan');
INSERT INTO Etudiant (matricule, name) VALUES (40001, 'Henry');
INSERT INTO Etudiant (matricule, name) VALUES (40002, 'Patrick');

INSERT INTO Inscriptions (course_id, student_id) VALUES ('INT1', 43197);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('INT1', 49737);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('INT1', 47993);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('INT1', 40001);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('MAT1', 43197);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('MAT1', 49737);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('MAT1', 47993);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('MAT1', 40001);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('CAI1', 43197);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('CAI1', 49737);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('CAI1', 47993);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('CAI1', 40001);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('DEV1', 43197);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('DEV1', 49737);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('DEV1', 47993);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('DEV1', 40001);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('WEBG2', 43197);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('WEBG2', 49737);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('WEBG2', 47993);
INSERT INTO Inscriptions (course_id, student_id) VALUES ('WEBG2', 40001);


INSERT INTO User (username, password, enabled) values ('40001','{bcrypt}$2a$10$LSDtj6X7InrX4YjJ//ChluKU.yqCRNCplBTrQaBWmILWBarQYdhWG', true);
INSERT INTO Authority (id, username, authority) values (2, '40001', 'ROLE_STUDENT');
ALTER SEQUENCE security_seq restart 30;