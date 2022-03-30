package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;
import kr.or.connect.reservation.service.impl.ReservationServiceImpl;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@GetMapping(path = "/mainpage")
	public String mainPage(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
			ModelMap modelMap) {
		List<ProductDisplayInfo> productDisplayList = reservationService.getAllProduct(start);
		List<Promotion> promotionList = reservationService.getPromotions();
		List<Category> categoryList = reservationService.getCategories();
		int count = 0;
		for (Category category : categoryList) {
			count += category.getCount();
		}
		modelMap.addAttribute("productList",productDisplayList);
		modelMap.addAttribute("promotionList",promotionList);
		modelMap.addAttribute("count", count);
		return "mainpage";
	}
	@GetMapping(path = "/bookinglogin")
	public String bookingLogin() {
		return "bookinglogin";
	}
	@RequestMapping(value = "/category", method = {RequestMethod.POST })	
	@ResponseBody
	public Map<String,Object> tabChange(@RequestParam(name = "cid", required = true, defaultValue = "0") int id) {
		List<Category> categoryList = reservationService.getCategories();
		List<Promotion> promotionList = reservationService.getPromotions();;
		List<ProductDisplayInfo> ProductDisplayList;
		int totalCount = 0;
		
		if (id == 0) {
			ProductDisplayList = reservationService.getAllProduct(0); 
			for (Category category : categoryList) {
				totalCount += category.getCount();
			}
		}
		else {
			ProductDisplayList = reservationService.getProductByCategory(id, 0);
			totalCount = categoryList.get(id-1).getCount();
		}
	    Map<String, Object> map = new HashMap<>();
	    System.out.println(id);
	    map.put("count", totalCount);
	    map.put("productList", ProductDisplayList);
		map.put("promotionList",promotionList);
		return map;
	}
	@RequestMapping(value = "/moreItem", method = {RequestMethod.POST })	
	@ResponseBody
	public Map<String,Object> moreItem(@RequestParam(name = "cid", required = true, defaultValue = "0") int id,
			@RequestParam(name = "citem", required = true, defaultValue = "4")int countItem) {
		List<ProductDisplayInfo> ProductDisplayList;
		List<Category> categoryList = reservationService.getCategories();
		int totalCount = 0;
		if (id == 0) {
			ProductDisplayList = reservationService.getAllProduct(countItem);
			for (Category category : categoryList) {
				totalCount += category.getCount();
			}
		}
		else {
			ProductDisplayList = reservationService.getProductByCategory(id, countItem);
			totalCount = categoryList.get(id-1).getCount();
		}
	    Map<String, Object> map = new HashMap<>();
	    System.out.println(id);
	    System.out.println(countItem);
	    map.put("productList", ProductDisplayList);
	    map.put("totalCount", totalCount);
		return map;
	}
}
