package com.gw.RealEstate.Entity;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="propertydetails")
@Proxy(lazy = false)
public class PropertyDetails {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GenericGenerator(name = "inc-gen", strategy ="increment")
	@Column(name="propid")
	private int propId;
	@Column(name="title")
	private String title;
	@Column(name="propStatus")
	private String propStatus;
	@Column(name="type",nullable=false)
	private String type;
	@Column(name="price")
	private int price;
	@Column(name="area")
	private int area;
	@Column(name="rooms")
	private int rooms;
	@Column(name="bathroom")
	private int bathroom;
	@Column(name="address")
	private String address;
	@Column(name="postalcode")
	private int postalcode;
	@Column(name="info")
	private String info;
	
	@Column(name="parking")
	private boolean parking;
	
	@Column(name="ac")
	private boolean ac;
	
	@Column(name="sit")
	private boolean sit;
	
	@Column(name="pool")
	private boolean pool;
	
	@Column(name="laundry")
	private boolean laundry;
	
	@Column(name="window")
	private boolean window;
	
	@Column(name="heating")
	private boolean heating;
	
	@Column(name="alarm")
	private boolean alarm;
	
	@Column(name="gym")
	private boolean gym;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private double phone;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private PersonalDetails pd;
	
	public PropertyDetails() {
		
	}
	
	
	public PropertyDetails(String title, String propStatus, String type, int price, int area, int rooms, int bathroom,
			String address, int postalcode, String info, boolean parking,
			boolean ac, boolean sit, boolean pool, boolean laundry, boolean window, boolean heating, boolean alarm,
			boolean gym, String name, String email, double phone) {
		
		this.title = title;
		this.propStatus = propStatus;
		this.type = type;
		this.price = price;
		this.area = area;
		this.rooms = rooms;
		this.bathroom = bathroom;
		this.address = address;
		this.postalcode = postalcode;
		this.info = info;
		this.parking = parking;
		this.ac = ac;
		this.sit = sit;
		this.pool = pool;
		this.laundry = laundry;
		this.window = window;
		this.heating = heating;
		this.alarm = alarm;
		this.gym = gym;
		this.name = name;
		this.email = email;
		this.phone = phone;
		//this.pd = pd;
	}


	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public boolean isSit() {
		return sit;
	}
	public void setSit(boolean sit) {
		this.sit = sit;
	}
	public boolean isPool() {
		return pool;
	}
	public void setPool(boolean pool) {
		this.pool = pool;
	}
	public boolean islaundry() {
		return laundry;
	}
	public void setlaundry(boolean laundry) {
		this.laundry = laundry;
	}
	public boolean isWindow() {
		return window;
	}
	public void setWindow(boolean window) {
		this.window = window;
	}
	public boolean isHeating() {
		return heating;
	}
	public void setHeating(boolean heating) {
		this.heating = heating;
	}
	public boolean isAlarm() {
		return alarm;
	}
	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	public boolean isGym() {
		return gym;
	}
	public void setGym(boolean gym) {
		this.gym = gym;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}

	public PersonalDetails getPd() {
		return pd;
	}
	public void setPd(PersonalDetails pd) {
		this.pd = pd;
	}
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPropStatus() {
		return propStatus;
	}
	public void setPropStatus(String propStatus) {
		this.propStatus = propStatus;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getBathroom() {
		return bathroom;
	}
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getpostalcode() {
		return postalcode;
	}
	public void setpostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

}
