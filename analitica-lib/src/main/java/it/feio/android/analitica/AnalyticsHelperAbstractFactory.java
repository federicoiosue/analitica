package it.feio.android.analitica;


import android.content.Context;
import android.support.annotation.Nullable;


public abstract class AnalyticsHelperAbstractFactory {

	public abstract AnalyticsHelper getAnalyticsHelper(Context context, String analyticsUrl, @Nullable String
			trackingId);
}
