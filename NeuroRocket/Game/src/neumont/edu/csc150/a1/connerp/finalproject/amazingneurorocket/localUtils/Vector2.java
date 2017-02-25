package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils;

public class Vector2{
	public double x,y;
	
	public String toString(){
		return "<" + x + "," + y + ">";
	}
	
	public Vector2(int xValue, int yValue){
		this.x = xValue;
		this.y = yValue;
	}
	
	public Vector2(double xValue, double yValue){
		this.x = xValue;
		this.y = yValue;
	}

	public Vector2 normalize() {
		if(x == 0 && y == 0){
			//do nothing
		}else if(x == 0){
			y = 1 * Math.signum(y);
		}else if(y == 0){
			x = 1 * Math.signum(x);
		}else{
			double angle = Math.atan2(y, x);
			y = Math.sin(angle);
			x = Math.cos(angle);
		}
		return this;
	}

	public Vector2 multiply(double scalar) {
		y = y * scalar;
		x = x * scalar;
		return this;
	}
}
