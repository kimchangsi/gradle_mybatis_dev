package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev.dto.Course;

public interface CourseMapper {
	List<Course> selectCoursesByCondition(Map<String, Object> map);
}
