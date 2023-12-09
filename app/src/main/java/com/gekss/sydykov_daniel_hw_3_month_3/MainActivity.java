package com.gekss.sydykov_daniel_hw_3_month_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etTheme, etComments;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        onClick();
    }

    private void findId() {
        etEmail = findViewById(R.id.et_email);
        etTheme = findViewById(R.id.et_theme);
        etComments = findViewById(R.id.et_theme);
        btnSend = findViewById(R.id.btn_sand);
    }

    private void onClick(){
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigeitNext();
            }
        });
    }

    private void navigeitNext(){
        String email = etEmail.getText().toString();
        String theme = etTheme.getText().toString();
        String comments = etComments.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("lain/text");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT,theme);
        intent.putExtra(Intent.EXTRA_TEXT,comments);
        startActivity(Intent.createChooser(intent,"massage"));
    }
}