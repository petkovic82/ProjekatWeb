package model;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.Gender;
import enumeration.UserCategory;

@XmlRootElement
public class Trener extends User {
//dodati sta treba
	private ArrayList<String> treninzi; //cuva Id

	public Trener (String id, String password, String name, String lastName, Gender gender, Date dateOfBirth,
			UserCategory category) {
		super(id, password, name, lastName, gender, dateOfBirth, category);
		this.treninzi = new ArrayList<String>();
		this.setCategory(UserCategory.TRENER);
	}

	public ArrayList<String> getTreninzi() {
		return treninzi;
	}

	public void setTreninzi(ArrayList<String> treninzi) {
		this.treninzi = treninzi;
	}

	public void addTrening(String TreningId) {
		if (!this.treninzi.contains(TreningId) )
			this.treninzi.add(TreningId);		
	}

	public void removeTrening(String TreningId) {
		if (this.treninzi.contains(TreningId))
			this.treninzi.remove(TreningId);	
		
	}

}
