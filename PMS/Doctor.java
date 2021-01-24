//package src;

import java.util.ArrayList;

public class Doctor {

	private static volatile Doctor instance;
	public ArrayList<DoctorFields> doctorList;
	public Doctor() {
		//create instance of array list
		doctorList = new ArrayList<DoctorFields>();
		
	}
	
	public static Doctor getInstance() {
        if (instance == null) {
            synchronized (Doctor.class) {
                if (instance == null) {
                    instance = new Doctor();
                }
            }
        }
        return instance;
    }
	public String getEmpcode() {
		return "emp2020_"+(doctorList.size()+1);
	}
	public String getDocId(String n1) {
		Doctor D1=Doctor.getInstance();
		for(int i=0;i<doctorList.size();i++) {
			if(doctorList.get(i).name.equals(n1)) {
				return doctorList.get(i).loginId;
			}
		}
		return "notfound";
	}
	public boolean setDoctorList(String t1, String t3,String t4,String t5,String t6,String t7,String t8) {
		//receive login values from
		boolean response=false;
		try {
			Doctor d2=Doctor.getInstance();
			String t2=d2.getEmpcode();
			doctorList.add(new DoctorFields(t1,t2,t3,t4,t5,t6,t7,t8));
			for(int i=0;i<doctorList.size();i++) {
				System.out.println("Added Doctor: "+doctorList.get(i).name);
				System.out.println("Added Doctor ID: "+doctorList.get(i).loginId);
			}
			response=true;
		}
		catch(Exception e) {
			response=false;
		}
		
		return response;
	}
	public ArrayList<DoctorFields> getDoctorrecord(){
		return doctorList;
	}
	public String getDoctorName(String docID) {
		String Name="";
			for(int i=0;i<doctorList.size();i++) {
				if(doctorList.get(i).loginId.equals(docID)) {
					Name=doctorList.get(i).name;
					break;
				}
			}
		return Name;
	}
}
