package kr.or.connect.reservation.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationComment {
	private int productId;
	private int displayInfoId;
	private String reservationName;
	private String comment;
	private String score;
	private Date createDate;
	public ReservationComment() {
		
	}
	public ReservationComment(int productId, int displayInfoId, String reservationName, String comment, String score,
			Date createDate) {
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.reservationName = reservationName;
		this.comment = comment;
		this.score = score;
		this.createDate = createDate;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	/* 여기 수정 */
	public Date getCreateDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String date = simpleDateFormat.format(createDate);
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "ReservationComment [productId=" + productId + ", displayInfoId=" + displayInfoId + ", reservationName="
				+ reservationName + ", comment=" + comment + ", score=" + score + ", createDate=" + createDate + "]";
	}
	
	
}
