package kr.or.connect.reservation.dto;

public class DetailContentPromotion {
	private int productId;
	private int displayInfoId;
	private String description;
	private String content;
	private int promotionId;
	
	public DetailContentPromotion() {
		
	}

	public DetailContentPromotion(int productId, int displayInfoId, String description, String content,
			int promotionId) {
		super();
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.description = description;
		this.content = content;
		this.promotionId = promotionId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	@Override
	public String toString() {
		return "DetailContentPromotion [productId=" + productId + ", displayInfoId=" + displayInfoId + ", description="
				+ description + ", content=" + content + ", promotionId=" + promotionId + "]";
	}
	
	
	
}
