package it.feio.android.analitica;

import it.feio.android.analitica.exceptions.InvalidIdentifierException;

abstract class ServiceIdentifier {

    protected String[] identifiers;

    private ServiceIdentifier() {
        throw new UnsupportedOperationException("Empty constructor not available");
    }

    public ServiceIdentifier(String... identifiers) throws InvalidIdentifierException {
        validate(identifiers);
        this.identifiers = identifiers;
    }

    abstract void validate(String... identifiers) throws InvalidIdentifierException;
}
