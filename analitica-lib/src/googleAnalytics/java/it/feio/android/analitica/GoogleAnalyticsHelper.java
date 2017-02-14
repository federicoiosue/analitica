package it.feio.android.analitica;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class GoogleAnalyticsHelper extends AnalyticsAbstractHelper {

    private static final String TAG = GoogleAnalyticsHelper.class.getSimpleName();
    private static Tracker tracker;
    private static boolean enabled;


    /**
     * @param context
     * @param analyticsUrl
     * @param trackingId
     */
    GoogleAnalyticsHelper(Context context, String analyticsUrl, String trackingId) {
        super(context, analyticsUrl, trackingId);
        enabled = !TextUtils.isEmpty(analyticsUrl);
        if (tracker == null) {
            tracker = GoogleAnalytics.getInstance(context).newTracker(trackingId);
        }
    }


    public static Tracker getTracker() {
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
            try {
                tracker.send(new HitBuilders.EventBuilder()
                        .setCategory(CATEGORIES.ACTION.name())
                        .setAction(activity.getResources().getResourceEntryName(resourceId))
                        .build());
            } catch (Resources.NotFoundException e) {
                Log.w(TAG, "No resource name found for request id");
            }
        }
    }
}
