package hoangphan.ea.customfontviews.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by Hoang Phan on 8/11/15.
 */
public class FontManager {
    private static Hashtable<String, Typeface> mFontCache = new Hashtable<>();

    public static void setFontCache(Hashtable<String, Typeface> fontCache) {
        mFontCache = fontCache;
    }

    public static Typeface getFont(String name, Context context) {
        Typeface typeface = mFontCache.get(name);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            mFontCache.put(name, typeface);
        }
        return typeface;
    }

}
