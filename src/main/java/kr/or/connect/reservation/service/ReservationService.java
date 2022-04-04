package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DetailBanner;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.MainBanner;

public interface ReservationService {
	public List<ProductDisplayInfo> getAllProduct(Integer start);
	public List<ProductDisplayInfo> getProductByCategory(Integer categoryId, Integer start);
	public List<MainBanner> getMainBanners();
	public List<Category> getCategories();
	public static final int LIMIT = 4;
	public List<DetailBanner> getDetailBanners(Integer id);
}
