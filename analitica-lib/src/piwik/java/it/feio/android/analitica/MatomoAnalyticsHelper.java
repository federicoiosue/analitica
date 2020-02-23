package it.feio.android.analitica;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;
import org.matomo.sdk.Matomo;
import org.matomo.sdk.Tracker;
import org.matomo.sdk.TrackerBuilder;
import org.matomo.sdk.extra.TrackHelper;


public class MatomoAnalyticsHelper extends AnalyticsAbstractHelper {

  private static Tracker tracker;


  MatomoAnalyticsHelper (Context context, boolean enable, MatomoServiceIdentifier serviceIdentifier)
      throws AnalyticsInstantiationException {
    super(context, enable, serviceIdentifier);
    enabled = enable;
    if (enabled && tracker == null) {
      tracker = TrackerBuilder.createDefault(
          serviceIdentifier.getUrl(),
          serviceIdentifier.getApplicationId()).build(Matomo.getInstance(context)
      );

      tracker.setUserId(Settings.Secure.getString(
          context.getContentResolver(),
          Settings.Secure.ANDROID_ID)
      );

      TrackHelper.track().download().with(tracker);
    }
  }


  @Override
  public Tracker getTracker () {
    return tracker;
  }


  @Override
  public void trackScreenView (String screenName) {
    if (enabled) {
      TrackHelper.track().screen(screenName).with(tracker);
    }
  }


  @Override
  public void trackEvent (CATEGORIES category, String action) {
    if (enabled) {
      TrackHelper.track().event(category.name(), action).with(tracker);
    }
  }


  @Override
  public void trackActionFromResourceId (Activity activity, int resourceId) {
    if (enabled) {
      TrackHelper.track().event(CATEGORIES.ACTION.name(), activity.getResources().getResourceEntryName
          (resourceId)).with(tracker);
    }
  }
}
