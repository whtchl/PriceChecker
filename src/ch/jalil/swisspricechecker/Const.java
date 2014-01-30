
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
    	public static final String HISTORY = "history";
    	// as defined in pref_general.xml
        public static final String LANGUAGE = "preferred_language";
       
        private PrefKeys() {
        } // Non-instantiable.
    }

    /** Various other strings, e.g. keys for Intent extras. */
    public final class Strings {
        public static final String INPUT_ERROR = "Bad formated input!";
        public static final String BROWSE_MEDIAMARKT = "Browse MediaMarkt website";
        public static final String BROWSE_FNAC = "Browse Fnac.com website";
        public static final String BROWSE_AMAZON = "Browse Amazon.fr website";
        public static final String BROWSE_MELECTRONICS = "Browse M-Electronics website";
        public static final String BROWSE_TOPPREISE = "Browse TopPreise website";

        private Strings() {
        } // Non-instantiable.
    }

    /** Various integer values. */
    public final class Integers {
    	public static final int QUERY_MAX_LENGTH = 100;
    	public static final int MAX_HISTORY_SIZE = 5;

        private Integers() {
        } // Non-instantiable.
    }

    private Const() {
    } // Non-instantiable.

    

    public static enum PROVIDERS_TYPE {
    	MEDIAMARKT,
    	FNAC,
    	AMAZON,
    	MELECTRONICS,
    	TOPPREISE;
    }
}
