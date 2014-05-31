package beans;

public class Event {

	private int idEvent;
	private int idStudent;
	private String title;
	private String date;
	private String time;
	private String description;
	private String eventFilePath;
	
	public int getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEventFilePath() {
		return eventFilePath;
	}
	public void setEventFilePath(String eventFilePath) {
		this.eventFilePath = eventFilePath;
	}
	
	
}
