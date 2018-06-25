package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import models.Bees;
import models.User;

public class FileManager {

	public static ArrayList<User> readUsers(File file) {
		ArrayList<User> users = new ArrayList<User>();
		SAXBuilder builder = new SAXBuilder();
	    try {
	        Document document = (Document) builder.build(file);
	        Element rootNode = (Element) ((org.jdom2.Document) document).getRootElement();
	        List<Element> userFileList = ((org.jdom2.Element) rootNode).getChildren("Player");
	        User user;
	        for (Element player : userFileList) {
	        	String name = player.getChildTextTrim("Name");
	        	int x = Integer.parseInt(player.getChildTextTrim("X"));
	        	int y = Integer.parseInt(player.getChildTextTrim("Y"));
	        	user = new User(name, x, y);
	            users.add(user);
	        }
	    }catch (IOException io) {
	        System.err.println(io.getMessage());
	    }catch (JDOMException jdomex) {
	        System.err.println(jdomex.getMessage());
	    }
		return users;
	}
	
	public static ArrayList<String> readEnemy(File file) {
		ArrayList<String> informationEnemy = new ArrayList<>();
		SAXBuilder builder = new SAXBuilder();
	    try {
	        Document document = (Document) builder.build(file);
	        Element rootNode = (Element) ((org.jdom2.Document) document).getRootElement();
	        List<Element> enemyFileList = ((org.jdom2.Element) rootNode).getChildren("Player");
	        for (Element element : enemyFileList) {
	        	int x = Integer.parseInt(element.getChildTextTrim("X"));
	        	int y = Integer.parseInt(element.getChildTextTrim("Y"));
				informationEnemy.add(String.valueOf(x));
				informationEnemy.add(String.valueOf(y));
			}
	    }catch (IOException io) {
	        System.err.println(io.getMessage());
	    }catch (JDOMException jdomex) {
	        System.err.println(jdomex.getMessage());
	    }
	    return informationEnemy;
	}
	
	public static ArrayList<Bees> readBees(File file) {
		ArrayList<Bees> beess = new ArrayList<>();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = (Element) ((org.jdom2.Document) document).getRootElement();
			List<Element> userFileList = ((org.jdom2.Element) rootNode).getChildren("Bees");
			for (Element element : userFileList) {
				int id = Integer.parseInt(element.getChildTextTrim("Id"));
				int x = Integer.parseInt(element.getChildTextTrim("X"));
				int y = Integer.parseInt(element.getChildTextTrim("Y"));
				int type = Integer.parseInt(element.getChildTextTrim("Type"));
				beess.add(new Bees(id, x, y, type));
			}
		}catch (IOException io) {
			System.err.println(io.getMessage());
		}catch (JDOMException jdomex) {
			System.err.println(jdomex.getMessage());
		}
		return beess;
	}
}