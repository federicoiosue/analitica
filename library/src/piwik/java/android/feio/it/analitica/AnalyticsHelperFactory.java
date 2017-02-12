package android.feio.it.analitica;

import android.app.Application;


public class AnalyticsHelperFactory extends AnalyticsHelperAbstractFactory {

	@Override
	public AnalyticsHelper getAnalyticsHelper(Application application, String analyticsUrl) {
		return new PiwikAnalyticsHelper(application, analyticsUrl);
	}
}
