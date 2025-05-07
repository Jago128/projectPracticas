package exceptions;

public class EmailFormatException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmailFormatException() {
		super("El formato del email introducido es incorrecto.");
	}
}
