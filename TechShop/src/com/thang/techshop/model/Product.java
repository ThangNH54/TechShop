package com.thang.techshop.model;

public class Product {

	private int iD;
	private int categoryId;
	private String name;
	private double giaBan;
	private int soLuong;
	private String hangSX;
	private String link;
	private String moTa1;
	private String moTa2;
	private String khuyenMai;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int iD, int categoryId, String name, double giaBan, int soLuong, String hangSX, String link,
			String moTa1, String moTa2, String khuyenMai) {
		super();
		this.iD = iD;
		this.categoryId = categoryId;
		this.name = name;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.hangSX = hangSX;
		this.link = link;
		this.moTa1 = moTa1;
		this.moTa2 = moTa2;
		this.khuyenMai = khuyenMai;
	}


	public String getHangSX() {
		return hangSX;
	}


	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getMoTa1() {
		return moTa1;
	}


	public void setMoTa1(String moTa1) {
		this.moTa1 = moTa1;
	}


	public String getMoTa2() {
		return moTa2;
	}


	public void setMoTa2(String moTa2) {
		this.moTa2 = moTa2;
	}


	public String getKhuyenMai() {
		return khuyenMai;
	}


	public void setKhuyenMai(String khuyenMai) {
		this.khuyenMai = khuyenMai;
	}


	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	

}
