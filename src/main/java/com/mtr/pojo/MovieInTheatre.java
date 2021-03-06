	package com.mtr.pojo;

import java.sql.Time;
import java.sql.Date;

public class MovieInTheatre {

	private String  theatreMovieId;
	private int theatreId;
	private int movieId;
	private int screen;
	private Date startDate;
	private Date endDate;
	private Time startTime;
	private Time endTime;
	
	
	public MovieInTheatre() {
		super();
	}
	public MovieInTheatre(String theatreMovieId, int theatreId, int movieId, int screen, Date startDate, Date endDate,
			Time startTime, Time endTime) {
		super();
		this.theatreMovieId = theatreMovieId;
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.screen = screen;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "TheatreMovie [theatreMovieId=" + theatreMovieId + ", theatreId=" + theatreId + ", movieId=" + movieId
				+ ", screen=" + screen + ", startDate=" + startDate + ", endDate=" + endDate + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	public String getTheatreMovieId() {
		return theatreMovieId;
	}
	public void setTheatreMovieId(String theatreMovieId) {
		this.theatreMovieId = theatreMovieId;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getScreen() {
		return screen;
	}
	public void setScreen(int screen) {
		this.screen = screen;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	
}
