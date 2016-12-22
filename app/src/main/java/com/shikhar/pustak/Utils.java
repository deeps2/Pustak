package com.shikhar.pustak;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
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

    private static URL createURL(String textEntered) {

        URL url = null;
        String modifiedURL = textEntered.trim().replaceAll("\\s+","+");
        try {
            url = new URL(modifiedURL);
        }
        catch (MalformedURLException e){
            Log.e(LOG_TAG, "Error during creating URL ", e);
        }
        return url; //if fail then null will be returned as default is null
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(10000); // milliseconds
            urlConnection.setConnectTimeout(15000); // milliseconds
            urlConnection.setRequestMethod("GET");

            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);//can throw IOException. will catch the exception in catch{...} here if it occurs
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {// exception will be handled at the calling place(i.e. where call is made(); see above for call)
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    

}
