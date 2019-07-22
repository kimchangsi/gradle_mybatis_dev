package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //typehandler이용
	Student selectStudentByNoWithResultMap(Student student); //resultMap을 이용
	List<Student> selectStudentByAll();
	Student selectStudentByNoResultMapExtends(Student student);
	Student selectStudentByMap(Map<String,String> map); //매개변수를 해쉬 맵으로 전달( 여려개 입력파라미터 전달 방법)
	

	Map<Integer, String> selectStudentForMap();	//ResultSet 처리방식의 재정의 id랑 name만 뽑아올떄
	
	List<Map<String, Object>> selectStudentMapByAll(); 
	
	int insertStudent(Student student);
	int insertStudentEnum(Student student);
	
	int updateStudent(Student student);
	int deleteStudent(Student student); 
	/* int alterIncrement(); */
	
}
