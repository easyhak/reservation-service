package kr.or.connect.reservation.dto;

import java.util.Date;

public class ReservationInfo {
	private int reservationInfoId;
	private int productId;
	private int displayInfoId;
	private String reservationName;
	private String reservationTel;
	private String reservationEmail;
	private String cancelYn;
	private Date reservationDate;
	private Date createDate;
	private Date modifyDate;
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
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
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getReservationTel() {
		return reservationTel;
	}
	public void setReservationTel(String reservationTel) {
		this.reservationTel = reservationTel;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public String getCancelYn() {
		return cancelYn;
	}
	public void setCancelYn(String cancelYn) {
		this.cancelYn = cancelYn;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public ReservationInfo(int reservationInfoId, int productId, int displayInfoId, String reservationName,
			String reservationTel, String reservationEmail, String cancelYn, Date reservationDate, Date createDate,
			Date modifyDate) {
		this.reservationInfoId = reservationInfoId;
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.reservationName = reservationName;
		this.reservationTel = reservationTel;
		this.reservationEmail = reservationEmail;
		this.cancelYn = cancelYn;
		this.reservationDate = reservationDate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "ReservationInfo [reservationInfoId=" + reservationInfoId + ", productId=" + productId
				+ ", displayInfoId=" + displayInfoId + ", reservationName=" + reservationName + ", reservationTel="
				+ reservationTel + ", reservationEmail=" + reservationEmail + ", cancelYn=" + cancelYn
				+ ", reservationDate=" + reservationDate + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}
	
}
