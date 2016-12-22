package com.shikhar.pustak;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mFindButton;
    TextView mNotFound;
    EditText mTextEntered;

    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotFound = (TextView)findViewById(R.id.no_book_or_internet_found);
        mFindButton = (Button)findViewById(R.id.seach_button);

        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNetworkConnected()){
                    BookAsyncTask task = new BookAsyncTask();
                    task.execute();
                }else{
                    mNotFound.setVisibility(View.VISIBLE);
                    mNotFound.setText("Not connected to Internet");
                }
            }
        });

        ListView bookListView = (ListView)findViewById(R.id.list_items);
        adapter = new BookAdapter(this);
        bookListView.setAdapter(adapter);
    }

    public boolean isNetworkConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork.isConnectedOrConnecting();
    }

    public String getText() {
        return  mTextEntered.getText().toString();
    }

    private class BookAsyncTask extends AsyncTask<Void, Void, List<Book>>{
        @Override
        protected List<Book> doInBackground(Void... voids) {

            List<Book> result = Utils.fetchBookData(getText());
            return result;

        }

        @Override
        protected void onPostExecute(List<Book> books) {

            if(books == null){
                mNotFound.setVisibility(View.VISIBLE);
                mNotFound.setText("Sorry. Couldn't find any book :-(");
            }
            else {
                mNotFound.setVisibility(View.INVISIBLE);
            }
            adapter.clear();
            adapter.addAll(books);
        }
    }
}

