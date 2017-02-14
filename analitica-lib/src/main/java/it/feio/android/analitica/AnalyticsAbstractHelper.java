package it.feio.android.analitica;


import android.content.Context;
import android.support.annotation.Nullable;


public abstract class AnalyticsAbstractHelper implements AnalyticsHelper {

	private AnalyticsAbstractHelper() {
		// Not available to instance class
	}


	AnalyticsAbstractHelper(Context context, String analyticsUrl, @Nullable String trackingId) {
	}
}
