package it.feio.android.analitica;

import android.app.Activity;


public interface AnalyticsHelper {

    enum CATEGORIES {ACTION, SETTING, UPDATE}

    <T> T getTracker();

    void trackScreenView(String screenName);

    void trackEvent(CATEGORIES category, String action);

    void trackActionFromResourceId(Activity activity, int resourceId);

}
