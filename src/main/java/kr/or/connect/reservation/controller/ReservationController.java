package kr.or.connect.reservation.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DetailBanner;
import kr.or.connect.reservation.dto.DetailContentPromotion;
import kr.or.connect.reservation.dto.DetailLocation;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.ReservationComment;
import kr.or.connect.reservation.dto.MainBanner;
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
		List<MainBanner> mainBannerList = reservationService.getMainBanners();
		List<Category> categoryList = reservationService.getCategories();
		int count = 0;
		for (Category category : categoryList) {
			count += category.getCount();
		}
		modelMap.addAttribute("productList",productDisplayList);
		modelMap.addAttribute("promotionList",mainBannerList);
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
		List<MainBanner> mainBannerList = reservationService.getMainBanners();;
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
		map.put("promotionList",mainBannerList);
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
	
	@GetMapping(path = "/detail")
	public String detailPage(HttpServletRequest request, ModelMap modelMap) {
		int id = Integer.parseInt(request.getParameter("id")); //여기 오류
		List<DetailBanner> detailBannerList = reservationService.getDetailBanners(id);
		DetailContentPromotion contentPromtion = reservationService.getContentPromotion(id);
		List<ReservationComment> reservationCommentList = reservationService.getReservationComments(id);
		DetailLocation detailLocation = reservationService.getLocationInfo(id);
		int commentCount = reservationService.getTotalCommentCount(id);
		double avgScore = reservationService.getAvgScore(id);
		System.out.println(contentPromtion.getDescription());
		
		modelMap.addAttribute("detailBannerList",detailBannerList);
		modelMap.addAttribute("contentPromotion",contentPromtion);
		modelMap.addAttribute("commentList",reservationCommentList);
		modelMap.addAttribute("commentCount",commentCount);
		modelMap.addAttribute("avgScore",avgScore);
		modelMap.addAttribute("detailLocation",detailLocation);
		
		return "detail";
	}
	@GetMapping(path = "/review")
	public String reviewPage(HttpServletRequest request, ModelMap modelMap) {
		int id = Integer.parseInt(request.getParameter("id")); //여기 오류
		List<DetailBanner> detailBannerList = reservationService.getDetailBanners(id);
		List<ReservationComment> reservationCommentList = reservationService.getReservationComments(id);
		int commentCount = reservationService.getTotalCommentCount(id);
		double avgScore = reservationService.getAvgScore(id);
	
		modelMap.addAttribute("productId",id); // 나중에 수정
		modelMap.addAttribute("detailBannerList",detailBannerList);
		modelMap.addAttribute("commentList",reservationCommentList);
		modelMap.addAttribute("commentCount",commentCount);
		modelMap.addAttribute("avgScore",avgScore);
		return "review";
	}
}
