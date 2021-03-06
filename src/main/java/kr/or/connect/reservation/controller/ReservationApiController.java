package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.MainBanner;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.impl.ReservationServiceImpl;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {
	@Autowired
	ReservationService reservationService;

	@GetMapping("/products")
	public Map<String, Object> products(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {
		List<ProductDisplayInfo> plist;
		int totalCount = 0;
		List<Category> clist = reservationService.getCategories();

		if (categoryId == 0) {
			plist = reservationService.getAllProduct(start);
			for (Category category : clist) {
				totalCount += category.getCount();
			}
		} else {
			plist = reservationService.getProductByCategory(categoryId, start);
			totalCount = clist.get(categoryId - 1).getCount();
		}

		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("item", plist);

		return map;
	}

	@GetMapping("/categories")
	public List<Category> categories() {
		List<Category> item = reservationService.getCategories();
		return item;
	}

	@GetMapping("/promotions")
	public List<MainBanner> promotions() {
		List<MainBanner> items = reservationService.getMainBanners();
		return items;
	}
	@GetMapping("/reservations")
	public Map<String, Object> reservations(@RequestParam(name = "reservationEmail", required = true) String reservationEmail){
		
		
		Map<String, Object> map = new HashMap<>();
		return map;
	}

}
