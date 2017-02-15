package it.feio.android.analitica;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


public class GoogleAnalyticsHelper extends AnalyticsAbstractHelper {

    private static Tracker tracker;
    private static boolean enabled;


    GoogleAnalyticsHelper(Context context, GoogleAnalyticsServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
        super(context, serviceIdentifier);
        enabled = serviceIdentifier != null;
        if (enabled && tracker == null) {
            tracker = GoogleAnalytics.getInstance(context).newTracker(serviceIdentifier.getTrackingId());
        }
    }


    @Override
    public Tracker getTracker() {
        return tracker;
    }


    @Override
    public void trackScreenView(String screenName) {
        if (enabled) {
            tracker.setScreenName(screenName);
            tracker.send(new HitBuilders.ScreenViewBuilder().build());
        }
    }


    @Override
    public void trackEvent(CATEGORIES category, String action) {
        if (enabled) {
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory(category.name())
                    .setAction(action)
                    .build());
        }
    }


    @Override
    public void trackActionFromResourceId(Activity activity, int resourceId) {
        if (enabled) {
            tracker.send(new HitBuilders.EventBuilder()
                    .setCategory(CATEGORIES.ACTION.name())
                    .setAction(activity.getResources().getResourceEntryName(resourceId))
                    .build());
        }
    }
}
