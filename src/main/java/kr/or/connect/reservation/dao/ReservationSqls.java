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
	
	public static final String SELECT_PROMOTION = "select promotion.id,product.id productId, file_info.save_file_name as productImageUrl "
			+ "from promotion left join product on promotion.product_id = product.id "
			+ "join product_image on product_image.product_id = product.id "
			+ "join file_info on product_image.file_id = file_info.id "
			+ "where product_image.type = \"th\"";
	
	public static final String  SELECT_CATEGORY = "SELECT count(*) count, category_id id, category.name "
			+ "FROM category, reservationdb.display_info, product "
			+ "where product.id = display_info.product_id and category.id = product.category_id group by product.category_id";
	
	public static final String SELECT_DETAIL_IMAGE_BY_ID = "SELECT product.id productId, description,save_file_name saveFileName FROM reservationdb.product "
			+ "left join product_image on product.id = product_id "
			+ "left join file_info on product_image.file_id = file_info.id "
			+ "where product.id = :id and (type = \"ma\" or type = \"et\")";
}
