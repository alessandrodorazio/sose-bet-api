package it.univaq.aggm;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bet")

public class Bet {
	private int localTeamId;
	private double localTeamQuote;
	private int visitorTeamId;
	private double visitorTeamQuote;
	private double tieQuote;
	
	public double getTieQuote() {
		return tieQuote;
	}

	public void setTieQuote(double tieQuote) {
		this.tieQuote = tieQuote;
	}

	public Bet() {
		
	}
	
	public Bet(int localTeamId, int visitorTeamId) {
		this.localTeamId = localTeamId;
		this.visitorTeamId = visitorTeamId;
		this.calculateQuote();
	}
	
	public void setLocalTeamId(int id) {
		this.localTeamId = id;
	}
	
	public int getLocalTeamId() {
		return this.localTeamId;
	}
	
	public void setLocalTeamQuote(double q) {
		this.localTeamQuote = q;
	}
	
	public double getLocalTeamQuote() {
		return this.localTeamQuote;
	}
	
	public void setVisitorTeamId(int id) {
		this.visitorTeamId = id;
	}
	
	public int getVisitorTeamId() {
		return this.visitorTeamId;
	}
	
	public void setVisitorTeamQuote(double q) {
		this.visitorTeamQuote = q;
	}
	
	public double getVisitorTeamQuote() {
		return this.visitorTeamQuote;
	}
	
	public void calculateQuote() {
		// generate random quotes for each team 
		this.setLocalTeamQuote(1+(Math.ceil((Math.random() * (5-1))*100))/100 );
		this.setVisitorTeamQuote(1+(Math.ceil((Math.random() * (5-1))*100))/100 );
		this.setTieQuote(1+(Math.ceil((Math.random() * (5-1))*100))/100 );
	}
}
