package models;

public class Player {

	private String namePlayer;
	private String characterPlayer;
	private int positionInX;
	private int positionInY;
	private static final int MOVE_UNITS = 50;

	public Player() {
	}

	public Player(String namePlayer, String characterPlayer, int positionX, int positionY) {
		this.namePlayer = namePlayer;
		this.characterPlayer = characterPlayer;
		this.positionInX = positionX;
		this.positionInY = positionY;
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

	public int getPositionInX() {
		return positionInX;
	}

	public int getPositionInY() {
		return positionInY;
	}

	public void movePlayer(DirectionPlayer directionPlayer, int posXFrame, int posYFrame){
		switch (directionPlayer) {
		case LEFT:
			if (positionInX- MOVE_UNITS > 0) {
				positionInX -= MOVE_UNITS;
			}
			break;
		case RIGHT:
			if (positionInX+ MOVE_UNITS+6 < posXFrame) {
				positionInX += MOVE_UNITS;
			}
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "NamePlayer: " + namePlayer + ", CharacterPlayer:" + characterPlayer + ", PositionInX:"
				+ positionInX + ", PositionInY:" + positionInY;
	}
}