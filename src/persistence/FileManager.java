package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

	@SuppressWarnings("unchecked")
	public void writeJsonOnePlayer(Player player) throws IOException {
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject not = new JSONObject();
		not.put("namePlayer", player.getNamePlayer());
		not.put("characterPlayer", player.getCharacterPlayer());
		not.put("positionX", player.getPositionInX());
		not.put("positionY", player.getPositionInY());
		array.add(not);

		root.put("Player", array);

		FileWriter outputStream = new FileWriter(new File(player.getNamePlayer() + "Information.json"));
		outputStream.write(root.toJSONString());
		outputStream.close();
	}


	@SuppressWarnings("unused")
	public ArrayList<String> read() throws IOException, ParseException{
		ArrayList<String> playerList = new ArrayList<>();
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject) 
				parser.parse(new FileReader("players.json"));

		JSONArray playersRoot = (JSONArray) root.get("Players");

		ArrayList<String> title = new ArrayList<>();
		for (int i = 0; i < playersRoot.size(); i++) {
			JSONObject jsonObject = (JSONObject) playersRoot.get(i);

			String name = (String)jsonObject.get("namePlayer");
			String character = (String)jsonObject.get("characterPlayer");
			int x = (int)(long)jsonObject.get("positionX");
			int y = (int)(long)jsonObject.get("positionY");

			playerList.add(name);
			playerList.add(character);
			playerList.add(String.valueOf(x));
			playerList.add(String.valueOf(y));
		}
		System.out.println(playerList);
		return playerList;
	}

//	public static void main(String[] args) {
//		FileManager fileManager = new FileManager();
//		try {
//			fileManager.writeJsonOnePlayer(new Player("Daniel", "PALOMA", 500, 600));
//			fileManager.writeJsonOnePlayer(new Player("Felipe", "PALOMA", 500, 600));
//			fileManager.writeJsonOnePlayer(new Player("Camilo", "PALOMA", 500, 600));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}