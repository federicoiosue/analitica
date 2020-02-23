package it.feio.android.analitica;

import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;
import it.feio.android.analitica.exceptions.InvalidIdentifierException;


public class AnalyticsHelperFactory extends AnalyticsHelperAbstractFactory {

    @Override
    public AnalyticsHelper getAnalyticsHelper(Context context, boolean enable, String... identifiers) throws AnalyticsInstantiationException, InvalidIdentifierException {
        MatomoServiceIdentifier serviceIdentifier = new MatomoServiceIdentifier(identifiers);
        return new MatomoAnalyticsHelper(context, enable, serviceIdentifier);
    }
}
