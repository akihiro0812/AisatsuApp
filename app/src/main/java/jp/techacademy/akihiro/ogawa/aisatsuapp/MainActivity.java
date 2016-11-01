package jp.techacademy.akihiro.ogawa.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    int mHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button1) {
            if (mHour >= 2 && mHour <= 9) {
                mTextView.setText("おはよう");
            }
            else if (mHour >= 10 && mHour <= 17 ) {
                mTextView.setText("こんにちわ");
            }
            else
                mTextView.setText("こんばんわ");
        }
        else if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {         //hourOfDay,minuteは画面で設定した時間、分
                Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                mHour = hourOfDay;
            }
        },
                13, //初期値(時間)
                0,  //初期値(分)
                true);
        timePickerDialog.show();
    }
}
