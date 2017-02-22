package edu.neumont.csc150.a6.connerp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Ticker {
	private static ArrayList<TimerContainer> timers = new ArrayList<TimerContainer>();
	private static long time = 0;
	
	private static boolean init = false;
	private static Timer timer = new Timer(16, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			long lastTime = time;
			
			//overflow catch (and a sneaky time increment)
			if((time+=16) < lastTime){
				timers.clear();
			}
			
			if(timers.size() > 0){
				for(int i = 0; i < timers.size(); i++){
					timers.get(i).callTickListener(time);
				}
			}
			timer.start();
		}
	});
	
	public static void DelayStart(int milli, ITickListener listener){
		TimerContainer t = findTimer();
		t.TickStart(time, milli, listener);
		if(!init){
			timer.start();
			init = true;
		}
	}
	
	private static TimerContainer findTimer(){
		if(timers.size() > 0){
			for(TimerContainer t : timers){
				if(!t.isListening()) return t;
			}
		}
		
		TimerContainer t = new TimerContainer();
		timers.add(t);
		return t;
	}
	
	private static class TimerContainer{
		private ITickListener listener;
		private long milliTime = -1;
		private boolean listening = false;
		
		public boolean isListening(){
			return listening;
		}
		
		public void callTickListener(double time){
			if(time >= milliTime && listening){
				listener.DelayEnded();
				listening = false;
			}
		}
		
		public void TickStart(long time, long delay, ITickListener listener){
			milliTime = time + delay;
			listening = true;
			this.listener = listener;
		}
	}
}