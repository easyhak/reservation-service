package kr.or.connect.reservation.dto;

public class DetailBanner {
	/* 상세페이지에 있는 배너 만들기 */
	private int productId;
	private String description;
	private String saveFileName;
	
	public DetailBanner() {
		
	}
	public DetailBanner(int productId, String description, String saveFileName) {
		super();
		this.productId = productId;
		this.description = description;
		this.saveFileName = saveFileName;
	}
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "DetailBanner [productId=" + productId + ", description=" + description + ", saveFileName="
				+ saveFileName + "]";
	}
	
}
