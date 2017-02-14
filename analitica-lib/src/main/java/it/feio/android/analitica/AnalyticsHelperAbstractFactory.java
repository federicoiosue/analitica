package it.feio.android.analitica;


import android.content.Context;
import android.support.annotation.Nullable;


abstract class AnalyticsHelperAbstractFactory {

	abstract AnalyticsHelper getAnalyticsHelper(Context context, String analyticsUrl, @Nullable String
			trackingId);
}
