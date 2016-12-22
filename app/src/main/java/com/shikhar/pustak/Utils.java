package com.shikhar.pustak;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Utils {

    public static String LOG_TAG = Utils.class.getSimpleName();

    public static List<Book> fetchBookData(String textEntered{

        URL url = createURL(textEntered);

        String jsonRespnse = null;

        try{
            jsonRespnse = makeHttpRequest(url);
        }
        catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        List<Book> books = extractFromJson(jsonRespnse);
        return books;
    }

    private static URL createUrl(String textEntered) {

        URL url = null;
        String modifiedURL = textEntered.trim().replaceAll("\\s+","+");
        try {
            url = new URL(modifiedURL);
        }
        catch (MalformedURLException e){
            Log.e(LOG_TAG, "Error during creating URL ", e);
        }
        return url;
    }

}
