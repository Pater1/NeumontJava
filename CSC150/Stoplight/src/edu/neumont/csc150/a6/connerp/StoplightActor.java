package edu.neumont.csc150.a6.connerp;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public abstract class StoplightActor extends Sprite implements IStoplightListener, ITickListener {
	private static final long serialVersionUID = 8872413550326272398L;
	
	private JFrame superParent;
	protected double targetMoveSpeed, curMoveSpeed, acceleration = 1;
	private int tickRate;
	private Vector2 dir;
	
	public StoplightActor(int tick, String filePath, JFrame frame){
		super(filePath);
		tickRate = tick;
		dir = Vector2.randDir();
		superParent = frame;

		Ticker.DelayStart(tickRate, this);

		this.setLocation(new Point((int)(Math.random() * frame.getSize().width), (int)(Math.random() * frame.getSize().height)));
	}
	public static StoplightActor randomActor(int tick, JFrame frame){
		int r = (int)(Math.random() * 4);
		switch(r%3){
			case 0:
				return new Person(tick, frame);
			case 1:
				return new Dog(tick, frame);
			default:
				return new Car(tick, frame);
		}
	}

	public void setMoveSpeed(int speed){
		if(speed >= 0){
			targetMoveSpeed = speed;
		}
	}
	public double getMoveSpeed(){
		return targetMoveSpeed;
	}
	
	private boolean outOfBounds(){
		Point loc = getLocation();
		Dimension dim = superParent.getSize(), siz = getSize();
		
		return loc.x < 0 || loc.y < 0 || loc.x > dim.width - siz.width || loc.y > dim.height - siz.width;
	}

	
	private Vector2 checkBounds(Vector2 check){
		Point loc = getLocation();
		Dimension dim = superParent.getSize(), siz = getSize();
		
		if(!outOfBounds()) return check;
		
		check = Vector2.randDir();
		if(loc.x < 0){
			check.x = Math.abs(check.x);
		}else if(loc.y < 0){
			check.y = Math.abs(check.y);
		}else if(loc.x > dim.width - siz.width){
			check.x = -Math.abs(check.x);
		}else if(loc.y > dim.height - siz.width){
			check.y = -Math.abs(check.y);
		}
		
		return check;
	}

	@Override
	public void DelayEnded() {
		Point here = this.getLocation();
		
		dir = checkBounds(dir);
		
		double speedDelta = Math.signum(targetMoveSpeed - curMoveSpeed) * acceleration;
		curMoveSpeed += speedDelta;
		if(Math.abs(curMoveSpeed) < 0.1) curMoveSpeed = 0;
		
		Vector2 delta = dir.multiply(curMoveSpeed);
		here.x += delta.x;
		here.y += delta.y;
		this.setLocation(here);
		
		Ticker.DelayStart(tickRate, this);
		repaint();
	}
	
	public static class Vector2{
		public double x, y;

		public Vector2 multiply(double multiple){
			return new Vector2(multiple * x, multiple * y);
		}
		public Vector2 multiply(int multiple){
			return new Vector2(multiple * x, multiple * y);
		}
		
		public static Vector2 randDir(){
			double rand = Math.random() * Math.PI * 2;
			return new Vector2(Math.cos(rand), Math.sin(rand));
		}
		
		public String toString(){
			return "Vector2: [" + x + " " + y + "]";
		}
		
		public Vector2(){
			x = 0;
			y = 0;
		}
		public Vector2(double x, double y){
			this.x = x;
			this.y = y;
		}
		public Vector2(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}