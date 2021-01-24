//package src;
public class MaintainUser {
private String userName;
private static volatile MaintainUser instance;

public static MaintainUser getInstance() {
    if (instance == null) {
        synchronized (MaintainUser.class) {
            if (instance == null) {
                instance = new MaintainUser();
            }
        }
    }
    return instance;
}

	public String getUserName() {
		
		return userName;
	}
	public void setUserName(String s1) {
		userName=s1;
		
	}
}
