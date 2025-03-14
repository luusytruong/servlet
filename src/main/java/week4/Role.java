package week4;

public class Role {
	private int id;
	private String roleName, createAt, editAt;
	private String[] user;

	public Role(int id, String roleName, String createAt, String editAt, String[] user) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.createAt = createAt;
		this.editAt = editAt;
		this.setUser(user);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getEditAt() {
		return editAt;
	}

	public void setEditAt(String editAt) {
		this.editAt = editAt;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", createAt=" + createAt + ", editAt=" + editAt
				+ ", users: " + String.join(", ", user) + "]";
	}

	public String[] getUser() {
		return user;
	}

	public void setUser(String[] user) {
		this.user = user;
	}

}
