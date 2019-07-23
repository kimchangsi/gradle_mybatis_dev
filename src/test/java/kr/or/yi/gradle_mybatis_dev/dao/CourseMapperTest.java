package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import kr.or.yi.gradle_mybatis_dev.AbstractTest;

import kr.or.yi.gradle_mybatis_dev.dto.Course;

public class CourseMapperTest  extends AbstractTest{
	private static CourseMapper courseDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseDao = new CourseMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		courseDao = null;
	}

	@Test
	public void testSelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map = new HashMap<String, Object>();
		//조건이 하나도 만족 x
		List<Course> list = courseDao.selectCoursesByCondition(map);
		
		//courseId =1
		map.put("courseId", 1);
		list = courseDao.selectCoursesByCondition(map);
		
		//name = "%java%"
		map.clear();
		map.put("name", "%java%");
		list = courseDao.selectCoursesByCondition(map);
		
		//name = "%java%" and star_date >= '2013-04-01'
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		map.put("startDate", cal.getTime());
		list = courseDao.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
		
		
	}

}
