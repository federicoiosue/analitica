package it.feio.android.analitica;

import android.app.Activity;

import it.feio.android.analitica.exceptions.InvalidTrackerOperationException;

public interface AnalyticsHelper {

    enum CATEGORIES {ACTION, SETTING, UPDATE}

    <T> T getTracker() throws InvalidTrackerOperationException;

    void trackScreenView(String screenName);

    void trackEvent(CATEGORIES category, String action);

    void trackActionFromResourceId(Activity activity, int resourceId);

}
