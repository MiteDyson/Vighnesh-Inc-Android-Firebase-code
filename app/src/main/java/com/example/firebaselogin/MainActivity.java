package com.example.firebaselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnLogout;
    private Button btnSoftSkills;
    private Button btnAndroid;
    private Button btnPython;
    private Button btnARVR;
    private Button btnBlockchain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btnlogout);
        btnSoftSkills = findViewById(R.id.btn_soft_skills);
        btnAndroid = findViewById(R.id.btn_android);
        btnPython = findViewById(R.id.btn_python);
        btnARVR = findViewById(R.id.btn_ar_vr);
        btnBlockchain = findViewById(R.id.btn_blockchain);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        btnSoftSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Soft Skills button click
                // For example, start Soft Skills activity
                startActivity(new Intent(MainActivity.this, SoftSkillsActivity.class));
            }
        });

        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Android App Development button click
                // For example, start Android App Development activity
                startActivity(new Intent(MainActivity.this, AndroidActivity.class));
            }
        });

        btnPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Python button click
                // For example, start Python activity
                startActivity(new Intent(MainActivity.this, PythonActivity.class));
            }
        });

        btnARVR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle AR/VR button click
                // For example, start AR/VR activity
                startActivity(new Intent(MainActivity.this, ARVRActivity.class));
            }
        });

        btnBlockchain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Blockchain button click
                // For example, start Blockchain activity
                startActivity(new Intent(MainActivity.this, BlockchainActivity.class));
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish(); // Close this activity so that user can't press back and return to the main screen
    }
}
