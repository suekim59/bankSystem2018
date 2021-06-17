package bankSystem;

public interface InterAuth {
	boolean userAuth(
			String userId, String pass);
	boolean userAuth2(
			String userId);
}
