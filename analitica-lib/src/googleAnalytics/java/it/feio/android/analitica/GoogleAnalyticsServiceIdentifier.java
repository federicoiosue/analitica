package it.feio.android.analitica;

import java.util.regex.Pattern;

import it.feio.android.analitica.exceptions.InvalidIdentifierException;

public class GoogleAnalyticsServiceIdentifier extends ServiceIdentifier {

    /**
     * @param identifiers Must be Google Analytics tracking ID
     * @throws InvalidIdentifierException
     */
    public GoogleAnalyticsServiceIdentifier(String... identifiers) throws InvalidIdentifierException {
        super(identifiers);
    }

    @Override
    void validate(String... identifiers) throws InvalidIdentifierException {
        boolean success = identifiers.length == 1
                && Pattern.compile("^(UA|YT|MO)-\\d+-\\d+$").matcher(identifiers[0]).matches();
        if (!success) {
            throw new InvalidIdentifierException("Google Analytics identifier MUST be the tracking ID");
        }
    }

    public String getTrackingId() {
        return identifiers[0];
    }

}
