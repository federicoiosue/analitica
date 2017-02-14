package it.feio.android.analitica;

import android.content.Context;
import android.support.annotation.Nullable;


public class AnalyticsHelperFactory extends AnalyticsHelperAbstractFactory {

	@Override
	public AnalyticsHelper getAnalyticsHelper(Context context, String analyticsUrl, @Nullable String
			trackingId) {
		return new PiwikAnalyticsHelper(context, analyticsUrl);
	}
}
