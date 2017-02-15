package it.feio.android.analitica;

import android.content.Context;

import it.feio.android.analitica.exceptions.AnalyticsInstantiationException;


public class AnalyticsHelperFactory extends AnalyticsHelperAbstractFactory {

	@Override
	public AnalyticsHelper getAnalyticsHelper(Context context, ServiceIdentifier serviceIdentifier) throws AnalyticsInstantiationException {
		return new GoogleAnalyticsHelper(context, (GoogleAnalyticsServiceIdentifier) serviceIdentifier);
	}
}
