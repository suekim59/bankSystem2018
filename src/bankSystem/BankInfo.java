package bankSystem;

public class BankInfo extends UserInfo implements InterAuth{
	
	private String pass;
	
	public BankInfo() {
		super();
	}

	public BankInfo(String pass) {
		super();
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "BankInfo [pass=" + pass + ", getPass()=" + getPass() + ", getUserId()=" + getUserId() + ", getAge()="
				+ getAge() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	

	public String show() {
		super.show();
		return super.show()+ " PASS : "+this.getPass()+"\n";
	}

	@Override
	public boolean userAuth(String userId, String pass) {
		if(super.getUserId().equals(userId)&&this.pass.equals(pass)) {
		    return true;
			}
		return false;
	}

	@Override
	public boolean userAuth2(String userId) {
		if(super.getUserId().equals(userId)&&this.pass.equals(pass)) {
		    return true;
			}
		return false;
	}

}
