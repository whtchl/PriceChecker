
package ch.jalil.swisspricechecker;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.util.Log;
import android.widget.Toast;


/**
 * Small utilities needed here and there.
 * 
 * @author lum
 */
public final class Utils {

    private static final String TAG = "ch.jalil.swisspricechecker.Utils";
    
    /*
     * An object make no sense
     */
    private Utils() {
    }
    
    
    // Usefull things go there
    public static String handleInput(String input) throws UnsupportedEncodingException {
	    String clearUI = sanitizeInput(input);
	    return Utils.urlEncode(clearUI);
	}
    
	private static String sanitizeInput(String s) {
		//TODO do something here
		return s;
	}
    
    public static String urlEncode (String s) throws UnsupportedEncodingException {
    	return URLEncoder.encode(s, "UTF-8");
    }
}
