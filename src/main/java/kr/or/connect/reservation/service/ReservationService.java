package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.MainDto;
import kr.or.connect.reservation.dto.Promotion;

public interface ReservationService {
	public List<MainDto> getAllProduct(Integer start);
	public List<MainDto> getProductByCategory(Integer categoryId, Integer start);
	public List<Promotion> getPromotions();
	public List<Category> getCategories();
	public static final int LIMIT = 4;
}
