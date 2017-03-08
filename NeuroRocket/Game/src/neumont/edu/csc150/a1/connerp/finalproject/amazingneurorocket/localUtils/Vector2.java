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

	public Vector2(Vector2 vector2) {
		this.x = vector2.x;
		this.y = vector2.y;
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
		return new Vector2(scalar * x, scalar * y);
	}
	public Vector2 add(Vector2 vec){
		return new Vector2(vec.x + this.x, vec.y + this.y);
	}

	public static Vector2 resolveFromAngle(double angle) {
		return new Vector2(Math.cos(angle), Math.sin(angle));
	}
	
	public double magnitude(){
		double locX = Math.abs(x), locY = Math.abs(y);
		return Math.pow(locX * locX + locY * locY, 1.0/2.0);
	}

	public double getAngle() {
		return Math.atan2(y, x);
	}
}
