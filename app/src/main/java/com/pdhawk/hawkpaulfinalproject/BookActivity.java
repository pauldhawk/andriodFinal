package com.pdhawk.hawkpaulfinalproject;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static java.security.AccessController.getContext;


public class BookActivity extends ListActivity {
    private static final String TAG = "meBugs";
    Data d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_book);
        d = new Data();
        setListAdapter(new BookAdapter());
        //Activity a = BookActivity.this.getAssets();

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(TAG, "onListItemClick position=" + position + " id=" + id + " " + d.books.get(position).getName());
        Intent intent = new Intent(BookActivity.this, ReadingActivity.class);
        String name =  d.books.get(position).getName();
        String desc =  d.books.get(position).getLongDescription();
        intent.putExtra("id", d.books.get(position).bookId);
        startActivity(intent);
    }

    class BookAdapter extends BaseAdapter {

        private LayoutInflater inflater;

        @Override
        public int getCount() {

            return d.books.size();
        }

        @Override
        public Object getItem(int i) {
            return d.books.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (convertView == null) {
                if (inflater == null)
                    inflater = (LayoutInflater) BookActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.book_list_item, parent, false);
            }

            ImageView icon = (ImageView) row.findViewById(R.id.icon);
            TextView title = (TextView) row.findViewById(R.id.txtBookTitle);
            TextView description = (TextView) row.findViewById(R.id.txtDesc);
            Book book = d.books.get(position);
            // set the vals

            title.setText(book.getName());
            description.setText(book.getShortDescription());
            icon.setImageResource(book.icon);
            return row;
        }
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
