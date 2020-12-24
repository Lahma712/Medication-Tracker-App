package com.example.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Name1;
    private EditText Count1;
    private EditText Box1;
    private EditText Dose1;

    private EditText Name2;
    private EditText Count2;
    private EditText Box2;
    private EditText Dose2;

    private EditText Name3;
    private EditText Count3;
    private EditText Box3;
    private EditText Dose3;

    private EditText Name4;
    private EditText Count4;
    private EditText Box4;
    private EditText Dose4;

    private EditText Name5;
    private EditText Count5;
    private EditText Box5;
    private EditText Dose5;

    private EditText Name6;
    private EditText Count6;
    private EditText Box6;
    private EditText Dose6;

    private EditText Name7;
    private EditText Count7;
    private EditText Box7;
    private EditText Dose7;

    private EditText timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences SP = getSharedPreferences("Meds", 0);
        Name1 = findViewById(R.id.Name1);
        Count1 = findViewById(R.id.Count1);
        Box1 = findViewById(R.id.Box1);
        Dose1 = findViewById(R.id.Dose1);

        Name2 = findViewById(R.id.Name2);
        Count2 = findViewById(R.id.Count2);
        Box2 = findViewById(R.id.Box2);
        Dose2 = findViewById(R.id.Dose2);

        Name3 = findViewById(R.id.Name3);
        Count3 = findViewById(R.id.Count3);
        Box3 = findViewById(R.id.Box3);
        Dose3 = findViewById(R.id.Dose3);

        Name4 = findViewById(R.id.Name4);
        Count4 = findViewById(R.id.Count4);
        Box4 = findViewById(R.id.Box4);
        Dose4 = findViewById(R.id.Dose4);

        Name5 = findViewById(R.id.Name5);
        Count5 = findViewById(R.id.Count5);
        Box5 = findViewById(R.id.Box5);
        Dose5 = findViewById(R.id.Dose5);

        Name6 = findViewById(R.id.Name6);
        Count6 = findViewById(R.id.Count6);
        Box6 = findViewById(R.id.Box6);
        Dose6 = findViewById(R.id.Dose6);

        Name7 = findViewById(R.id.Name7);
        Count7 = findViewById(R.id.Count7);
        Box7 = findViewById(R.id.Box7);
        Dose7 = findViewById(R.id.Dose7);

        timestamp = findViewById(R.id.Timestamp);
        Button doneBtn = findViewById(R.id.button9);
        doneBtn.setOnClickListener(this);

        Name1.setHint(SP.getString("Med1Name", "/"));
        Box1.setHint(String.valueOf(SP.getInt("Med1Box", 0)));
        Dose1.setHint(String.valueOf(SP.getFloat("Med1Dose", 0)));

        Name2.setHint(SP.getString("Med2Name", "/"));
        Box2.setHint(String.valueOf(SP.getInt("Med2Box", 0)));
        Dose2.setHint(String.valueOf(SP.getFloat("Med2Dose", 0)));

        Name3.setHint(SP.getString("Med3Name", "/"));
        Box3.setHint(String.valueOf(SP.getInt("Med3Box", 0)));
        Dose3.setHint(String.valueOf(SP.getFloat("Med3Dose", 0)));

        Name4.setHint(SP.getString("Med4Name", "/"));
        Box4.setHint(String.valueOf(SP.getInt("Med4Box", 0)));
        Dose4.setHint(String.valueOf(SP.getFloat("Med4Dose", 0)));

        Name5.setHint(SP.getString("Med5Name", "/"));
        Box5.setHint(String.valueOf(SP.getInt("Med5Box", 0)));
        Dose5.setHint(String.valueOf(SP.getFloat("Med5Dose", 0)));

        Name6.setHint(SP.getString("Med6Name", "/"));
        Box6.setHint(String.valueOf(SP.getInt("Med6Box", 0)));
        Dose6.setHint(String.valueOf(SP.getFloat("Med6Dose", 0)));

        Name7.setHint(SP.getString("Med7Name", "/"));
        Box7.setHint(String.valueOf(SP.getInt("Med7Box", 0)));
        Dose7.setHint(String.valueOf(SP.getFloat("Med7Dose", 0)));

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}

            @Override
            public void afterTextChanged(Editable s) { //watcher for when you write something in an EditText, pairs the value to its respective key in the SP
                SharedPreferences.Editor editor = SP.edit();
                if (!s.toString().equalsIgnoreCase("")) {
                if (s == Name1.getEditableText()){
                    editor.putString("Med1Name", Name1.getText().toString());
                }

                if (s== Count1.getEditableText()){
                    editor.putFloat("Med1Count", Float.parseFloat(Count1.getText().toString()));
                }
                if (s== Box1.getEditableText()){
                    editor.putInt("Med1Box", Integer.parseInt(Box1.getText().toString()));
                }
                if (s== Dose1.getEditableText()){
                    editor.putFloat("Med1Dose", Float.parseFloat(Dose1.getText().toString()));
                }


                if (s == Name2.getEditableText()){
                    editor.putString("Med2Name", Name2.getText().toString());
                }
                if (s== Count2.getEditableText()){
                    editor.putFloat("Med2Count", Float.parseFloat(Count2.getText().toString()));
                }
                if (s== Box2.getEditableText()){
                    editor.putInt("Med2Box", Integer.parseInt(Box2.getText().toString()));
                }
                if (s== Dose2.getEditableText()){
                    editor.putFloat("Med2Dose", Float.parseFloat(Dose2.getText().toString()));
                }


                if (s == Name3.getEditableText()){
                    editor.putString("Med3Name", Name3.getText().toString());
                }
                if (s== Count3.getEditableText()){
                    editor.putFloat("Med3Count", Float.parseFloat(Count3.getText().toString()));
                }
                if (s== Box3.getEditableText()){
                    editor.putInt("Med3Box", Integer.parseInt(Box3.getText().toString()));
                }
                if (s== Dose3.getEditableText()){
                    editor.putFloat("Med3Dose", Float.parseFloat(Dose3.getText().toString()));
                }


                if (s == Name4.getEditableText()){
                    editor.putString("Med4Name", Name4.getText().toString());
                }
                if (s== Count4.getEditableText()){
                    editor.putFloat("Med4Count", Float.parseFloat(Count4.getText().toString()));
                }
                if (s== Box4.getEditableText()){
                    editor.putInt("Med4Box", Integer.parseInt(Box4.getText().toString()));
                }
                if (s== Dose4.getEditableText()){
                    editor.putFloat("Med4Dose", Float.parseFloat(Dose4.getText().toString()));
                }


                if (s == Name5.getEditableText()){
                    editor.putString("Med5Name", Name5.getText().toString());
                }
                if (s== Count5.getEditableText()){
                    editor.putFloat("Med5Count", Float.parseFloat(Count5.getText().toString()));
                }
                if (s== Box5.getEditableText()){
                    editor.putInt("Med5Box", Integer.parseInt(Box5.getText().toString()));
                }
                if (s== Dose5.getEditableText()){
                    editor.putFloat("Med5Dose", Float.parseFloat(Dose5.getText().toString()));
                }


                if (s == Name6.getEditableText()){
                        editor.putString("Med6Name", Name6.getText().toString());
                }
                if (s== Count6.getEditableText()){
                        editor.putFloat("Med6Count", Float.parseFloat(Count6.getText().toString()));
                }
                if (s== Box6.getEditableText()){
                        editor.putInt("Med6Box", Integer.parseInt(Box6.getText().toString()));
                }
                if (s== Dose6.getEditableText()){
                        editor.putFloat("Med6Dose", Float.parseFloat(Dose6.getText().toString()));
                }


                if (s == Name7.getEditableText()){
                        editor.putString("Med7Name", Name7.getText().toString());
                }
                if (s== Count7.getEditableText()){
                        editor.putFloat("Med7Count", Float.parseFloat(Count7.getText().toString()));
                }
                if (s== Box7.getEditableText()){
                        editor.putInt("Med7Box", Integer.parseInt(Box7.getText().toString()));
                }
                if (s== Dose7.getEditableText()){
                        editor.putFloat("Med7Dose", Float.parseFloat(Dose7.getText().toString()));
                }


                if (s==timestamp.getEditableText()) {
                    editor.putLong("Timestamp", Long.parseLong(timestamp.getText().toString()));
                }

                    editor.commit();

                }
            }
        };

        Name1.addTextChangedListener(watcher); //binds EditTexts to watcher
        Count1.addTextChangedListener(watcher);
        Box1.addTextChangedListener(watcher);
        Dose1.addTextChangedListener(watcher);

        Name2.addTextChangedListener(watcher);
        Count2.addTextChangedListener(watcher);
        Box2.addTextChangedListener(watcher);
        Dose2.addTextChangedListener(watcher);

        Name3.addTextChangedListener(watcher);
        Count3.addTextChangedListener(watcher);
        Box3.addTextChangedListener(watcher);
        Dose3.addTextChangedListener(watcher);

        Name4.addTextChangedListener(watcher);
        Count4.addTextChangedListener(watcher);
        Box4.addTextChangedListener(watcher);
        Dose4.addTextChangedListener(watcher);

        Name5.addTextChangedListener(watcher);
        Count5.addTextChangedListener(watcher);
        Box5.addTextChangedListener(watcher);
        Dose5.addTextChangedListener(watcher);

        Name6.addTextChangedListener(watcher);
        Count6.addTextChangedListener(watcher);
        Box6.addTextChangedListener(watcher);
        Dose6.addTextChangedListener(watcher);

        Name7.addTextChangedListener(watcher);
        Count7.addTextChangedListener(watcher);
        Box7.addTextChangedListener(watcher);
        Dose7.addTextChangedListener(watcher);

        timestamp.addTextChangedListener(watcher);
    }

    @Override
    public void onClick(View v) {
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }
}