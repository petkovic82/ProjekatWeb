package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerType {
//	Ime tipa (npr. Zlatni, Srebrni, Bronzani)
// Popust (procenat koji se koristi za obračunavanje cene članarine prilikom kupovine)
//Traženi broj bodova (potreban broj bodova kako bi korisnik postao npr. Zlatni kupac)
	private String name;
	private int discount;	// U procentima - 80%
	private int minPoints;
	
	public CustomerType(String name, int dicount, int minPoints) {
		super();
		this.name = name;
		this.discount = dicount;
		this.minPoints = minPoints;
	} 	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDicount() {
		return discount;
	}
	public void setDicount(int dicount) {
		this.discount = dicount;
	}
	public int getMinPoints() {
		return minPoints;
	}
	public void setMinPoints(int minPoints) {
		this.minPoints = minPoints;
	}

	public float getDiscountFloat() {
		return (float)(this.discount)/100;
	}
	
}
