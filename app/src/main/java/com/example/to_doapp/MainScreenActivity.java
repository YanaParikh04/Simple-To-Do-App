package com.example.to_doapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.to_doapp.databinding.ActivityMainBinding;
import com.example.to_doapp.databinding.MainScreenBinding;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity {

    private MainScreenBinding binding;
    String textappear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding =MainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<String> tasklist = new ArrayList<String>();
        tasklist.add("Attend Exam");
        tasklist.add("Complete the App Development Project");
        tasklist.add("Work on Resume");
        tasklist.add("Improve Internet Presence");
        tasklist.add("Attend Meeting");
        tasklist.add("Call Mom");
        tasklist.add("Call Dad");
        tasklist.add("Call Friend");
        tasklist.add("Complete Notes");
        tasklist.add("Make advance version of Notes App");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasklist);
        binding.listview.setAdapter(adapter);

        binding.listview.setOnItemClickListener((parent, view, position, id) -> {
            textappear="Clicked on Item: "+((TextView)view).getText().toString();
            Toast.makeText(MainScreenActivity.this,textappear,Toast.LENGTH_SHORT).show();
        });

    }
}