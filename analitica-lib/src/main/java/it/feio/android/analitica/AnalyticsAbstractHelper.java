package it.feio.android.analitica;


import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


abstract class AnalyticsAbstractHelper implements AnalyticsHelper {

    private ServiceIdentifier serviceIdentifier;
    boolean enabled;

    private AnalyticsAbstractHelper() {
        throw new UnsupportedOperationException("Empty constructor not available");
    }


    AnalyticsAbstractHelper(Context context, boolean enable, ServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
        this.serviceIdentifier = serviceIdentifier;
    }

}
