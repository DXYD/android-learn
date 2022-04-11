package com.example.myapplication.other;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TimePicker;

import com.example.myapplication.R;

public class AlarmActivity extends BaseActivity {

    public static final String INTENT_ALARM = "intent_alarm_learn";

    private TimePicker timePicker;

    private Switch aSwitch;

    private static final String TAG = "AlarmActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        init();
/*

        if (ConfigData.getIsAlarm()) {
            aSwitch.setChecked(true);
            timePicker.setEnabled(true);
            int hour = Integer.parseInt(ConfigData.getAlarmTime().split("-")[0]);
            int minute = Integer.parseInt(ConfigData.getAlarmTime().split("-")[1]);
            timePicker.setHour(hour);
            timePicker.setMinute(minute);
        } else {
            aSwitch.setChecked(false);
            timePicker.setEnabled(false);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    timePicker.setEnabled(true);
                    ConfigData.setIsAlarm(true);
                } else {
                    timePicker.setEnabled(false);
//                    stopAlarm();
                    ConfigData.setIsAlarm(false);
                }
            }
        });


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (aSwitch.isChecked()) {
//                    startAlarm(hourOfDay, minute, false, true);
                }
            }
        });
*/

    }

    private void init() {
        aSwitch = findViewById(R.id.switch_alarm_learn);
        timePicker = findViewById(R.id.timePicker_alarm);
    }


}
