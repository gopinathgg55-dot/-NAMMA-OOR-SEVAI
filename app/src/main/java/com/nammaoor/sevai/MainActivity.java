package com.nammaoor.sevai;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.graphics.Color;
import android.view.Gravity;
import android.graphics.Typeface;
import android.view.View;

public class MainActivity extends Activity {
    
    ScrollView homePage;
    ScrollView registerPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ==========================================
        // 1. முகப்புப் பக்கம் (HOME PAGE DESIGN)
        // ==========================================
        homePage = new ScrollView(this);
        homePage.setBackgroundColor(Color.parseColor("#E8EAED"));
        
        LinearLayout homeLayout = new LinearLayout(this);
        homeLayout.setOrientation(LinearLayout.VERTICAL);
        homeLayout.setPadding(40, 50, 40, 50);

        TextView title = new TextView(this);
        title.setText("நம்ம ஊர் சேவை");
        title.setTextSize(32);
        title.setTextColor(Color.parseColor("#D32F2F"));
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        
        // தொழிலாளர் பதிவு செய்யும் பட்டன் (புதிதாகச் சேர்த்தது)
        Button goRegisterBtn = new Button(this);
        goRegisterBtn.setText("👷 உங்கள் தொழிலை பதிவு செய்ய");
        goRegisterBtn.setBackgroundColor(Color.parseColor("#4CAF50")); // பச்சை நிறம்
        goRegisterBtn.setTextColor(Color.WHITE);
        goRegisterBtn.setTextSize(18);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btnParams.setMargins(0, 30, 0, 50);
        goRegisterBtn.setLayoutParams(btnParams);

        TextView subtitle = new TextView(this);
        subtitle.setText("உங்களுக்கு தேவையான சேவையைத் தேர்ந்தெடுக்கவும்:");
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 0, 0, 30);
        
        homeLayout.addView(title);
        homeLayout.addView(goRegisterBtn);
        homeLayout.addView(subtitle);

        String[] services = {
            "🚕 ஆட்டோ & டாக்ஸி", "⚡ எலக்ட்ரீஷியன்", "🚰 பிளம்பர்", 
            "❄️ ஏசி & பிரிட்ஜ் ரிப்பேர்", "🔨 தச்சு வேலை", "🧹 வீட்டைச் சுத்தம் செய்ய", 
            "🎨 பெயிண்டர்", "🔧 மெக்கானிக்", "👨‍🍳 சமையல் வேலைக்கு ஆட்கள்"
        };

        for (String s : services) {
            Button btn = new Button(this);
            btn.setText(s);
            btn.setBackgroundColor(Color.WHITE);
            btn.setPadding(30, 40, 30, 40);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(0, 0, 0, 20);
            btn.setLayoutParams(p);
            homeLayout.addView(btn);
        }
        homePage.addView(homeLayout);

        // ==========================================
        // 2. பதிவுப் படிவம் (REGISTER PAGE DESIGN)
        // ==========================================
        registerPage = new ScrollView(this);
        registerPage.setBackgroundColor(Color.WHITE);
        
        LinearLayout regLayout = new LinearLayout(this);
        regLayout.setOrientation(LinearLayout.VERTICAL);
        regLayout.setPadding(50, 50, 50, 50);

        TextView regTitle = new TextView(this);
        regTitle.setText("தொழிலாளர் பதிவு");
        regTitle.setTextSize(28);
        regTitle.setTextColor(Color.parseColor("#2196F3"));
        regTitle.setGravity(Gravity.CENTER);
        regTitle.setPadding(0, 0, 0, 50);

        EditText nameInput = new EditText(this);
        nameInput.setHint("உங்கள் பெயர்");
        
        EditText phoneInput = new EditText(this);
        phoneInput.setHint("மொபைல் எண்");
        
        EditText jobInput = new EditText(this);
        jobInput.setHint("செய்யும் தொழில் (உதா: எலக்ட்ரீஷியன்)");
        
        EditText areaInput = new EditText(this);
        areaInput.setHint("உங்கள் ஊர் / ஏரியா");

        TextView space = new TextView(this); 
        space.setHeight(60);

        Button submitBtn = new Button(this);
        submitBtn.setText("பதிவு செய்");
        submitBtn.setBackgroundColor(Color.parseColor("#FF9800")); // ஆரஞ்சு நிறம்
        submitBtn.setTextColor(Color.WHITE);
        submitBtn.setTextSize(18);
        
        TextView space2 = new TextView(this); 
        space2.setHeight(30);

        Button backBtn = new Button(this);
        backBtn.setText("பின் செல்ல (Back)");
        backBtn.setBackgroundColor(Color.LTGRAY);
        backBtn.setTextColor(Color.BLACK);

        regLayout.addView(regTitle);
        regLayout.addView(nameInput);
        regLayout.addView(phoneInput);
        regLayout.addView(jobInput);
        regLayout.addView(areaInput);
        regLayout.addView(space);
        regLayout.addView(submitBtn);
        regLayout.addView(space2);
        regLayout.addView(backBtn);
        
        registerPage.addView(regLayout);

        // ==========================================
        // 3. பட்டன் வேலை செய்யும் விதம் (ACTIONS)
        // ==========================================
        
        // பதிவு செய்ய பட்டனை அழுத்தினால் படிவம் திறக்கும்
        goRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(registerPage); 
            }
        });

        // பின் செல்ல பட்டனை அழுத்தினால் முகப்புப் பக்கம் வரும்
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(homePage); 
            }
        });

        // பதிவு செய் பட்டனை அழுத்தினால் மெசேஜ் வரும்
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "உங்கள் விவரங்கள் வெற்றிகரமாக பதிவு செய்யப்பட்டன!", Toast.LENGTH_LONG).show();
                setContentView(homePage); // மீண்டும் முகப்புப் பக்கத்திற்குச் செல்லும்
            }
        });

        // ஆப் திறக்கும்போது முகப்புப் பக்கத்தைக் காட்ட வேண்டும்
        setContentView(homePage);
    }
}
