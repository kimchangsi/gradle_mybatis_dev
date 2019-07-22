package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.Student;
import kr.or.yi.gradle_mybatis_dev.jdbc.MybatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.StudentMapper";

	@Override
	public Student selectStudentByNo(Student student) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
		}
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByNoWithResultMap", student);
		}
	}

	@Override
	public List<Student> selectStudentByAll() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectStudentByAll");
		}
	}

	@Override
	public int insertStudent(Student student) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateStudent(Student student) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteStudent(Student student) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	/*
	 * @Override public int alterIncrement() { try(SqlSession sqlSession =
	 * MybatisSqlSessionFactory.openSession()){ int res =
	 * sqlSession.update(namespace + ".alterIncrement"); sqlSession.commit(); return
	 * res; } }
	 */
	@Override
	public List<Map<String, Object>> selectStudentMapByAll() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectStudentMapByAll");
		}
	}

	@Override
	public Student selectStudentByNoResultMapExtends(Student student) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByNoResultMapExtends", student);
		}
	}

	@Override
	public int insertStudentEnum(Student student) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertStudentEnum", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Student selectStudentByMap(Map<String, String> map) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByMap", map);
		}
	}

	@Override
	public Map<Integer, String> selectStudentForMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student std = resultContext.getResultObject();
				map.put(std.getStudId(), std.getName());
			}
		};
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			sqlSession.selectList(namespace + ".selectStudentForMap", resultHandler);
			return map;
		}
	}

}
