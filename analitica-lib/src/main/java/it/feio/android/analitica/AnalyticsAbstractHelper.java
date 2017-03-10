package it.feio.android.analitica;


import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


abstract class AnalyticsAbstractHelper implements AnalyticsHelper {

    private ServiceIdentifier serviceIdentifier;
    boolean enabled;

    AnalyticsAbstractHelper() {
    }


    AnalyticsAbstractHelper(Context context, boolean enable, ServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
        this.serviceIdentifier = serviceIdentifier;
    }

}
