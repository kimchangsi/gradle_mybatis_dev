SELECT user(),database();

SELECT *FROM addresses;
SELECT *FROM course_enrollment;
SELECT *FROM courses;
SELECT *FROM students;
SELECT *FROM tutors;


select stud_id ,name,email,dob,phone
from students;

truncate table students;
alter table students auto_increment=SELECT LAST_INSERT_ID() from students;

SELECT LAST_INSERT_ID() from students;


insert into 


select stud_id ,name,email,dob,phone,
substring(phone,1,3) as f,substring(phone,5,3) as m,substring(phone,9,4) as l
from students where stud_id=1;



desc students;

INSERT INTO mybatis_dev.students
(`STUD_ID`, `NAME`, `EMAIL`, `DOB`, `PHONE`)
VALUES(3, 'Timothy', 'timthy@gmail.com', '1988-05-25', '123-123-1234');

INSERT INTO mybatis_dev.students
(`STUD_ID`, `NAME`, `EMAIL`, `DOB`, `PHONE`)
VALUES(2, 'Douglas', 'douglas@gmail.com', '1990-08-15', '789-456-1234');

