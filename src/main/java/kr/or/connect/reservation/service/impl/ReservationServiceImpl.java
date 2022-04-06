package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.DetailBannerDao;
import kr.or.connect.reservation.dao.DetailContentPromotionDao;
import kr.or.connect.reservation.dao.DetailLocationDao;
import kr.or.connect.reservation.dao.ProductDisplayInfoDao;
import kr.or.connect.reservation.dao.ReservationCommentDao;
import kr.or.connect.reservation.dao.MainBannerDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DetailBanner;
import kr.or.connect.reservation.dto.DetailContentPromotion;
import kr.or.connect.reservation.dto.DetailLocation;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.ReservationComment;
import kr.or.connect.reservation.dto.MainBanner;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired 
	ProductDisplayInfoDao mainDao;
	@Autowired
	MainBannerDao mainBannerDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	DetailBannerDao detailBannerDao;
	@Autowired
	DetailContentPromotionDao detailContentPromotionDao;
	@Autowired
	ReservationCommentDao reservationCommentDao;
	@Autowired
	DetailLocationDao detailLocationDao;
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
	public List<MainBanner> getMainBanners() {
		return mainBannerDao.selectMainBannerList();
	}
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		return categoryDao.selectCategory();
	}

	@Override
	public List<DetailBanner> getDetailBanners(Integer id) {
		return detailBannerDao.selectImageById(id);
	}
	@Override
	@Transactional
	public DetailContentPromotion getContentPromotion(Integer id) {
		return detailContentPromotionDao.selectContentPromotionById(id);
	}

	@Override
	@Transactional
	public List<ReservationComment> getReservationComments(Integer id) {
		return reservationCommentDao.selectCommentList(id);
	}

	@Override
	public double getAvgScore(Integer id) {
		return reservationCommentDao.getAvgScore(id);
	}

	@Override
	public int getTotalCommentCount(Integer id) {
		return reservationCommentDao.getTotalCommentCount(id);
	}

	@Override
	public DetailLocation getLocationInfo(Integer id) {
		return detailLocationDao.getLocationInfoById(id);
	}
	
	
}
