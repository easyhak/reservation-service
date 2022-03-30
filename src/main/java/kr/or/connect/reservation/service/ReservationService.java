package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.Promotion;

public interface ReservationService {
	public List<ProductDisplayInfo> getAllProduct(Integer start);
	public List<ProductDisplayInfo> getProductByCategory(Integer categoryId, Integer start);
	public List<Promotion> getPromotions();
	public List<Category> getCategories();
	public static final int LIMIT = 4;
}
