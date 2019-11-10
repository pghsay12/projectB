package guestbook.exception;

public class GuestBookException extends RuntimeException{
	
	private static final long serialVersionUTD = 1L;
	
	public GuestBookException() {
		super("GuestBookException Occurs");
	}
	
	public GuestBookException(String msg) {
		super(msg);
	}

}
