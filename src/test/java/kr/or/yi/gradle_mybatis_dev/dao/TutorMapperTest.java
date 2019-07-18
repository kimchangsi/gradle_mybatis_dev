package kr.or.yi.gradle_mybatis_dev.dao;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.Course;
import kr.or.yi.gradle_mybatis_dev.dto.Tutor;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorMapperTest extends AbstractTest {
	private static TutorMapper tutorDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tutorDao = new TutorMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tutorDao = null;
	}

	@Test
	public void test01selectTutorById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Tutor t = new Tutor();
		t.setTutorId(1);
		
		Tutor searchTutor = tutorDao.selectTutorById(t);
		Assert.assertEquals(t.getTutorId(),searchTutor.getTutorId());
		log.debug(searchTutor.toString());
		
		for(Course c : searchTutor.getCourses()) {
			log.debug(c.toString());
		}
		
			
	}

}
