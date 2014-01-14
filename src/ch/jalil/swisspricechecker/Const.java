
package ch.jalil.swisspricechecker;


/** Constants for the app. */
public final class Const {
	
	/** Intent keys. */
    public final class IntentKeys {

        public static final String INPUT = "input";
        
        private IntentKeys() {
        } // Non-instantiable.
    }

    /** Preference keys. */
    public final class PrefKeys {
    	
    	/* example:
        public static final String EMAIL = "email";
       */
        private PrefKeys() {
        } // Non-instantiable.
    }

    /** Various other strings, e.g. keys for Intent extras. */
    public final class Strings {
        public static final String INPUT_ERROR = "Bad formated input!";
        public static final String BROWSE_MEDIAMARKT = "Browse MediaMarkt website";
        public static final String BROWSE_FNAC = "Browse Fnac.com website";

        private Strings() {
        } // Non-instantiable.
    }

    /** Various integer values. */
    public final class Integers {
    	public static final int QUERY_MAX_LENGTH = 100;

        private Integers() {
        } // Non-instantiable.
    }

    private Const() {
    } // Non-instantiable.

    

    public static enum PROVIDERS_TYPE {
    	MEDIAMARKT,
    	FNAC;
    }
}
