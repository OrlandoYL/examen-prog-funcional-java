

INSERT INTO course (id_course, acronym, name, status) VALUES (1, 'PFUNI', 'Programacion Funcional I', true);
INSERT INTO course (id_course, acronym, name, status) VALUES (2, 'RCISCOI', 'Redes Cisco I', true);
INSERT INTO course (id_course, acronym, name, status) VALUES (3, 'DIWEB1', 'Diseño', true);
INSERT INTO course (id_course, acronym, name, status) VALUES (4, 'SCMASI', 'Scrum Master I', true);




INSERT INTO student (id_student, age, first_name, last_name, nro_document) VALUES (1, 30, 'Orlando Netty', 'Yarasca Lupuche', '78754525');
INSERT INTO student (id_student, age, first_name, last_name, nro_document) VALUES (2, 40, 'Edith', 'Cordova Fernandez', '12412158');
INSERT INTO student (id_student, age, first_name, last_name, nro_document) VALUES (3, 25, 'Manuel', 'Ascencio Yarasca', '98965555');



INSERT INTO tuition (id_tuition, date_time, enabled, id_student) VALUES (1, '2025-02-25 12:02:15', true, 1);
INSERT INTO tuition (id_tuition, date_time, enabled, id_student) VALUES (2, '2025-02-20 15:02:15', true, 2);
INSERT INTO tuition (id_tuition, date_time, enabled, id_student) VALUES (3, '2025-03-01 09:02:15', true, 3);


INSERT INTO tuition_detail (id_tuition_detail, classroom, id_course, id_tuition) VALUES (1, 'AULA A1', 1, 1);
INSERT INTO tuition_detail (id_tuition_detail, classroom, id_course, id_tuition) VALUES (2, 'AULA A2', 2, 2);
INSERT INTO tuition_detail (id_tuition_detail, classroom, id_course, id_tuition) VALUES (3, 'AULA A1', 1, 3);
INSERT INTO tuition_detail (id_tuition_detail, classroom, id_course, id_tuition) VALUES (4, 'AULA B1', 2, 3);
INSERT INTO tuition_detail (id_tuition_detail, classroom, id_course, id_tuition) VALUES (5, 'AULA C1', 3, 3);

