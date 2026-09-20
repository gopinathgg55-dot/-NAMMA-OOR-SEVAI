package com.nammaoor.sevai;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
        createHomePage();
        createRegisterPage();
        
        // ஆப் திறக்கும்போது முகப்புப் பக்கத்தைக் காட்டு
        setContentView(homePage);
    }

    // ==========================================
    // 1. முகப்புப் பக்கம் உருவாக்கம்
    // ==========================================
    private void createHomePage() {
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
        
        Button goRegisterBtn = new Button(this);
        goRegisterBtn.setText("👷 உங்கள் தொழிலை பதிவு செய்ய");
        goRegisterBtn.setBackgroundColor(Color.parseColor("#4CAF50"));
        goRegisterBtn.setTextColor(Color.WHITE);
        goRegisterBtn.setTextSize(18);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btnParams.setMargins(0, 30, 0, 50);
        goRegisterBtn.setLayoutParams(btnParams);

        goRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(registerPage);
            }
        });

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

        for (final String s : services) {
            Button btn = new Button(this);
            btn.setText(s);
            btn.setBackgroundColor(Color.WHITE);
            btn.setPadding(30, 40, 30, 40);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.setMargins(0, 0, 0, 20);
            btn.setLayoutParams(p);
            
            // சேவையை கிளிக் செய்தால் தொழிலாளர் பட்டியல் பக்கம் திறக்கும்
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showWorkerList(s);
                }
            });

            homeLayout.addView(btn);
        }
        homePage.addView(homeLayout);
    }

    // ==========================================
    // 2. தொழிலாளர் பதிவுப் பக்கம் உருவாக்கம்
    // ==========================================
    private void createRegisterPage() {
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
        submitBtn.setBackgroundColor(Color.parseColor("#FF9800"));
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

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(homePage); 
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "உங்கள் விவரங்கள் வெற்றிகரமாக பதிவு செய்யப்பட்டன!", Toast.LENGTH_LONG).show();
                setContentView(homePage); 
            }
        });
    }

    // ==========================================
    // 3. தொழிலாளர்கள் பட்டியலைக் காட்டும் புதிய பக்கம்
    // ==========================================
    private void showWorkerList(String serviceName) {
        ScrollView workerPage = new ScrollView(this);
        workerPage.setBackgroundColor(Color.WHITE);
        
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 50, 40, 50);

        TextView title = new TextView(this);
        title.setText(serviceName + " - பணியாளர்கள்");
        title.setTextSize(24);
        title.setTextColor(Color.parseColor("#D32F2F"));
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 50);
        layout.addView(title);

        // ஒரு மாதிரி (Dummy) தொழிலாளர் அட்டை 
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundColor(Color.parseColor("#F1F8E9")); // மெல்லிய பச்சை நிறம்
        card.setPadding(40, 40, 40, 40);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(0, 0, 0, 50);
        card.setLayoutParams(cardParams);

        TextView workerName = new TextView(this);
        workerName.setText("பெயர்: ரமேஷ்");
        workerName.setTextSize(20);
        workerName.setTextColor(Color.BLACK);
        workerName.setTypeface(null, Typeface.BOLD);

        TextView workerExp = new TextView(this);
        workerExp.setText("அனுபவம்: 5 வருடங்கள்");
        workerExp.setTextSize(16);
        workerExp.setPadding(0, 10, 0, 30);

        // 📞 கால் செய்யும் பட்டன்
        Button callBtn = new Button(this);
        callBtn.setText("📞 கால் செய்ய (Call)");
        callBtn.setBackgroundColor(Color.parseColor("#2196F3")); // நீல நிறம்
        callBtn.setTextColor(Color.WHITE);
        callBtn.setTextSize(18);
        
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876543210")); // மாதிரி நம்பர்
                startActivity(intent);
            }
        });
