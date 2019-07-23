package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.Course;
import kr.or.yi.gradle_mybatis_dev.jdbc.MybatisSqlSessionFactory;

public class CourseMapperImpl implements CourseMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.CourseMapper";

	@Override
	public List<Course> selectCoursesByCondition(Map<String, Object> map) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectCoursesByCondition", map);
		}
	}

}
