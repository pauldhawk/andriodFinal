package com.pdhawk.hawkpaulfinalproject;


import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.IOException;

public class RecordActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        final Button btnBack = (Button)findViewById(R.id.btn_back);
        final Button btnForward = (Button)findViewById(R.id.btn_forward);
        final ImageView page = (ImageView)findViewById(R.id.icon);
        final MediaRecorder recorder = new MediaRecorder();

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button b = (Button) v;
                switch (v.getId()) {
                    case (R.id.btn_back):
                        MediaPlayer.create(getBaseContext(), R.raw.a).start();
                        page.setImageResource(R.drawable.page01);
                        break;
                    case (R.id.btn_forward):
                        MediaPlayer.create(getBaseContext(), R.raw.a).start();
                        page.setImageResource(R.drawable.page02);
                        break;
                    case (R.id.btn_record):
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        recorder.setOutputFile("recordings/mp3.mp3");
                        try {
                            recorder.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        recorder.start();   // Recording is now started
                        break;
                    case (R.id.btn_stop):
                        recorder.stop();
                        recorder.reset();
                        recorder.release();
                        break;
                    case (R.id.btn_play):
                        //  URI uri = new URI();
                        //uri.
//                        MediaPlayer.create()
                    default:
                        break;
                }
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_record, menu);
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

//    Create a new instance of android.media.MediaRecorder. Set the audio source using MediaRecorder.setAudioSource(). You will probably want to use MediaRecorder.AudioSource.MIC.
//    Set output file format using MediaRecorder.setOutputFormat().
//    Set output file name using MediaRecorder.setOutputFile().
//    Set the audio encoder using MediaRecorder.setAudioEncoder().
//    Call MediaRecorder.prepare() on the MediaRecorder instance.
//    To start audio capture, call MediaRecorder.start().
//    To stop audio capture, call MediaRecorder.stop().
//    When you are done with the MediaRecorder instance, call MediaRecorder.release() on it.
//    Calling MediaRecorder.release() is always recommended to free the resource immediately.

//recorder.AudioSource(MediaRecorder.AudioSource.MIC);
//  //  recorder.AudioSource(MediaRecorder.AudioSource.MIC);
//    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//    recorder.setOutputFile(PATH_NAME);
//    recorder.prepare();
//    recorder.start();   // Recording is now started
//            recorder.stop();
//    recorder.reset();   // You can reuse the object by going back to setAudioSource() step
//    recorder.release(); // Now the object cannot be reused

}


