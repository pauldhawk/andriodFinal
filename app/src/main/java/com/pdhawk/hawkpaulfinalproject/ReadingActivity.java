package com.pdhawk.hawkpaulfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ReadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        final Button btnBack = (Button)findViewById(R.id.btn_back);
        final Button btnForward = (Button)findViewById(R.id.btn_forward);
        final ImageView page = (ImageView)findViewById(R.id.icon);
        // todo add singleton so don't have to load twice
        Data d = new Data();
        Intent intent = getIntent();
        int x = intent.getIntExtra("id", 0);
        final  Book book = d.books.get(x);
        page.setImageResource(book.pages.get(0).picture);
        MediaPlayer.create(getBaseContext(), book.pages.get(0).sound).start();



        // final MediaPlayer mp = new MediaPlayer.create(this, R.raw.a);


        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Page p = null;
                Button b = (Button) v;
                switch (v.getId()) {
                    case (R.id.btn_back):

                        p = book.getPrevPage();
                        break;
                    case (R.id.btn_forward):

                        p =  book.getNextPage();
                        break;
                    default:
                        break;
                }
                page.setImageResource(p.picture);
                MediaPlayer.create(getBaseContext(), p.sound).start();
            }
        };
        btnBack.setOnClickListener(btnListener);
        btnForward.setOnClickListener(btnListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
