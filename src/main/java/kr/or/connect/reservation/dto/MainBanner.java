package kr.or.connect.reservation.dto;

public class MainBanner {
	private Integer id;
	private Integer productId;
	private String productImageUrl;
	public MainBanner() {
		
	}
	public MainBanner(Integer id, Integer productId, String productImageUrl) {
		super();
		this.id = id;
		this.productId = productId;
		this.productImageUrl = productImageUrl;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	@Override
	public String toString() {
		return "MainBanner [id=" + id + ", productId=" + productId + ", productImageUrl=" + productImageUrl + "]";
	}

}
