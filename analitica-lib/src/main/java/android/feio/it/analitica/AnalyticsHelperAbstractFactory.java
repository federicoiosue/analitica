package android.feio.it.analitica;


import android.app.Application;
import android.support.annotation.Nullable;


public abstract class AnalyticsHelperAbstractFactory {

	public abstract AnalyticsHelper getAnalyticsHelper(Application application, String analyticsUrl, @Nullable String
			trackingId);
}
