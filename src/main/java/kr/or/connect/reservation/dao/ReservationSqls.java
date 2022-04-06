package kr.or.connect.reservation.dao;

public class ReservationSqls {
	
	public static final String SELECT_ALL = "select product.id productId, display_info.id displayInfoId, description, place_name placeName, product.content, file_info.save_file_name saveFileName "
    		+ "from product, display_info, file_info, product_image\r\n"
    		+ "where product.id = display_info.product_id and product_image.product_id = product.id and product_image.type = \"th\" and product_image.file_id = file_info.id "
    		+ "Limit :start, :limit";
	
	public static final String SELECT_BY_CATEGORY = "select product.id productId, display_info.id displayInfoId, description, place_name placeName, product.content, file_info.save_file_name saveFileName "
    		+ "from product, display_info, file_info, product_image "
    		+ "where product.id = display_info.product_id and product_image.product_id = product.id and product_image.type = \"th\" and product_image.file_id = file_info.id "
    		+ "and category_id= :category_id "
    		+ "limit :start, :limit ";
	
	public static final String SELECT_MAINBANNER = "select promotion.id,product.id productId, file_info.save_file_name as productImageUrl "
			+ "from promotion left join product on promotion.product_id = product.id "
			+ "join product_image on product_image.product_id = product.id "
			+ "join file_info on product_image.file_id = file_info.id "
			+ "where product_image.type = \"th\"";
	
	public static final String  SELECT_CATEGORY = "SELECT count(*) count, category_id id, category.name "
			+ "FROM category, reservationdb.display_info, product "
			+ "where product.id = display_info.product_id and category.id = product.category_id group by product.category_id";
	
	public static final String SELECT_DETAIL_IMAGE_BY_ID = "SELECT product.id productId, display_info.id displayInfoId, description, content, save_file_name saveFileName FROM reservationdb.product "
			+ "left join product_image on product.id = product_id "
			+ "left join file_info on product_image.file_id = file_info.id "
			+ "join display_info "
			+ "on display_info.product_id = product.id "
			+ "where display_info.id = :id and (type = \"ma\" or type = \"et\")";
	
	public static final String SELECT_CONTENT_PROMOTION_BY_ID = "SELECT product.id productId, display_info.id displayInfoId, content, description, if (promotion.id, promotion.id, 0) promotionId FROM product "
			+ "left join promotion on promotion.product_id = product.id "
			+ "left join display_info on display_info.product_id = product.id "
			+ "where display_info.id = :id";
	
	public static final String SELECT_AVG_RATING_BY_ID = "select if(avg(score), round(avg(score),1), 0) rating from reservation_user_comment "
			+ "left join product on product.id = reservation_user_comment.product_id "
			+ "left join display_info on product.id = display_info.product_id "
			+ "where display_info.id = :id";
	public static final String SELECT_TOTAL_COMMENT_COUNT_BY_ID = "select count(*) count from reservation_user_comment "
			+ "left join product on product.id = reservation_user_comment.product_id "
			+ "left join display_info on product.id = display_info.product_id "
			+ "where display_info.id = :id";
	public static final String SELECT_COMMENT_BY_ID = "SELECT product.id productId, display_info.id displayInfoId, "
			+ "concat(left(reservation_email,4),\"****\") reservationName, comment, score, reservation_user_comment.create_date createDate "
			+ "FROM reservation_user_comment "
			+ "left join reservation_info on reservation_info.id = reservation_user_comment.reservation_info_id "
			+ "left join product on product.id = reservation_user_comment.product_id "
			+ "left join display_info on display_info.product_id = product.id "
			+ "where display_info.id = :id";
	
	public static final String SELECT_LOCATION_BY_ID ="select product_id productId, display_info.id displayInfoId, place_name placeName, place_lot placeLot, "
			+ "place_street placeStreet, tel, save_file_name mapImage "
			+ "from display_info "
			+ "join display_info_image on display_info.id = display_info_image.display_info_id "
			+ "join file_info on display_info_image.file_id = file_info.id "
			+ "where display_info.id = :id";
}
