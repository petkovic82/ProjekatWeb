package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.Gender;
import enumeration.UserCategory;

@XmlRootElement
public class Manager extends User {

//dodati jos par polja

	public Manager(String id, String password, String name, String lastName, Gender gender, Date dateOfBirth,
			UserCategory category, String restaurantId) {
		super(id, password, name, lastName, gender, dateOfBirth, category);
	
		this.setCategory(UserCategory.MANAGER);
	}


	
	
	
	

}
