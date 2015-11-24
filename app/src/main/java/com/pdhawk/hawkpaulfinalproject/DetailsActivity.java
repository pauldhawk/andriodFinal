package com.pdhawk.hawkpaulfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends Activity {
    private static final String TAG = "meBugs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d(TAG, "onCreate");
    }
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");

        super.onStart();
        // The activity is about to become visible.
        Intent intent = getIntent();
        if (intent != null) {
            CharSequence n = (intent.getStringExtra("BookName")==null) ? "name missing" : intent.getStringExtra("BookName");
            CharSequence d = (intent.getStringExtra("BookDescription") == null) ? "Desc Missing" : intent.getStringExtra("BookDescription");
            TextView name = (TextView) findViewById(R.id.txtBookTitle);
            TextView description = (TextView) findViewById(R.id.txtDesc);
            ImageView icon = (ImageView) findViewById(R.id.icon);
            name.setText(n);

            description.setText(d);
            icon.setImageResource(intent.getIntExtra("BookIcon", -1));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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