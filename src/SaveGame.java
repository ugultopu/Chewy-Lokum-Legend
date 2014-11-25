import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class SaveGame {
	
	public static void saveBoardToXML() throws IOException{
		
		int player_id = 1;
		String player_name = "default";
		BoardLogic lokumBoard = BoardLogic.getInstance().getLokums();
		int goal_score = BoardLogic.getInstance().getGoalScore();
		int current_score = BoardLogic.getInstance().getCurrentScore();
		int moves_left = BoardLogic.getInstance().getMovesLeft();
		int level = BoardLogic.getInstance().getLevel();
		
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
			for(int j=0; j<lokumBoard.length[i].length; i++){
				LogicField lokum = lokumBoard[i][j];
				if(lokum instanceof Lokum){
					lokum = (Lokum) lokum;
					wr.write("<lokum>");
					wr.write("<color>"+lokum.getColor()+"</color>");
					wr.write("<position>");
					wr.write("<xcoord>"+lokum.getX()+"</xcoord>");
					wr.write("<ycoord>"+lokum.getY()+"</ycoord>");
					wr.write("</position>");
					wr.write("<type>"+lokum.getType()+"</type>");
					wr.write("</lokum>");
				}
			}
		}
		wr.write("</lokums>");
		
		wr.write("<obstacles>");
		for(int i=0; i<lokumBoard.length; i++){
			for(int j=0; j<lokumBoard.length[i].length; i++){
				LogicField obstacle = lokumBoard[i][j];
				if(obstacle instanceof Obstacle){
					obstacle = (Obstacle) obstacle;
					wr.write("<obstacle>");
					wr.write("<color>"+obstacle.getColor()+"</color>");
					wr.write("<position>");
					wr.write("<xcoord>"+obstacle.getX()+"</xcoord>");
					wr.write("<ycoord>"+obstacle.getY()+"</ycoord>");
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

}
