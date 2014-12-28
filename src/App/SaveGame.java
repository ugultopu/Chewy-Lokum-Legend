package App;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SaveGame {
	
	public static void saveBoardToXML() throws IOException{
		
		int player_id = 1;
		String player_name = "default";
		LogicField[][] lokumBoard = BoardLogic.getInstance().getBoard();		
		
		int goal_score = InformationBoard.getInstance().getGoalScore();
		int current_score = Score.getInstance().getCurrentScore();
		int moves_left = MoveLevelPanel.getInstance().getMovesLeft();
		int level = InformationBoard.getInstance().getCurrentLevel();
		

		
		BufferedWriter wr = new BufferedWriter(new FileWriter("save.xml"));
		wr.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		wr.write("<game>");
		
		wr.write("<player>");
		wr.write("<id>"+player_id+"</id>");
		wr.write("<name>"+player_name+"</name>");
		wr.write("</player>");
		
		wr.write("<board>");
		wr.write("<lokums>");
		for(int i=0; i<lokumBoard.length; i++){
			for(int j=0; j<lokumBoard[i].length; j++){
				LogicField lokum = lokumBoard[i][j];
				if(lokum instanceof Lokum){
					wr.write("<lokum>");
					wr.write("<color>"+((Lokum)lokum).getLokumColor()+"</color>");
					wr.write("<position>");
					wr.write("<xcoord>"+((Lokum)lokum).getColumnIndex()+"</xcoord>");
					wr.write("<ycoord>"+((Lokum)lokum).getRowIndex()+"</ycoord>");
					wr.write("</position>");
					wr.write("<type>"+lokum.getType()+"</type>");
					wr.write("</lokum>");
				}
			}
		}
		wr.write("</lokums>");
		
		wr.write("<obstacles>");
		for(int i=0; i<lokumBoard.length; i++){
			for(int j=0; j<lokumBoard[i].length; j++){
				LogicField obstacle = lokumBoard[i][j];
				if(obstacle instanceof Obstacle){
					obstacle = (Obstacle) obstacle;
					wr.write("<obstacle>");
					wr.write("<color>"+((Obstacle)obstacle).getObstacleColor()+"</color>");
					wr.write("<position>");
					wr.write("<xcoord>"+((Obstacle)obstacle).getColumnIndex()+"</xcoord>");
					wr.write("<ycoord>"+((Obstacle)obstacle).getRowIndex()+"</ycoord>");
					wr.write("</position>");
					wr.write("</obstacle>");
				}
			}
		}
		wr.write("</obstacles>");
		wr.write("</board>");
		wr.write("<goalscore>"+goal_score+"</goalscore>");
		wr.write("<currentscore>"+current_score+"</currentscore>");
		wr.write("<movesleft>"+moves_left+"</movesleft>");
		wr.write("<level>"+level+"</level>");
		wr.write("</game>");
		wr.close();
			
	}
	
	public static void main(String[] args){
		
		try {
			saveBoardToXML();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
