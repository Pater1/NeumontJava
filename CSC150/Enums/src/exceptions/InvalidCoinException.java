package exceptions;

public class InvalidCoinException extends Exception{
	public InvalidCoinException(){
		super();
	}
	public InvalidCoinException(String string) {
		super(string);
	}
}
