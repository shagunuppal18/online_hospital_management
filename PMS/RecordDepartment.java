//package src;

import java.util.ArrayList;
public class RecordDepartment {
	private static volatile RecordDepartment instance;
	public ArrayList<String> dept;
	public RecordDepartment() {
		//create instance of array list
		dept = new ArrayList<String>();
		dept.add("Covid Care");
		dept.add("Cardiology");
		dept.add("Dentist");
		dept.add("Radiology");
	}
	public static RecordDepartment getInstance() {
        if (instance == null) {
            synchronized (RecordDepartment.class) {
                if (instance == null) {
                    instance = new RecordDepartment();
                }
            }
        }
        return instance;
    }
	public boolean setDepartment(String t1) {
		//receive login values from
		boolean response=false;
		try {
			
			dept.add(t1);
			
			response=true;
		}
		catch(Exception e) {
			response=false;
		}
		
		return response;
	}
public ArrayList<String> getDepartment() {
		
		//boolean response=false;
		
		return dept;
}
	
}
