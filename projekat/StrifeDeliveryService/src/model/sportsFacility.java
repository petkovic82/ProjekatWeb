package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.SportsFacilityStatus;

@XmlRootElement
public class SportsFacility{

	private String name; 
	private SportsFacilityCategory category; //teretana, bazen, sportski centar, plesni studio
	//private ArrayList<String> products; //sadrzaj u ponudi npr grupni, personalni treninzi, u paru, sauna, masaza
	private SportsFacilityStatus status; //radi ili ne radi
	private Address location;	
	private boolean deleted = false;
	private String rating = "-"; //ocena
	//private Time pocetno i krajnje radno vreme ili TimeSpan
	//logo objekta slika
	
	public sportsFacility(String name, SportsFacilityCategory  type, SportsFacility status, Address location) {
		super();
		this.name = name;
		this.category = type;
		this.status = status;
		this.location = location;
		//this.products = new ArrayList<String>();
	}
	
	public sportsFacility() {
		super();
		this.name = null;
		this.category = null;
		this.status = null;
		this.location = null;
		//this.products = new ArrayList<String>();	
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SportsFacilityCategory getCategory() {
		return category;
	}

	public void setCategory(String type) {
		this.category = type;
	}

	public sportsFacilitygetStatus() {
		return status;
	}

	public void setStatus(sportsFacilityStatus) {
		this.status = status;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

/*	public ArrayList<String> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}
	
	public void addProduct(String productId) {
		if (!this.products.contains(productId))
			this.products.add(productId);
	}*/

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Objekat [name=" + name + ", type=" + type + ", products=" + products + ", status=" + status
				+ ", location=" + location + "]";
	}
	
	public String getRating() {
		return this.rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}

		
}
