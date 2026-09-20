package com.nammaoor.sevai;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText("நம்ம ஊர் சேவை ஆப் தயார்!\n\nWelcome to Namma Oor Sevai");
        text.setTextSize(24);
        text.setTextColor(Color.BLACK);
        text.setGravity(Gravity.CENTER);

        setContentView(text);
    }
}
