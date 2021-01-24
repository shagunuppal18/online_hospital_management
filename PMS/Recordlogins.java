//package src;
import java.util.ArrayList;



public class Recordlogins {
	private static volatile Recordlogins instance;
	private ArrayList<Loginfields> logins;
	
	
	public Recordlogins() {
		//create instance of array list
		logins = new ArrayList<Loginfields>();
		logins.add(new Loginfields("Admin","nandika@gmail.com","nandika"));
		logins.add(new Loginfields("Admin","shagun@gmail.com","shagun"));
		
		
	}
	
	public static Recordlogins getInstance() {
        if (instance == null) {
            synchronized (Recordlogins.class) {
                if (instance == null) {
                    instance = new Recordlogins();
                }
            }
        }
        return instance;
    }
	public boolean setRecordlogins(String t1, String t2, String t3) {
		//receive login values from
		boolean response=false;
		try {
			
			logins.add(new Loginfields(t1,t2,t3));
			response=true;
		}
		catch(Exception e) {
			response=false;
		}
		
		return response;
	}
	public boolean getRecordlogins(String t1, String t2, String t3) {
		
		boolean response=false;
		
		try {
			for (int i = 0; i < logins.size(); i++) {
				if (logins.get(i).loginType.equals(t1) && logins.get(i).loginId.equals(t2) && logins.get(i).password.equals(t3)) {
			    	  response=true;
			    	  break;
			      }
			      
			    }
			
		}
		catch(Exception e) {
			response=false;
		}
		return response;
	}
}
