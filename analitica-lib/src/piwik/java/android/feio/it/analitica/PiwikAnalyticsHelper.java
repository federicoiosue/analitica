package android.feio.it.analitica;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import org.piwik.sdk.Piwik;
import org.piwik.sdk.TrackHelper;
import org.piwik.sdk.Tracker;

import java.net.MalformedURLException;


public class PiwikAnalyticsHelper extends AnalyticsAbstractHelper {

	private static final String TAG = PiwikAnalyticsHelper.class.getSimpleName();
	private static Tracker tracker;
	private static boolean enabled;


	PiwikAnalyticsHelper(Application application, String analyticsUrl) {
		super(application, analyticsUrl, null);
		enabled = !TextUtils.isEmpty(analyticsUrl);
		if (tracker == null && enabled) {
			try {
				tracker = Piwik.getInstance(application).newTracker(analyticsUrl, 1);
				tracker.setUserId(Settings.Secure.getString(application.getContentResolver(), Settings.Secure
						.ANDROID_ID));
				TrackHelper.track().download().with(tracker);
			} catch (MalformedURLException e) {
				Log.e(TAG, "Malformed url to get analytics tracker", e);
			}
		}
	}


	public static Tracker getTracker() {
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
			try {
				TrackHelper.track().event(CATEGORIES.ACTION.name(), activity.getResources().getResourceEntryName
						(resourceId)).with(tracker);
			} catch (Resources.NotFoundException e) {
				Log.w(TAG, "No resource name found for request id");
			}
		}
	}
}
