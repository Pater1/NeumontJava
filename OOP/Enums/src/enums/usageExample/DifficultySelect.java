package enums.usageExample;

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
}