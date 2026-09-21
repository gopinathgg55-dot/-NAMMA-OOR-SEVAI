package com.nammaoor.sevai;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class WorkerListActivity extends AppCompatActivity {

    private ListView listViewWorkers;
    private FirebaseFirestore db;
    private ArrayList<String> workerList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_list);

        listViewWorkers = findViewById(R.id.listViewWorkers);
        db = FirebaseFirestore.getInstance();
        workerList = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, workerList);
        listViewWorkers.setAdapter(adapter);

        loadWorkersFromFirestore();
    }

    private void loadWorkersFromFirestore() {
        db.collection("workers")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        workerList.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String name = document.getString("name");
                            String experience = document.getString("experience");
                            String phone = document.getString("phone");

                            String info = "பெயர்: " + name + "\nஅனுபவம்: " + experience + "\nபோன்: " + phone;
                            workerList.add(info);
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(WorkerListActivity.this, "தரவுகளை எடுப்பதில் பிழை", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
