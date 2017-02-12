package android.feio.it.analitica;


import android.app.Application;
import android.support.annotation.Nullable;


public abstract class AnalyticsAbstractHelper implements AnalyticsHelper {

	private AnalyticsAbstractHelper() {
		// Not available to instance class
	}


	AnalyticsAbstractHelper(Application application, String analyticsUrl, @Nullable String trackingId) {
	}
}
