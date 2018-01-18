package com.mtr.pojo;

import java.sql.Date;

public class GetMoviesInTheatre {
	private int theatreId;
	private Date showDate;
	@Override
	public String toString() {
		return "GetMoviesInTheatre [theatreId=" + theatreId + ", showDate=" + showDate + "]";
	}
	public GetMoviesInTheatre(int theatreId, Date showDate) {
		super();
		this.theatreId = theatreId;
		this.showDate = showDate;
	}
	public GetMoviesInTheatre() {
		super();
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	
	
}
