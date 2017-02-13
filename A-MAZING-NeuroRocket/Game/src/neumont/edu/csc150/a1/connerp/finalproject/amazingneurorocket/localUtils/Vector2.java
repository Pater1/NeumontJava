package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils;

public class Vector2{
	public int x,y;
	
	public String toString(){
		return "<" + x + "," + y + ">";
	}
	
	public Vector2(int xValue, int yValue){
		this.x = xValue;
		this.y = yValue;
	}
}
