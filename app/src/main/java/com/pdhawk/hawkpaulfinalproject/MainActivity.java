package com.pdhawk.hawkpaulfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.pdhawk.hawkpaulfinalproject.BookActivity;
import com.pdhawk.hawkpaulfinalproject.R;
import com.pdhawk.hawkpaulfinalproject.RecordActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnBook = (Button)findViewById(R.id.btn_book);
        final Button btnRec  = (Button)findViewById(R.id.btn_record);

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case (R.id.btn_book) :
                        Intent readnItent = new Intent(MainActivity.this, BookActivity.class);
                        startActivity(readnItent);
                        break;
                    case (R.id.btn_record):
                        Intent recIntent = new Intent(MainActivity.this, RecordActivity.class);
                        startActivity(recIntent);

                        break;
                    default:
                        break;

                }
            }
        };
        btnBook.setOnClickListener(btnListener);
        btnRec.setOnClickListener(btnListener);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
