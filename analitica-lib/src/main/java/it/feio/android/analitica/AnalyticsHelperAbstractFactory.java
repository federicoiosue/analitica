package it.feio.android.analitica;


import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


abstract class AnalyticsHelperAbstractFactory {

    abstract AnalyticsHelper getAnalyticsHelper(Context context, ServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException;
}
