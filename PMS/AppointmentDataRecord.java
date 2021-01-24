//package src;

import java.util.ArrayList;
import java.util.HashMap;

public class AppointmentDataRecord {
	private static volatile AppointmentDataRecord instance;
	public HashMap<String, HashMap<String, HashMap<String,String>>> AppData;
	
	private static String[] morningSlot= {"10:00-10:20","10:20-10:40","10:40-11:00","11:00-11:20","11:20-11:40","11:40-12:00","12:00-12:20","12:20-12:40","12:40-13:00","13:00-13:20","13:20-13:40","13:40-14:00"};
	private static String[] eveningSlot= {"3:00-3:20","3:20-3:40","3:40-4:00","4:00-4:20","4:20-4:40","4:40-5:00","5:00-5:20","5:20-5:40","5:40-6:00","6:00-6:20","6:20-6:40","6:40-7:00",};
	
	public AppointmentDataRecord() {
		//create instance of array list
		AppData = new HashMap<String, HashMap<String,HashMap<String,String>>>();
		
		AppData.put("emp2020_1",new HashMap<String, HashMap<String,String>>());
		AppData.get("emp2020_1").put("Nov 27, 20", new HashMap<String, String>());
		AppData.get("emp2020_1").get("Nov 27, 20").put("10:00-10:20", "navi9999@gmail.com");
		
	}
	
	public static AppointmentDataRecord getInstance() {
        if (instance == null) {
            synchronized (AppointmentDataRecord.class) {
                if (instance == null) {
                    instance = new AppointmentDataRecord();
                }
            }
        }
        return instance;
    }
	public HashMap<String, HashMap<String, HashMap<String,String>>> getAppointRecord(){
		return AppData;
	}
	
	public Boolean bookAppoint(String t1, String t2,String t3,String t4) {
		Doctor d1=Doctor.getInstance();
		String DocId=d1.getDocId(t1);
		AppData.put(DocId,new HashMap<String, HashMap<String,String>>());
		AppData.get(DocId).put(t2, new HashMap<String, String>());
		AppData.get(DocId).get(t2).put(t3, t4);
		
		return true;
	}
	public String getAvailableSlot(String t1, String t2,String t3,String t4) {
		if(t3.equals("10:00-2:00")) {
			Doctor d1=Doctor.getInstance();
			String DocId=d1.getDocId(t1);
			if(AppData.containsKey(DocId)){
					HashMap<String, HashMap<String,String>> AppData1=AppData.get(DocId);
					if(AppData1.containsKey(t4)) {
						HashMap<String,String> AppData2=AppData1.get(t4);
						
							//morning slot
							
								for(int i=0;i<morningSlot.length;i++) {
								if(!AppData2.containsKey(morningSlot[i])) {
									return morningSlot[i];
								}
								//System.out.println(res+"\n");
							}
					}
					return "10:00-10:20";
			}
			else {
				return "10:00-10:20";
			}
		}
		else {
			Doctor d1=Doctor.getInstance();
			String DocId=d1.getDocId(t1);
			if(AppData.containsKey(DocId)){
					HashMap<String, HashMap<String,String>> AppData1=AppData.get(DocId);
					if(AppData1.containsKey(t4)) {
						HashMap<String,String> AppData2=AppData1.get(t4);
						
							//morning slot
							for(int i=0;i<eveningSlot.length;i++) {
								if(!AppData2.containsKey(eveningSlot[i])) {
									return eveningSlot[i];
								}
								
								//System.out.println(res+"\n");
							}
					}
					return "3:00-3:20";
			}
			else {
				return "3:00-3:20";
			}
		}
		//return "Not Available";
	}
}
