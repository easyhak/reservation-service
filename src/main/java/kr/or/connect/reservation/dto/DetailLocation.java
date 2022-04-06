package kr.or.connect.reservation.dto;

public class DetailLocation {
	private int productId;
	private int displayInfoId;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String mapImage;
	public DetailLocation() {
		
	}
	public DetailLocation(int productId, int displayInfoId, String placeName, String placeLot, String placeStreet,
			String tel, String mapImage) {
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.placeName = placeName;
		this.placeLot = placeLot;
		this.placeStreet = placeStreet;
		this.tel = tel;
		this.mapImage = mapImage;
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
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceLot() {
		return placeLot;
	}
	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMapImage() {
		return mapImage;
	}
	public void setMapImage(String mapImage) {
		this.mapImage = mapImage;
	}
	@Override
	public String toString() {
		return "DetailLocation [productId=" + productId + ", displayInfoId=" + displayInfoId + ", placeName="
				+ placeName + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet + ", tel=" + tel + ", mapImage="
				+ mapImage + "]";
	}
	
}
