package week5;

public class Post {
	private int id;
	private String title, content, location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", location=" + location + "]";
	}
	public Post(int id, String title, String content, String location) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.location = location;
	}
	
}
