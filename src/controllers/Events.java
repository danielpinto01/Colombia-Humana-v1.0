package controllers;

import javax.swing.ImageIcon;

public enum Events {

	LOG_ING("LOG_ING", "Ingresar" , ""),
	SIGN_IN("SIGN_IN", "Registrarse" , ""),
	
	SHOW_DIALOG_INIT_PLAYER("SHOW_DIALOG_INIT_PLAYER", "Mostrar dialogo de inicio", ""), 
	EXIT_APP("EXIT_APP", "Salir de la App", ""), 
	NEXT_PAGE("NEXT_PAGE", "Siguiente panel", ""), 
	INIT_GAME("INIT_GAME", "Inicio del juego", ""),
	ADD_PLAYER("ADD_PLAYER", "Agregar jugador", "");
	
	private String event;
	private String title;
	private String pathImg;
	
	private Events(String event, String title, String pathImg) {
		this.event = event;
		this.title = title;
		this.pathImg = pathImg;
	}
	
	public String getCommand() {
		return event;
	}
	
	public String getTitle() {
		return title;
	}
	
	public ImageIcon getImg() {
		return new ImageIcon(getClass().getResource(pathImg));
	}
}