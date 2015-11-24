package com.pdhawk.hawkpaulfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class ReadingActivity extends Activity {
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    static final int NEG_MIN_DISTANCE = 150;
    Data d = new Data();
    int x;
    final  Book book = d.books.get(x);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        final Button btnBack = (Button)findViewById(R.id.btn_back);
        final Button btnForward = (Button)findViewById(R.id.btn_forward);
        final ImageView page = (ImageView)findViewById(R.id.icon);
        // todo add singleton so don't have to load twice
        Intent intent = getIntent();
        x = intent.getIntExtra("id", 0);
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
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                final ImageView page = (ImageView)findViewById(R.id.icon);
                Page p = null;
               if  (deltaX > MIN_DISTANCE && deltaX > 0) {
                   Toast.makeText(this, "left2right swipe", Toast.LENGTH_SHORT).show();
                   p = book.getPrevPage();
                   page.setImageResource(p.picture);
                   MediaPlayer.create(getBaseContext(), p.sound).start();


               } else if (deltaX < NEG_MIN_DISTANCE && deltaX < 0) {
                   Toast.makeText(this, "right to left swipe", Toast.LENGTH_SHORT).show();
                   p = book.getNextPage();
                   page.setImageResource(p.picture);
                   MediaPlayer.create(getBaseContext(), p.sound).start();

               }
                else {}
            }

        return super.onTouchEvent(event);
    }
}
