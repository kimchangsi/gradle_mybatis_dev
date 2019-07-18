package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //typehandler이용
	Student selectStudentByNoWithResultMap(Student student); //resultMap을 이용
	List<Student> selectStudentByAll();
	Student selectStudentByNoResultMapExtends(Student student);
	
	
	List<Map<String, Object>> selectStudentMapByAll(); 
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);
	/* int alterIncrement(); */
	
}
