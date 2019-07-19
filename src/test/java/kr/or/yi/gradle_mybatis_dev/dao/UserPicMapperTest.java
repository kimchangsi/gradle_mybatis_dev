package kr.or.yi.gradle_mybatis_dev.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private static UserPicMapper picDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		picDao = new UserPicMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		picDao = null;
	}

	@Test
	public void test02InsertUserPic() throws IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()"); //메서드 이름 가져옴
		UserPic userPic = new UserPic();
		userPic.setId(1);
		userPic.setName("손흥민");
		
		String bio = "강원도 춘천시 출신이다.[17] 16세 어린 나이부터 분데스리가 함부르크 SV로 스카웃 될 정도로 활약하며 이미 떠오르는 차세대 유망주로서 상당한 실력을 인정받았으며, 이른 나이에 대표팀에 1군으로 뽑혀 큰 활약을 하면서 두각을 드러내며 팬들의 관심을 받게된다.\r\n" + 
				"2009년 U-17 청소년 국가대표팀을 거치고, 2010년 함부르크 SV와 4년 계약과 함께 역대 최고 수준의 초특급 유망주라는 립서비스를 받으면서, 또한 해외에서도 상당한 기대를 갖고 있음을 드러냈다. 그리고 2010년 10월 30일, FC 쾰른과의 2010-2011 분데스리가 10라운드 경기에서 첫 데뷔골을 장식하면서 새로운 스타 탄생을 예고했다. 동시에, 함부르크 SV의 레전드 마니 칼츠의 최연소 골 기록을 경신하는 신기록을 선보이는 등, 국내 축구 팬들은 물론이고 독일 현지에서도 존재감이 강한 활약을 보여주면서 폭발적인 반응을 얻었다.##\r\n" + 
				"그리고, 독일 분데스리가의 명문구단 TSV 바이어 04 레버쿠젠으로부터 구단 역대 최고 이적료 기록을 경신하면서 영입을 하는 등, 한국에서는 쉽게 볼 수 없는 차세대 태극전사의 에이스로 전세계의 언론으로부터 주목을 받기 시작했다.# 그리고 2015년 8월 28일, 이적료 3,000만 유로/2,200만 파운드(한화 408억 추정치)를 기록하며 잉글리시 프리미어리그의 토트넘 핫스퍼와 5년 계약을 확정지으면서 아시아 출신 축구선수 중에서 역대 최고 이적료 기록을 경신했다.#\r\n" + 
				"최근에는 한국과 영국에 많은 팬층을 이루고 있지만 케인, 에릭센, 델레 알리 등의 다른 선수에게 스포트라이트를 빼앗기거나, 비교적 적은 출전 시간, 해외 인지도 부족으로 영국 방송매체인 BT Sports 등에 과소평가된 선수 베스트 11에 올랐다.## 한편, 케인과 마우리시오 포체티노 토트넘 감독은 관련 인터뷰에서 언론은 진정한 가치를 평가할 수 없다며 팀 내에서 그의 영향력을 칭찬했다.#\r\n" + 
				"2019년 현재 토트넘의 핵심 공격수로 활약 중이며, UEFA 챔피언스 리그 8강전에서 맨시티 상대로 3골을 넣어 구단 역사상 최초의 4강 진출을 이루어 내는 등 굉장한 모습들을 여러 차례 보여주면서 자신의 가치를 증명해내고 있다.\r\n" + 
				"또한 토트넘 핫스퍼가 4강에 이어 2018-19 시즌 UEFA 챔피언스 리그 결승 진출에 성공하면서 박지성 이후 8년 만에 나온 UEFA 챔피언스 리그 결승 무대를 밟는 코리안리거가 되었다.";
		userPic.setBio(bio);
		
		userPic.setPic(getPicFile());
		int result = picDao.insertUserPic(userPic);
		Assert.assertEquals(1, result);
	}
	
	private byte[] getPicFile() throws IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()"); //메서드 이름 가져옴
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\img1.jpg");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
			pic = new byte[bis.available()];
			bis.read(pic);
			return pic;
		}
	}

	@Test
	public void test03SelectUserPic() throws FileNotFoundException, IOException  {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()"); //메서드 이름 가져옴
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		UserPic searchPic = picDao.selectUserPic(userPic);
		Assert.assertNotNull(searchPic);
		if(searchPic.getPic() != null) {
			File file = getPicFile(searchPic);
			log.debug("file Path " + file.getAbsolutePath()); //파일의 경로
		}
	}

	private File getPicFile(UserPic userPic) throws FileNotFoundException, IOException {
		File pics = new File(System.getProperty("user.dir") + "\\pics\\");
		if(!pics.exists()) {
			pics.mkdir();
		}
		
		File pic = new File(pics, userPic.getName() + ".jpg");
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pic))){
			bos.write(userPic.getPic());
		}
		return pic;
	}
	
	@Test
	public void test01deleteUserPic() throws FileNotFoundException, IOException  {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()"); //메서드 이름 가져옴
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		int result =  picDao.deleteUserPic(userPic);
		Assert.assertEquals(1, result);;
		
	}

}
