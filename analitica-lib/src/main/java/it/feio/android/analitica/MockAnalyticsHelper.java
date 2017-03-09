package it.feio.android.analitica;

import android.app.Activity;
import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;
import it.feio.android.analitica.exceptions.InvalidTrackerOperationException;


public class MockAnalyticsHelper extends AnalyticsAbstractHelper {

    MockAnalyticsHelper(Context context, boolean enable, ServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
        super(context, enable, serviceIdentifier);
    }

    @Override
    public <T> T getTracker() throws InvalidTrackerOperationException {
        throw new InvalidTrackerOperationException(getClass().getSimpleName() + " doesn't have a real tracker. Be sure to use a working AnalyticsAbstractHelper implementation!");
    }

    @Override
    public void trackScreenView(String screenName) {
        // Does nothing;
    }


    @Override
    public void trackEvent(AnalyticsHelper.CATEGORIES category, String action) {
        // Does nothing;
    }


    @Override
    public void trackActionFromResourceId(Activity activity, int resourceId) {
        // Does nothing;
    }
}
