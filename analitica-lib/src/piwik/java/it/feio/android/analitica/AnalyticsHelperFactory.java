package it.feio.android.analitica;

import android.content.Context;
import android.support.annotation.Nullable;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


public class AnalyticsHelperFactory extends AnalyticsHelperAbstractFactory {

	@Override
	public AnalyticsHelper getAnalyticsHelper(Context context, String analyticsUrl, @Nullable String
			trackingId) throws AnalyticsInstantiationException {
		return new PiwikAnalyticsHelper(context, analyticsUrl);
	}
}
