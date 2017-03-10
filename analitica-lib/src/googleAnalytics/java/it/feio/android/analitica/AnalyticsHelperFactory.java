package it.feio.android.analitica;

import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;
import it.feio.android.analitica.exceptions.InvalidIdentifierException;


public class AnalyticsHelperFactory extends AnalyticsHelperAbstractFactory {

    @Override
    public AnalyticsHelper getAnalyticsHelper(Context context, boolean enable, String... identifiers) throws AnalyticsInstantiationException, InvalidIdentifierException {
        GoogleAnalyticsServiceIdentifier serviceIdentifier = new GoogleAnalyticsServiceIdentifier(identifiers);
        return new GoogleAnalyticsHelper(context, enable, serviceIdentifier);
    }
}
