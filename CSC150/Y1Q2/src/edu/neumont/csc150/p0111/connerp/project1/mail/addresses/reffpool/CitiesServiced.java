package edu.neumont.csc150.p0111.connerp.project1.mail.addresses.reffpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CitiesServiced {
	@SuppressWarnings("serial")
	public static final ArrayList<Integer> zipPool = new ArrayList<Integer>(){{
		add(80148);
		add(80149);
		add(80150);
		add(80151);
		add(80152);
	}};
	@SuppressWarnings("serial")
	public static final Map<Integer, UtahCity> cityPool = new HashMap<Integer, UtahCity>(){{
		put(zipPool.get(0), new UtahCity(zipPool.get(0), 0, 		0, 		100, 	100, 	1000, 	1000, 	500, 500));
		put(zipPool.get(1), new UtahCity(zipPool.get(1), 25000, 	10000, 	150, 	50, 	1200, 	700, 	1700, 100));
		put(zipPool.get(2), new UtahCity(zipPool.get(2), 35000, 	15000, 	108, 	125, 	500, 	5000, 	300, 1200));
		put(zipPool.get(3), new UtahCity(zipPool.get(3), 50000, 	6000, 	175, 	200, 	800, 	400, 	600, 800));
		put(zipPool.get(4), new UtahCity(zipPool.get(4), 95000, 	50000, 	80, 	75, 	200, 	2500, 	100, 200));
	}};

	public static double DistanceBetweenZips(int zip, int zip2) {
		UtahCity city1 = cityPool.get(zip), city2 = cityPool.get(zip2);
		return Math.sqrt( Math.pow(city1.xOff + city2.xOff, 2) +  Math.pow(city1.yOff + city2.yOff, 2));
	}
}