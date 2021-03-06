/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
public class SoccerPlayer{
	private int player_num;
	private String player_name;
	private int goals;
	private int fouls;
	private int mins_of_contribution;
	private SoccerTeam player_team = null;
	public SoccerPlayer(int player_num,String player_name){

		this.player_name = player_name;
		this.player_num = player_num;

	}
	public String toString(){
		if (player_team == null) {

			return player_name;
			
		}
		return player_num+" "+player_name+", "+goals+" "+fouls+" "+mins_of_contribution+"; "+player_team;
	}
	public void setPlayerName(String player_name){
		this.player_name = player_name;
	}
	public void setPlayerNum(int player_num){
		this.player_num = player_num;
	}
	public void setGoals(int goals){
		this.goals = goals;
	}
	public void setFouls(int fouls){
		this.fouls = fouls;
	}
	public  void setMins(int mins_of_contribution){
		this.mins_of_contribution = mins_of_contribution;
	}
	public String getPlayerName(){
		return player_name;
	}
	public int getPlayerNum(){
		return player_num;
	}
	public int getGoals(){
		return goals;
	}
	public int getFouls(){
		return fouls;
	}
	public int getMins(){
		return mins_of_contribution;
	}
	public boolean PlayerGoesToTeam(SoccerTeam team){
		if (player_team == null) {
			
			player_team = team;
			team.GetNewPlayer(this);
			return true;
		}
		if(!player_team.equals(team)){
			player_team.SellOldPlayer(this);
			player_team = team;
			team.GetNewPlayer(this);
			return true;
		}
		return false;
	}
}
