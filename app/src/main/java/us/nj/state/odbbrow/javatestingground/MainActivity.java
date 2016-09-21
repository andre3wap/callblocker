package us.nj.state.odbbrow.javatestingground;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onReceive(Context context, Intent intent) {

        String state=intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if(state==null){
            //outgoing call
            String number=intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.i("tag","Outgoing number : "+number);
        }
        else if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            //incoming call
            String number=intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.i("tag","Incoming number : "+number);


            AudioManager am;
            am= (AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE);

            //For Silent mode
            am.setRingerMode(AudioManager.RINGER_MODE_SILENT);


        }
    }
}
