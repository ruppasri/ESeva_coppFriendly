package copp_Friendly.mvc.bean;
import java.util.Date;
public class RegisterBean {
	 Date datet =new Date();
	 private String Name;
	 private String latitude;
	 private String longitude;
	 private String roffender;
	 private String license;
	 private String phone;
	 private String vehicle;
	 private String location;
	 private String date=datet.toString();
	 private String type;
	 private String fine;
	 
	 
	 public String getName() {
	 return Name;
	 }
	 public void setName(String Name) {
	 this.Name = Name;
	 }
	public String getRoffender() {
		return roffender;
	}
	public void setRoffender(String roffender) {
		this.roffender = roffender;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFine() {
		return fine;
	}
	public void setFine(String fine) {
		this.fine = fine;
		
	}
	
	}