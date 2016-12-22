package com.shikhar.pustak;

import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Utils {

    public static final String LOG_TAG = Utils.class.getSimpleName();

    public List<Book> fetchBookData(){

        URL url = createURL();

        String jsonRespnse = null;

        try{
            jsonRespnse = makeHttpRequest(url);
        }
        catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

    }

}
