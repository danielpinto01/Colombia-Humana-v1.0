package models;

public class Player {
	
	private String namePlayer;
	private String characterPlayer;
	
	public Player(String namePlayer, String characterPlayer) {
		this.namePlayer = namePlayer;
		this.characterPlayer = characterPlayer;
	}

	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public String getCharacterPlayer() {
		return characterPlayer;
	}

	public void setCharacterPlayer(String characterPlayer) {
		this.characterPlayer = characterPlayer;
	}

	@Override
	public String toString() {
		return "Player [namePlayer=" + namePlayer + ", characterPlayer=" + characterPlayer + "]";
	}
}