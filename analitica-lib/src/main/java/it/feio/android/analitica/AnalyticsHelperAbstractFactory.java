package it.feio.android.analitica;


import android.content.Context;
import android.support.annotation.Nullable;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


abstract class AnalyticsHelperAbstractFactory {

    abstract AnalyticsHelper getAnalyticsHelper(Context context, String analyticsUrl, @Nullable String
            trackingId) throws AnalyticsInstantiationException;
}
