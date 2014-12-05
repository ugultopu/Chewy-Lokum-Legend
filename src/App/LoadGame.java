package App;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class LoadGame {
	
	public static boolean loadGameFromXML(){
		
		
		
		try {
			File saveFile = new File("save.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(saveFile);
			
			document.getDocumentElement().normalize();
			
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			NodeList inGameNodes = document.getDocumentElement().getChildNodes();
			/* Player */
			/* Nothing to do with player yet */
			
			/* Board */
			Node board = inGameNodes.item(1);
			
			/* Lokums */
			NodeList lokums = board.getChildNodes().item(0).getChildNodes();
			for(int i=0; i<lokums.getLength();i++){
				Node lokum = lokums.item(i);
			}
			
			NodeList lokumList = document.getElementsByTagName("lokum");
			
			
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	
	
	public static void main(String[] args){
		
		loadGameFromXML();
	}
	
	
}
