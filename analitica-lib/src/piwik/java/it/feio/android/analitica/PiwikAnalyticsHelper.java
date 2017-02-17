package it.feio.android.analitica;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;

import org.piwik.sdk.Piwik;
import org.piwik.sdk.TrackHelper;
import org.piwik.sdk.Tracker;

import java.net.MalformedURLException;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


public class PiwikAnalyticsHelper extends AnalyticsAbstractHelper {

    private static Tracker tracker;


    PiwikAnalyticsHelper(Context context, boolean enable, PiwikServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
        super(context, enable, serviceIdentifier);
        enabled = enable;
        if (enabled && tracker == null) {
            try {
                tracker = Piwik.getInstance(context).newTracker(serviceIdentifier.getUrl(), serviceIdentifier.getApplicationId());
                tracker.setUserId(Settings.Secure.getString(context.getContentResolver(), Settings.Secure
                        .ANDROID_ID));
                TrackHelper.track().download().with(tracker);
            } catch (MalformedURLException e) {
                throw new AnalyticsInstantiationException("Invalid Piwik URL", e);
            }
        }
    }


    @Override
    public Tracker getTracker() {
        return tracker;
    }


    @Override
    public void trackScreenView(String screenName) {
        if (enabled) {
            TrackHelper.track().screen(screenName).with(tracker);
        }
    }


    @Override
    public void trackEvent(CATEGORIES category, String action) {
        if (enabled) {
            TrackHelper.track().event(category.name(), action).with(tracker);
        }
    }


    @Override
    public void trackActionFromResourceId(Activity activity, int resourceId) {
        if (enabled) {
            TrackHelper.track().event(CATEGORIES.ACTION.name(), activity.getResources().getResourceEntryName
                    (resourceId)).with(tracker);
        }
    }
}
