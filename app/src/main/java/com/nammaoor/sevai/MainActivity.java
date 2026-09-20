package com.nammaoor.sevai;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;
import android.graphics.Color;
import android.view.Gravity;
import android.graphics.Typeface;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // பட்டியல் பெரியதாக இருந்தால் ஸ்க்ரோல் (Scroll) செய்ய வசதி
        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.parseColor("#E8EAED")); 

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 50, 40, 50);

        // ஆப்பின் தலைப்பு
        TextView title = new TextView(this);
        title.setText("நம்ம ஊர் சேவை");
        title.setTextSize(32);
        title.setTextColor(Color.parseColor("#D32F2F")); 
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        title.setPadding(0, 0, 0, 10);

        // துணைத் தலைப்பு
        TextView subtitle = new TextView(this);
        subtitle.setText("உங்களுக்கு தேவையான சேவையைத் தேர்ந்தெடுக்கவும்:");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 0, 0, 60);

        layout.addView(title);
        layout.addView(subtitle);

        // அனைத்து தொழில்கள் / சேவைகளின் பட்டியல்
        String[] services = {
            "🚕 ஆட்டோ & டாக்ஸி புக்கிங்",
            "⚡ எலக்ட்ரீஷியன் (Electrician)",
            "🚰 பிளம்பர் (Plumber)",
            "❄️ ஏசி & பிரிட்ஜ் ரிப்பேர்",
            "🔨 தச்சு வேலை (Carpenter)",
            "🧹 வீட்டைச் சுத்தம் செய்ய",
            "🎨 பெயிண்டர் (Painter)",
            "🔧 டூவீலர் & கார் மெக்கானிக்",
            "📦 பார்சல் & கொரியர் சேவை",
            "📸 போட்டோ & வீடியோகிராபி",
            "👨‍🍳 சமையல் வேலைக்கு ஆட்கள்"
        };

        // ஒவ்வொரு சேவைக்கும் ஒரு பட்டனை உருவாக்குகிறோம்
        for (String serviceName : services) {
            Button btn = new Button(this);
            btn.setText(serviceName);
            btn.setBackgroundColor(Color.WHITE);
            btn.setTextColor(Color.BLACK);
            btn.setTextSize(18);
            btn.setPadding(30, 40, 30, 40);
            
            // பட்டன்களுக்கு இடையே இடைவெளி (Margin)
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 
                LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, 30); 
            btn.setLayoutParams(params);

            layout.addView(btn);
        }

        scrollView.addView(layout);
        setContentView(scrollView);
    }
}
