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

select * from addresses where `ADDR_ID`=3;

select stud_id,name,email,phone,a.addr_id,street,city,zip,country
from students s left join addresses a on s.addr_id = a.addr_id;

SELECT *FROM courses;
SELECT *FROM tutors;

select t.tutor_id, t.name as tutor_name, email, course_id, c.name, description, start_date,end_date
from tutors t left join courses c  on t.tutor_id = c.tutor_id
where t.tutor_id = 1;

alter table students add gender tinyint unsigned; -- 성별 추가
select * from students;
desc students;