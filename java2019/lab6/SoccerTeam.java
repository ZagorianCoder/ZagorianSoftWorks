/* STAVROS ANDRONIS A.M. 3181 LOGIN:cse63181 
   APOSTOLOS-ANASTASIOS AKRIVOS A.M. 4310 LOGIN:cse74310
*/
import java.util.ArrayList;
public class SoccerTeam{
	private String name_of_team;
	private int team_wins = 0;
	private ArrayList<SoccerPlayer> playerslist = new ArrayList<SoccerPlayer>();
	public SoccerTeam(String name_of_team){
		
		this.name_of_team = name_of_team;

	}
	public void SellOldPlayer(SoccerPlayer player){
		playerslist.remove(player);
	}
	public void GetNewPlayer(SoccerPlayer player){

		playerslist.add(player);
	}
	public SoccerTeam PlaySoccer(SoccerTeam team){

		if (team_wins < team.team_wins) {

			return team;
			
		}
		if (team_wins > team.team_wins) {

			return this;
			
		}
		return null;

	}
	public void Goal(SoccerPlayer player, int goals, int fouls, int mins_of_contribution){

		for (SoccerPlayer x: playerslist){
			if (x.getPlayerName().equals(player.getPlayerName()) && x.getPlayerNum() == player.getPlayerNum()) {
				player.setGoals(player.getGoals()+goals);
				player.setFouls(player.getFouls()+fouls);
				player.setMins(player.getMins()+mins_of_contribution);
			}
		}

	}
	public void TeamStatistics(){
		int sum_of_goals=0;
		int sum_of_fouls=0;
		int sum_of_mins=0;
		int num_of_players=0;
		for (SoccerPlayer x: playerslist){
			
			sum_of_goals += x.getGoals();
			sum_of_fouls += x.getFouls();
			sum_of_mins += x.getMins();
			num_of_players += 1;

		}
		double average_of_mins = sum_of_mins/(double)num_of_players;
		System.out.println("Team Wins:"+team_wins);
		System.out.println("Total Goals of Team:"+sum_of_goals);
		System.out.println("Total fouls of team:"+sum_of_fouls);
		System.out.println("average of mins of the team is:"+ average_of_mins);

	}
}
