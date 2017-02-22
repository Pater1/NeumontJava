package edu.neumont.csc150.a1.connerp.enums.usageExample;

import java.io.IOException;
import java.util.ArrayList;
import edu.neumont.csc150.a1.connerp.utilities.*;

public enum DifficultySelect {
	BOOST_ENEMY_HEALTH	(1),
	BOOST_ENEMY_DAMAGE	(2),
	BOOST_PLAYER_HEALTH	(4),
	BOOST_PLAYER_DAMAGE	(8),
	EASY				(BOOST_PLAYER_HEALTH.flag | BOOST_PLAYER_DAMAGE.flag),
	HARD				(BOOST_ENEMY_HEALTH.flag | BOOST_ENEMY_DAMAGE.flag);
	
	private final int flag;
	private DifficultySelect(int flag){
		this.flag = flag;
	}
	public int GetFlag(){
		return flag;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(DifficultySelect.ConsolePromptForDifficulty().name());
	}
	
	public static DifficultySelect ConsolePromptForDifficulty() throws IOException{
		do{
			System.out.println("Please select a coin to display:");
			Utilities.PrintList(NameAndInitials());
			try{
				String inp = Utilities.PromptUser("Please make your selection");
				int i = Integer.parseInt(inp);
				return values()[i];
			}catch(Exception ex){
				System.out.println("Not a valid selection. Please try again");
				System.out.println();
			}
		}while(true);
	}
	private static ArrayList<String> NameAndInitials() {
		ArrayList<String> names = new ArrayList<String>();
		
		for(int i = 0; i < values().length; i++){
			names.add("" + i + "- " + values()[i].name());
		}
		
		return names;
	}
}