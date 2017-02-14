package it.feio.android.analitica;

import android.app.Activity;


interface AnalyticsHelper {

	enum CATEGORIES {ACTION, SETTING, UPDATE}

	void trackScreenView(String screenName);


	void trackEvent(CATEGORIES category, String action);


	void trackActionFromResourceId(Activity activity, int resourceId);

}
