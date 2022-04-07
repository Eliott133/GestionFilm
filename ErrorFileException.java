package sae;

public class ErrorFileException extends Exception{
	String msg;
	public void ErrorFileException(){
		msg = "Le fichier n'existe pas";
	}
}
