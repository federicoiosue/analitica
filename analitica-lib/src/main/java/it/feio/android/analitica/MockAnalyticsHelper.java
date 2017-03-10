package it.feio.android.analitica;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;
import it.feio.android.analitica.exceptions.InvalidTrackerOperationException;


public class MockAnalyticsHelper extends AnalyticsAbstractHelper {

    public MockAnalyticsHelper() {
        Log.i(getClass().getSimpleName(), "MockAnalyticsHelper instance methods are empty. No analytic data will be collected.");
    }

    private MockAnalyticsHelper(Context context, boolean enable, ServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
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
