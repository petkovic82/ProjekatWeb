package model;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.MembershipStatus;

@XmlRootElement
public class Membership{


	private String id; // 10 karaktera
	private MembershipType tip; //godisnja mesecna
	private Date date; //datum placanja
	private Date dateAndTime; //do kad vazi 
	private float price;
	private String korisnikId; 
	private int brojTermina;

	private MembershipStatus status; //aktivna neaktivna

	public Membership(String id, MembershipType tip, Date date, float price,
			String customerId,int brojTermina, MembershipStatus status) {
		super();
		this.id = id;
		this.tip = tip;
		this.date = date;

/* za mesecnu dodaj 30 dana od datuma, za godisnju 365 dana
		this.dateAndTime = dateAndTime; */
		this.price = price;
		this.korisnikId = customerId;
		this.brojTermina = brojTermina;
		this.status = status;
	}
	
	public Membership() {
		super();

		this.id = null;
		this.tip = null;
		this.date = null;
		this.dateAndTime = null;
		this.price = 1;
		this.korisnikId = null;

		this.brojTermina = 1;
		this.status = null;
	}
//dodaj preostale getere i setere

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public float getPrice() {

		return price;
	}

	public void setPrice() {
		this.price = 0;

		for (Trening item : items)
			price += item.getAmount() * item.getTrening().getPrice();
	}

	public String getCustomerId() {
		return korisnikId;
	}

	public void setCustomerId(String customer) {
		this.korisnikId = customer;
	}

	public MembershipStatus getStatus() {
		return status;
	}

	public void setStatus(MembershipStatus status) {
		this.status = status;
	}

/*	public int generateCancelPoints() {
		return (int) (this.getPrice() / 1000 * 133 * 4);
	}

	public int generatePoints() {
		return (int) (this.getPrice() / 1000 * 133);
	}

	public void applyDiscount(float discountFloat) {
		System.out.println("Old price: " + getPrice());
		System.out.println("Discount: " + discountFloat);
		this.price = getPrice() * (1 - discountFloat);
		System.out.println("New price: " + getPrice());

	}*/

}
