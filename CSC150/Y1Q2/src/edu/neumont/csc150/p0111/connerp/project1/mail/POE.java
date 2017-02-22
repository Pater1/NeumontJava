package edu.neumont.csc150.p0111.connerp.project1.mail;

import java.util.Random;

public class POE {
	//POE.randomNumberGenerator.nextInt(0,1);
	public static final Random randomNumberGenerator = new Random(1024);

	private static PostOffice post;
	public static void main(String[] args) {
		post = new PostOffice();
		post.GenerateMail(100000);
		post.DistanceSortMail();
		post.FillTrucks(10);
		
		for(int j = 0; j < post.fleet.size(); j++){
			for(int i = 0; i < post.fleet.get(j).route.size(); i++){
				System.out.println(post.fleet.get(j).route.get(i).toString());
			}
			System.out.println(post.fleet.get(j).routeMetrics());
		}
	}

}