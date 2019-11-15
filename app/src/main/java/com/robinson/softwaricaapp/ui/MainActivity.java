package com.robinson.softwaricaapp.ui;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.robinson.softwaricaapp.R;
import com.robinson.softwaricaapp.controller.ControllerClass;
import com.robinson.softwaricaapp.model.UserData;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText log_name, log_password;
    ImageView log_name_img, log_pass_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btnlogin);
        log_name = findViewById(R.id.LGname);
        log_password = findViewById(R.id.LGpassword);
        log_name_img = findViewById(R.id.lgnamaeimg);
        log_pass_img = findViewById(R.id.LGpassimg);
        log_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_name_img.setImageResource(R.drawable.correct);
                } else if(start==0) {
                    log_name_img.setImageResource(R.drawable.wrong);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        log_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    log_pass_img.setImageResource(R.drawable.correct);
                } else if(start==0) {
                    log_pass_img.setImageResource(R.drawable.wrong);


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData dataSet = new UserData();
                if (!TextUtils.isEmpty(log_name.getText().toString())) {
                    dataSet.setName(log_name.getText().toString());
                    if (!TextUtils.isEmpty(log_password.getText().toString())) {
                        dataSet.setPassword(log_password.getText().toString());
                        boolean result = new ControllerClass().CheckUser(dataSet);
                        if (result) {
                            Intent intent = new Intent(MainActivity.this, MainWindow.class);
                            startActivity(intent);
                            log_name.setText("");
                            log_password.setText("");
                        } else {
                            Toast.makeText(MainActivity.this, "user name or password mistake", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        log_password.setError("please enter password");
                        log_pass_img.setImageResource(R.drawable.wrong);
                    }
                } else {
                    log_name.setError("please enter user name");
                    log_name_img.setImageResource(R.drawable.wrong);

                }
            }
        });
    }
}

