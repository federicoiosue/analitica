package it.feio.android.analitica;


import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;
import it.feio.android.analitica.exceptions.InvalidIdentifierException;


abstract class AnalyticsHelperAbstractFactory {

    public abstract AnalyticsHelper getAnalyticsHelper(Context context, boolean enable, String... identifiers) throws AnalyticsInstantiationException, InvalidIdentifierException;
}
