package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.PhoneNumber;
import kr.or.yi.gradle_mybatis_dev.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest {
	private static StudentMapper stdDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stdDao = new StudentMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		stdDao = null;
	}

	@Test
	public void test1SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student std = new Student();
		std.setStudId(1);
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void test2selectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student std = new Student();
		std.setStudId(1);
		Student selectStd = stdDao.selectStudentByNoWithResultMap(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void test4selectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = stdDao.selectStudentByAll();
		Assert.assertNotNull(lists);
	}
	
	/*
	 * @Test public void test3insertStudent() {
	 * log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
	 * Calendar newDate = GregorianCalendar.getInstance(); newDate.set(1990, 2, 28);
	 * Student std = new Student(4, "홍길동", "lee@test.co.kr", new
	 * PhoneNumber("010-1234-1234"), newDate.getTime()); int res =
	 * stdDao.insertStudent(std); Assert.assertEquals(1, res); }
	 */
	
	@Test
	public void test6updateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student std = new Student(1, "Timothy", "test@test.co.kr", new PhoneNumber("222-222-2222"), new Date());
		
		int res = stdDao.updateStudent(std);
		Assert.assertSame(1, res);
		
		std.setEmail("timthy@gmail.com");
		std.setPhone(new PhoneNumber("123-123-1234"));
		std.setDob(new GregorianCalendar(1988,04,25).getTime());
		res = stdDao.updateStudent(std);
		Assert.assertSame(1, res);
	}
	
	
	/*
	 * @Test public void test7deleteStudent() {
	 * log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
	 * Student std = new Student(4); int res = stdDao.deleteStudent(std);
	 * Assert.assertSame(1, res);
	 * 
	 * }
	 */
	
	@Test
	public void test8selectStudentMapByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Map<String,Object>> lists = stdDao.selectStudentMapByAll();
		Assert.assertNotNull(lists);
		
		for(Map<String,Object> e : lists) {
			for(Entry<String,Object> ee : e.entrySet()) {
				log.debug(String.format("%s -> %s",ee.getKey(),ee.getValue()));
			}
			
		}
	}
	
	@Test public void test9selectStudentByNoResultMapExtends() {
		  log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		  Student std = new Student();
		  std.setStudId(1);
		  Student searchStudent = stdDao.selectStudentByNoResultMapExtends(std);
		 Assert.assertNotNull(searchStudent);
		 log.debug(searchStudent.toString());
	}
}
