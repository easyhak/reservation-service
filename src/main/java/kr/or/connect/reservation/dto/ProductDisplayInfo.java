package kr.or.connect.reservation.dto;

public class ProductDisplayInfo {
	private int productId;
	private int displayInfoId;
	private String description;
	private String placeName;
	private String content;
	private String saveFileName;
	public ProductDisplayInfo() {
		
	}
	public ProductDisplayInfo(int productId, int displayInfoId, String description, String placeName, String content,
			String saveFileName) {
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.description = description;
		this.placeName = placeName;
		this.content = content;
		this.saveFileName = saveFileName;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	@Override
	public String toString() {
		return "MainDto [productId=" + productId + ", displayInfoId=" + displayInfoId + ", description=" + description
				+ ", placeName=" + placeName + ", content=" + content + ", saveFileName=" + saveFileName + "]";
	}	
}
