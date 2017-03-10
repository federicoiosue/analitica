package it.feio.android.analitica.exceptions;

public class InvalidTrackerOperationException extends Exception {

    private static final long serialVersionUID = 8989679130996746514L;

    public InvalidTrackerOperationException(String message) {
        super(message);
    }

    public InvalidTrackerOperationException(String message, Exception e) {
        super(message, e);
    }
}
