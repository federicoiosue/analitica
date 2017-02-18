package it.feio.android.analitica.exceptions;

public class InvalidIdentifierException extends Exception {

    private static final long serialVersionUID = -4970082316982788722L;

    public InvalidIdentifierException(String message) {
        super(message);
    }

    public InvalidIdentifierException(String message, Exception e) {
        super(message, e);
    }
}
