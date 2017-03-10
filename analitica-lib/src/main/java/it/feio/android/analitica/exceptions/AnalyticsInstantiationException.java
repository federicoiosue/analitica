package it.feio.android.analitica.exceptions;

public class AnalyticsInstantiationException extends Exception {

    private static final long serialVersionUID = 7836788732009710800L;

    public AnalyticsInstantiationException(String message) {
        super(message);
    }

    public AnalyticsInstantiationException(String message, Exception e) {
        super(message, e);
    }
}
