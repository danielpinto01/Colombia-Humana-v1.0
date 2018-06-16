package persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.Player;

public class FileManager {
	
	@SuppressWarnings("unchecked")
	public void writeJsonPlayer(ArrayList<Player> players) throws IOException {
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		for (Player player : players) {
			JSONObject not = new JSONObject();
			not.put("namePlayer", player.getNamePlayer());
			not.put("characterPlayer", player.getCharacterPlayer());
			not.put("positionX", player.getPositionInX());
			not.put("positionY", player.getPositionInY());
			array.add(not);
		}
		
		root.put("Players", array);
		
		FileWriter outputStream = new FileWriter(new File("./players.json"));
		outputStream.write(root.toJSONString());
		outputStream.close();
	}
}