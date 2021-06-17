package bankSystem;

public class UserInfo {
	
	private String userId;
	private int age;
	
	public UserInfo() {
		super();
	}
	
	public UserInfo(String userId, int age) {
		super();
		this.userId = userId;
		this.age = age;
	}
	
	public String show() {
		String show2="ID : "+this.getUserId()+"\n"+"AGE : "+this.getAge()+"\n";
		return show2;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", age=" + age + ", getUserId()=" + getUserId() + ", getAge()=" + getAge()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
