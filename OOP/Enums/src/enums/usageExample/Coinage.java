package enums.usageExample;

import java.util.ArrayList;

import exceptions.InvalidCoinException;

public enum Coinage {
	PENNY		(0.01f),
	NICKEL		(0.05f),
	DIME		(0.10f),
	QUARTER		(0.25f),
	FIFTY_CENT	(0.50f);
	
	private final float value;
	private final char initial;
	private Coinage(float val){
		this.value = val;
		this.initial = Character.toUpperCase(this.name().charAt(0));
	}
	
	public float GetValue(){
		return value;
	}
	public char GetInitial(){
		return initial;
	}

	public static Coinage convert(int value) throws InvalidCoinException{
		return convert(value / 100.0f);
	}
	public static Coinage convert(double value) throws InvalidCoinException{
		return convert((float)value);
	}
	
	public static Coinage convert(float value) throws InvalidCoinException{
		String vals = "";
		for(Coinage coin : Coinage.values()){
			if(value == coin.value) return coin;
			vals += "$" + coin.value + ", ";
		}
		throw new InvalidCoinException("$" + value + " can not be counted in a single coin! Please restrict to one of the following values: " + vals);
	}
	
	public static Coinage convert(char initial) throws InvalidCoinException{
		String vals = "";
		for(Coinage coin : Coinage.values()){
			if(initial == coin.initial) return coin;
			vals += "$" + coin.initial + ", ";
		}
		throw new InvalidCoinException("$" + initial + " can not be counted in a single coin! Please restrict to one of the following values: " + vals);
	}
	
	public static ArrayList<String> NameAndInitials(){
		ArrayList<String> ret = new ArrayList<String>();
		for(Coinage coin : values()){
			ret.add("" + coin.initial + "- " + coin.name());
		}
		return ret;
	}
}
