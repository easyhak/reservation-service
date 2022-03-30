package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDisplayInfoDao;
import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired 
	ProductDisplayInfoDao mainDao;
	@Autowired
	PromotionDao promotionDao;
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	@Transactional
	public List<ProductDisplayInfo> getAllProduct(Integer start){
		return mainDao.selectAll(start, LIMIT);
	}
	
	@Override
	@Transactional
	public List<ProductDisplayInfo> getProductByCategory(Integer categoryId, Integer start) {
		List<ProductDisplayInfo> prdList = mainDao.selectByCategory(start, LIMIT, categoryId);
		return prdList;
	}
	
	@Override
	@Transactional
	public List<Promotion> getPromotions() {
		List<Promotion> promoList = promotionDao.selectPromotionList();
		return promoList;
	}
	
	@Override
	public List<Category> getCategories() {
		return categoryDao.selectCategory();
	}
}
