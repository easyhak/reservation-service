package kr.or.connect.reservation.dto;

public class DisplayInfo {
	private int id;
	private int productId;
	private String openingHours;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String homePage;
	private String email;
	private String createDate;
	private String modifyDate;
	
	public DisplayInfo() {
		
	}
	public DisplayInfo(int id, int productId, String openingHours, String placeName, String placeLot,
			String placeStreet, String tel, String homePage, String email, String createDate, String modifyDate) {
		this.id = id;
		this.productId = productId;
		this.openingHours = openingHours;
		this.placeName = placeName;
		this.placeLot = placeLot;
		this.placeStreet = placeStreet;
		this.tel = tel;
		this.homePage = homePage;
		this.email = email;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
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
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "DisplayInfo [id=" + id + ", productId=" + productId + ", openingHours=" + openingHours + ", placeName="
				+ placeName + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet + ", tel=" + tel + ", homePage="
				+ homePage + ", email=" + email + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
}
