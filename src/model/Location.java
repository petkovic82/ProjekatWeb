package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
//Geografska dužina
// Geografska širina
// Adresa u formatu: ulica i broj, mesto/grad, poštanski broj
	private float getLatitude;
	private float getLongitude;
	
	public Location(float getLatitude, float getLongitude) {
		super();
		this.getLatitude = getLatitude;
		this.getLongitude = getLongitude;
	}

	public float getGetLatitude() {
		return getLatitude;
	}

	public void setGetLatitude(float getLatitude) {
		this.getLatitude = getLatitude;
	}

	public float getGetLongitude() {
		return getLongitude;
	}

	public void setGetLongitude(float getLongitude) {
		this.getLongitude = getLongitude;
	}
	
	
	
}
