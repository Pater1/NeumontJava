import java.text.DecimalFormat;
import java.util.*;

public class DieRoller {

	public static ArrayList<Integer> dieRolls = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		EvaluateDataSet(DieRollList(10,1,6));
	}
	
	private static void EvaluateDataSet(ArrayList<Integer> dataSet){
		System.out.println("Data set values:");
		for(int i : dataSet){
			System.out.println("     " + i);
		}
		System.out.println("set max: " + GetMaxOfList(dataSet));
		System.out.println("set min: " + GetMinOfList(dataSet));
		System.out.println("set sum: " + GetSumOfList(dataSet));
		
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		System.out.println("set mean: " + twoDForm.format(GetMeanOfList(dataSet)));
		System.out.println("set median: " + twoDForm.format(GetMedianOfList(dataSet)));
		
		System.out.println("set modes: " + ConcantinateListOfInts(GetModesOfList(dataSet)));
	}
	
	private static String ConcantinateListOfInts(ArrayList<Integer> input){
		String output = "";
		for(int i = 0; i < input.size(); i++){
			if(i > 0){
				output += "& ";
			}
			output += input.get(i) + " ";
		}
		return output;
	}

 	private static Double GetMeanOfList(ArrayList<Integer> input){
		double output = 0;
		output = GetSumOfList(input)/(double)input.size();
		return output;
	}
	private static Double GetMedianOfList(ArrayList<Integer> input){
		ArrayList<Integer> output = input;
		boolean removeHigh = false;
		int toRemove = 0;
		
		int endPoint = input.size()%2;
		if(endPoint == 0) endPoint += 2;
		
		while(output.size() > endPoint){
			toRemove = output.get(0);
			if(removeHigh){
				for(int i : output){
					if(i > toRemove){
						toRemove = i;
					}
				}
			}else{
				for(int i : output){
					if(i < toRemove){
						toRemove = i;
					}
				}
			}
			removeHigh = !removeHigh;
			output.remove((Object)toRemove);
		}
		if(endPoint != 2){
			return (double) output.get(0);
		}else{
			return (double) ( (output.get(0)+output.get(1))/2 );
		}
	}
	private static ArrayList<Integer> GetModesOfList(ArrayList<Integer> input){
		ArrayList<ModeContainer> modes = new ArrayList<ModeContainer>();
		for(int i = 0; i < input.size(); i++){
			boolean inModes = false;
			for(ModeContainer md : modes){
				if(md.mode == input.get(i)){
					inModes = true;
					md.modeCount++;
					break;
				}
			}
			if(!inModes){
				ModeContainer mdc = ModeContainer.New();
				mdc.mode = input.get(i);
				mdc.modeCount = 1;
				modes.add(mdc);
			}
		}

		ArrayList<Integer> output = new ArrayList<Integer>();
		int maxModeCount = 0;
		for(ModeContainer md : modes){
			if(md.modeCount > maxModeCount){
				output.clear();
				output.add(md.mode);
				maxModeCount = md.modeCount;
			}else if(md.modeCount == maxModeCount && !output.contains(md.mode)){
				output.add(md.mode);
			}
		}
		
		return output;
	}
	private static class ModeContainer{
		public Integer mode, modeCount;
		
		public static ModeContainer New(){
			return new ModeContainer();
		}
	}
	private static Integer GetMaxOfList(ArrayList<Integer> input){
		Integer output = input.get(0);
		for(int i : input){
			if(i > output){
				output = i;
			}
		}
		return output;
	}
	private static Integer GetMinOfList(ArrayList<Integer> input){
		Integer output = input.get(0);
		for(int i : input){
			if(i < output){
				output = i;
			}
		}
		return output;
	}
	private static Integer GetSumOfList(ArrayList<Integer> input){
		Integer output = 0;
		for(int i : input){
			output += i;
		}
		return output;
	}
	
	private static ArrayList<Integer> DieRollList(int count, int rollFloor, int rollCeiling){
		ArrayList<Integer> outPut = new ArrayList<Integer>();
		for(int i = 0; i < count; i++){
			outPut.add(RollDie(rollFloor,rollCeiling));
		}
		return outPut;
	}
	
	private static Integer RollDie(int floor, int ceiling){
		ceiling += 1;
		return (int) (Math.random() * (floor-ceiling) + ceiling);
	}
}