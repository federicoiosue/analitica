package android.feio.it.analitica;


import android.app.Application;


public abstract class AnalyticsHelperAbstractFactory {

	public abstract AnalyticsHelper getAnalyticsHelper(Application application, String analyticsUrl);
}
