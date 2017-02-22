package edu.neumont.csc150.a1.connerp.inheritance.clinic.data;

public enum Procedures {
	//visit is $200, surgery is $5000, and procedure is $1000
	Visit(200),
	Surgery(5000),
	Procedure(1000);
	
	public final int cost;
	private Procedures(int cost){
		this.cost = cost;
	}
}
