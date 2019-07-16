SELECT user(),database();

SELECT *FROM addresses;
SELECT *FROM course_enrollment;
SELECT *FROM courses;
SELECT *FROM students;
SELECT *FROM tutors;


select stud_id ,name,email,dob,phone
from students where stud_id=1;

select stud_id ,name,email,dob,phone,
substring(phone,1,3) as f,substring(phone,5,3) as m,substring(phone,9,4) as l
from students where stud_id=1;