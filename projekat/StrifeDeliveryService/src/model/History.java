package model;

import java.sql.Date;
import java.util.ArrayList;


public class History {
	//bolje ovo osmisliti
	private Date dateAndTime; //datum i vreme prijave
	private ArrayList<String> treningIds;
	private String kupacId;
	private String trenerId;
	private boolean deleted;
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public History(ArrayList<String> treninzi, String kupac, String trener) {
		super();
		this.treningIds =  treninzi;
		this.kupacId = kupac;
		this.trenerId = trener;
	}
	
	public History(String kupacID) {
		super();
		this.treningIds = new ArrayList<String>();
		this.kupacId = kupacID;
	}
	
	public ArrayList<String> getItems() {
		return treningIds;
	}
	public void setItems(ArrayList<String> items) {
		this.treningIds = items;
	}
	public String getKupacId() {
		return this.kupacId;
	}
	public void setKupac(Customer kupac) {
		this.kupacId = kupac.getId();
	}

	/*
	public void addTreningToList(Trening item) {
		
		for (Trening c : items) {
			if (c.getTrening().getId().equals(item.getTrening().getId())) {
				c.setAmount(c.getAmount()+item.getAmount());
				return;
			}				
		}
		
		items.add(item);	
	}
	
	public void updateTreningList(TreningDTO item) {
		
		for (Trening c : items) {
			if (c.getTrening().getId().equals(item.treningId)) {
				c.setAmount(item.amount);
				return;
			}				
		}
	}

	public void removeTreningFromList(String treningID) {
		for (Trening c : items) {
			if (c.getTrening().getId().equals(treningID)) {
				items.remove(c);
				return;
			}				
		}
		
	}
	
	public void emptyTreningList() {
		this.items = new ArrayList<String>();
	}
ako cuvamo cele treninge
*/

}
