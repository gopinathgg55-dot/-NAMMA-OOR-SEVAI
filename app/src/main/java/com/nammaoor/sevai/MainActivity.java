package com.nammaoor.sevai;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createHomePage();
    }

    private void createHomePage() {
        ScrollView homePage = new ScrollView(this);
        homePage.setBackgroundColor(Color.WHITE);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 40, 40, 50);

        TextView title = new TextView(this);
        title.setText("நம்மா ஊர் சேவை");
        title.setTextSize(28);
        title.setTextColor(Color.parseColor("#4D3F2F"));
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 50);
        layout.addView(title);

        Button regBtn = new Button(this);
        regBtn.setText("புதிய பதிவு");
        regBtn.setBackgroundColor(Color.parseColor("#2196F3"));
        regBtn.setTextColor(Color.WHITE);
        regBtn.setTextSize(18);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createRegisterPage();
            }
        });
        layout.addView(regBtn);

        homePage.addView(layout);
        setContentView(homePage);
    }

    private void createRegisterPage() {
        ScrollView registerPage = new ScrollView(this);
        registerPage.setBackgroundColor(Color.WHITE);

        LinearLayout regLayout = new LinearLayout(this);
        regLayout.setOrientation(LinearLayout.VERTICAL);
        regLayout.setPadding(40, 40, 40, 50);

        TextView regTitle = new TextView(this);
        regTitle.setText("சேவை பதிவு");
        regTitle.setTextSize(24);
        regTitle.setTextColor(Color.parseColor("#4D3F2F"));
        regTitle.setGravity(Gravity.CENTER);
        regTitle.setPadding(0, 0, 0, 30);
        regLayout.addView(regTitle);

        Button backBtn = new Button(this);
        backBtn.setText("பின் செல்ல");
        backBtn.setBackgroundColor(Color.parseColor("#E0E0E0"));
        backBtn.setTextColor(Color.BLACK);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createHomePage();
            }
        });
        regLayout.addView(backBtn);

        Button submitBtn = new Button(this);
        submitBtn.setText("பதிவு செய்");
        submitBtn.setBackgroundColor(Color.parseColor("#4CAF50"));
        submitBtn.setTextColor(Color.WHITE);
        submitBtn.setTextSize(18);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "பதிவு வெற்றிகரமாக முடிந்தது!", Toast.LENGTH_SHORT).show();
                createHomePage();
            }
        });
        regLayout.addView(submitBtn);

        registerPage.addView(regLayout);
        setContentView(registerPage);
    }
}
