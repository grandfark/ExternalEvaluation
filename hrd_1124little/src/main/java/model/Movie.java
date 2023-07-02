package model;

public class Movie {
	private String id;
	private String title;
	private String open_date;
	private Integer start_hour;
	private Integer end_hour;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}
	public Integer getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(Integer start_hour) {
		this.start_hour = start_hour;
	}
	public Integer getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(Integer end_hour) {
		this.end_hour = end_hour;
	}
}
