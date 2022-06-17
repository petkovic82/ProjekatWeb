package model;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.TreningType;

@XmlRootElement
public class Trening {

//	private String trenerId;
//	private String objekatId;
	private String id;
	private String name;
	private TreningType type; //grupni personalni u dvoje
	private int duration = 0; //u min ili h trajanje
	private String description = "";
//	private boolean deleted = false;
	//slika
	
	public Trening( String trenerId, String objekatId, String id, String name, TreningType type, int duration,
			String description) {
		super();
		this.trenerId = trenerId;
		this.objekatId = objekatId;
		this.id = id;
		this.name = name;
		this.type = type;
		this.duration = duration;
		this.description = description;
	}

	public int getTrenerId() {
		return trenerId;
	}

	public void setTrenerId(int trenerId) {
		this.trenerId = trenerId;
	}


	public int getObjekatId() {
		return objekatId;
	}

	public void setObjekatId(int objekatId) {
		this.objekatId = objekatId;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public TreningType getType() {
		return type;
	}

	public void setType(TreningType type) {
		this.type = type;
	}

	public int getDuration () {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public boolean isDeleted() {
		return deleted;
	}

	//public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Trening () {
		super();
	}

	
	
}
