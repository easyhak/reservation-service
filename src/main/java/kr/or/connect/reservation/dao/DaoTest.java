package kr.or.connect.reservation.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductDisplayInfo;


public class DaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
//		DisplayInfoDao displayInfoDao = ac.getBean(DisplayInfoDao.class);
		
//		System.out.println(displayInfoDao.selectCount());
//		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
//		
//		Guestbook guestbook = new Guestbook();
//		guestbook.setName("강경미");
//		guestbook.setContent("반갑습니다. 여러분.");
//		guestbook.setRegdate(new Date());
//		Long id = guestbookDao.insert(guestbook);
//		System.out.println("id : " + id);
		ProductDisplayInfoDao maindao = ac.getBean(ProductDisplayInfoDao.class);
		List<ProductDisplayInfo> list = maindao.selectAll(0, 3);
		for(ProductDisplayInfo l: list) {
			System.out.println(l);
		}
		
	}

}
