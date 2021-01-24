//package src;
public class DoctorFields {

	public String loginType;
	public String loginId;
	public String password;
	public String name;
	public String slot;
	public String dept;
	public String cont;
	public String eml;
	public DoctorFields(String lT, String lI,String pass,String na,String sl,String dt, String con, String eml) {
		loginType=lT;
		loginId=lI;
		password=pass;
		name=na;
		slot=sl;
		dept=dt;
		cont=con;
		this.eml=eml;
	}
	
}
