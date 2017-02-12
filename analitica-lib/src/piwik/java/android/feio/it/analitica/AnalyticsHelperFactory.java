package android.feio.it.analitica;

import android.app.Application;
import android.support.annotation.Nullable;


public class AnalyticsHelperFactory extends AnalyticsHelperAbstractFactory {

	@Override
	public AnalyticsHelper getAnalyticsHelper(Application application, String analyticsUrl, @Nullable String
			trackingId) {
		return new PiwikAnalyticsHelper(application, analyticsUrl);
	}
}
