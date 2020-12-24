package com.example.mt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView Med1;
    private Button Med1Btn;
    private TextView Med2;
    private Button Med2Btn;
    private TextView Med3;
    private Button Med3Btn;
    private TextView Med4;
    private Button Med4Btn;
    private TextView Med5;
    private Button Med5Btn;
    private TextView Med6;
    private Button Med6Btn;
    private TextView Med7;
    private Button Med7Btn;
    private Button Settings;
    private Button Save;
    private Button Cancel;
    private TextView AddBox, AddBox2, AddBox3, AddBox4, AddBox5, AddBox6, AddBox7;
    long currentTimestamp = System.currentTimeMillis()/1000;
    CompactCalendarView calendar;
    Object[][] arr = {{"Med1Name","Med1Count", "Med1Dose", "Med1Box", Med1, 0, "#ff0000"}, //2D array that contains all the SP keys, makes accessing through functions easier as just the array needs to be passed as a parameter
            {"Med2Name", "Med2Count", "Med2Dose", "Med2Box", Med2, 0, "#ffee00"},
            {"Med3Name", "Med3Count", "Med3Dose", "Med3Box", Med3, 0, "#00ff08"},
            {"Med4Name", "Med4Count", "Med4Dose", "Med4Box", Med4, 0, "#00f2ff"},
            {"Med5Name", "Med5Count", "Med5Dose", "Med5Box", Med5, 0, "#0000ff"},
            {"Med6Name", "Med6Count", "Med6Dose", "Med6Box", Med6, 0, "#ff00e1"},
            {"Med7Name", "Med7Count", "Med7Dose", "Med7Box", Med7, 0, "#000000"}};



    static int Add(Object[][] arr, TextView AddBox, int x) {  //Add function that is called every time you restock a medication
        int boxCount = (int) arr[x][5]; //boxCount keeps track of the number of boxes you want to add
        boxCount= boxCount + 1;
        AddBox.setText("+ " + boxCount);
        AddBox.setVisibility(View.VISIBLE);
        return boxCount; //returns boxCount so it can be updated
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences SP = getSharedPreferences("Meds", 0); //Shared preference that keeps all the data for every medication (Name, count, dose etc...) based on key/value pairs
        int elapsed =  (int) (currentTimestamp -  SP.getLong("Timestamp", currentTimestamp))/60/60/24;
        setContentView(R.layout.activity_main);

        Med1 = findViewById(R.id.Med1); //assigns TextViews and buttons (and binds them to click listener)
        Med1Btn = findViewById(R.id.button);
        Med1Btn.setOnClickListener(this);
        Med2 = findViewById(R.id.Med2);
        Med2Btn = findViewById(R.id.button2);
        Med2Btn.setOnClickListener(this);
        Med3 = findViewById(R.id.Med3);
        Med3Btn = findViewById(R.id.button3);
        Med3Btn.setOnClickListener(this);
        Med4 = findViewById(R.id.Med4);
        Med4Btn = findViewById(R.id.button4);
        Med4Btn.setOnClickListener(this);
        Med5 = findViewById(R.id.Med5);
        Med5Btn = findViewById(R.id.button5);
        Med5Btn.setOnClickListener(this);
        Med6 = findViewById(R.id.Med6);
        Med6Btn = findViewById(R.id.button6);
        Med6Btn.setOnClickListener(this);
        Med7 = findViewById(R.id.Med7);
        Med7Btn = findViewById(R.id.button7);
        Med7Btn.setOnClickListener(this);
        AddBox = findViewById(R.id.AddBox);
        AddBox.setVisibility(View.INVISIBLE);
        AddBox2 = findViewById(R.id.AddBox2);
        AddBox2.setVisibility(View.INVISIBLE);
        AddBox3 = findViewById(R.id.AddBox3);
        AddBox3.setVisibility(View.INVISIBLE);
        AddBox4 = findViewById(R.id.AddBox4);
        AddBox4.setVisibility(View.INVISIBLE);
        AddBox5 = findViewById(R.id.AddBox5);
        AddBox5.setVisibility(View.INVISIBLE);
        AddBox6 = findViewById(R.id.AddBox6);
        AddBox6.setVisibility(View.INVISIBLE);
        AddBox7 = findViewById(R.id.AddBox7);
        AddBox7.setVisibility(View.INVISIBLE);

        Save = findViewById(R.id.button10);
        Save.setOnClickListener(this);
        Save.setVisibility(View.GONE);
        Cancel = findViewById(R.id.button11);
        Cancel.setOnClickListener(this);
        Cancel.setVisibility(View.GONE);
        Settings = findViewById(R.id.button8);
        Settings.setOnClickListener(this);

        calendar = findViewById(R.id.compactcalendar_view);
        calendar.removeAllEvents();

        Object[][] arr = {{"Med1Name","Med1Count", "Med1Dose", "Med1Box", Med1, 0, "#ff0000"}, //2D array that contains all the SP keys, makes accessing through functions easier as just the array needs to be passed as a parameter
                {"Med2Name", "Med2Count", "Med2Dose", "Med2Box", Med2, 0, "#ffee00"},
                {"Med3Name", "Med3Count", "Med3Dose", "Med3Box", Med3, 0, "#00ff08"},
                {"Med4Name", "Med4Count", "Med4Dose", "Med4Box", Med4, 0, "#00f2ff"},
                {"Med5Name", "Med5Count", "Med5Dose", "Med5Box", Med5, 0, "#0000ff"},
                {"Med6Name", "Med6Count", "Med6Dose", "Med6Box", Med6, 0, "#ff00e1"},
                {"Med7Name", "Med7Count", "Med7Dose", "Med7Box", Med7, 0, "#000000"}};

        for(int x=0; x<7; x++) { //for loop that loads every medication on startup

            long Remain = (long) (SP.getFloat(String.valueOf(arr[x][1]), 0) /SP.getFloat(String.valueOf(arr[x][2]), 0) - elapsed); //Remain = Pill Count/Pill Dose - elapsed time
            TextView Text = (TextView) arr[x][4];
            Text.setText(SP.getString(String.valueOf(arr[x][0]), "/") + ": " + Remain + " days");
            long date = System.currentTimeMillis() + (Remain*60*60*24*1000);
            @SuppressLint("Range") Event ev = new Event(Color.parseColor(String.valueOf(arr[x][6])), date); //marks the last day for a medication in the calendar with respective color
            calendar.addEvent(ev);
        }
    }


    @Override
    public void onClick(View v) { //when you click a "+" button to restock
        SharedPreferences SP = getSharedPreferences("Meds", 0);
        SharedPreferences.Editor editor = SP.edit();

        if (v.getId() != R.id.button8) {
            Save.setVisibility(View.VISIBLE);
            Cancel.setVisibility(View.VISIBLE);
        }

        switch (v.getId()) {
            case R.id.button:
                arr[0][5] = Add(arr, AddBox, 0); //arr[0][5] is the boxCount variable, gets reassigned here as the Add function returns boxCount, to keep it updated.
                break;

            case R.id.button2:
                arr[1][5] = Add(arr, AddBox2, 1);
                break;
            case R.id.button3:
                arr[2][5] = Add(arr, AddBox3, 2);
                break;

            case R.id.button4:
                arr[3][5] = Add(arr, AddBox4, 3);
                break;

            case R.id.button5:
                arr[4][5] = Add(arr, AddBox5, 4);
                break;

            case R.id.button6:
                arr[5][5] = Add(arr, AddBox6, 5);
                break;

            case R.id.button7:
                arr[6][5] = Add(arr, AddBox7, 6);
                break;

            case R.id.button8:
                final Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent); //starts settings activity when you press the SETTINGS button
                finish();
                break;

            case R.id.button10:
                for (int x = 0; x < 7; x++) { //updates the Count of the medications based on how many boxes (boxCount) you added and saves it to SP
                    int BoxAdd = (int) arr[x][5];

                    float NewCount = SP.getFloat(String.valueOf(arr[x][1]), 0) + BoxAdd * SP.getInt(String.valueOf(arr[x][3]), 0);
                    editor.putFloat(String.valueOf(arr[x][1]), NewCount);
                    editor.apply();
                }
                finish(); //reloads the activity
                startActivity(getIntent());


            case R.id.button11:
                finish(); //Cancel button, reloads the activity
                startActivity(getIntent());

        }
    }
}


