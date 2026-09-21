package com.nammaoor.sevai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName, editTextExperience, editTextPhone;
    private Button buttonRegister;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // உங்கள் வடிவமைப்பு XML ஃபைல் பெயர்

        // Firebase Firestore இன்ஸ்டன்ஸ் பெறுதல்
        db = FirebaseFirestore.getInstance();

        // UI கூறுகளை இணைத்தல் (உங்கள் XML ஐடிகளுக்கு ஏற்ப மாற்றிக் கொள்ளவும்)
        editTextName = findViewById(R.id.editTextName);
        editTextExperience = findViewById(R.id.editTextExperience);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String experience = editTextExperience.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();

                if (!name.isEmpty() && !experience.isEmpty() && !phone.isEmpty()) {
                    saveDataToFirebase(name, experience, phone);
                } else {
                    Toast.makeText(RegisterActivity.class, "அனைத்து விவரங்களையும் நிரப்பவும்!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveDataToFirebase(String name, String experience, String phone) {
        Map<String, Object> worker = new HashMap<>();
        worker.put("name", name);
        worker.put("experience", experience);
        worker.put("phone", phone);

        // "workers" என்ற கலெக்‌ஷனில் தரவைச் சேமித்தல்
        db.collection("workers")
                .add(worker)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RegisterActivity.this, "வெற்றிகரமாக பதிவு செய்யப்பட்டது!", Toast.LENGTH_SHORT).show();
                        finish(); // முந்தைய பக்கத்திற்குத் திரும்ப
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "பதிவு செய்வதில் பிழை: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

