package com.steam.bean;

public class Address {
	private String addressid;
	private String name;
	private String phone;
	private String adress;
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "address [addressid=" + addressid + ", name=" + name + ", phone=" + phone + ", adress=" + adress + "]";
	}
	
}
