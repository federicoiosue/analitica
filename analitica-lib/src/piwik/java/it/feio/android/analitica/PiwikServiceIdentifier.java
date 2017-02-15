package it.feio.android.analitica;

import android.text.TextUtils;

import it.feio.android.analitica.exceptions.InvalidIdentifierException;

public class PiwikServiceIdentifier extends ServiceIdentifier {

    /**
     * @param identifiers Must be both Piwik service URL and applicationId
     * @throws InvalidIdentifierException
     */
    public PiwikServiceIdentifier(String... identifiers) throws InvalidIdentifierException {
        super(identifiers);
    }

    @Override
    void validate(String... identifiers) throws InvalidIdentifierException {
        boolean success = identifiers.length == 2
                && android.util.Patterns.WEB_URL.matcher(identifiers[0]).matches()
                && TextUtils.isDigitsOnly(identifiers[1]);
        if (!success) {
            throw new InvalidIdentifierException("Piwik identifiers MUST be both service URL AND applicationId");
        }
    }

    public String getUrl() {
        return identifiers[0];
    }

    public int getApplicationId() {
        return Integer.valueOf(identifiers[1]);
    }
}
