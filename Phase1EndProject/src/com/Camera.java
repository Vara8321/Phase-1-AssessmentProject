package com;

public class Camera {
     int cameraID;
     String brand;
     String model;
     float rentalRate;
     String status;
	public Camera(int id, String brand, String model, float rentalRate, String status) {
		this.cameraID=id;
		this.brand=brand;
		this.model=model;
		this.rentalRate=rentalRate;
		this.status=status;
	}
	public Camera(int cameraID2, String brand2, String model2, float rentalRate2) {
		// TODO Auto-generated constructor stub
		this.cameraID=cameraID2;
		this.brand=brand2;
		this.model=model2;
		this.rentalRate=rentalRate2;
	}
	public int getCameraID() {
		return cameraID;
	}
	public void setCameraID(int cameraID) {
		this.cameraID = cameraID;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(float rentalRate) {
		this.rentalRate = rentalRate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Camera [cameraID=" + cameraID + ", brand=" + brand + ", model=" + model + ", rentalRate=" + rentalRate
				+ ", status=" + status + "]";
	}
	
     
}

