package it.feio.android.analitica;


import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


abstract class AnalyticsAbstractHelper implements AnalyticsHelper {

    private AnalyticsAbstractHelper() {
        throw new UnsupportedOperationException("Empty constructor not available");
    }


    AnalyticsAbstractHelper(Context context, ServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
    }
}
