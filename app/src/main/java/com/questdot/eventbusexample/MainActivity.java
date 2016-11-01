package com.questdot.eventbusexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private Button btnPostSticky,btnPost;
    private EditText etName,etPhone,etEmail;
    private EventBus bus = EventBus.getDefault();
    private TextView txtName,txtPhone,txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPostSticky = (Button) findViewById(R.id.btnPostSticky);
        btnPost = (Button) findViewById(R.id.btnPost);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        txtName = (TextView) findViewById(R.id.txtName);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        btnPostSticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please fill in all empty field",Toast.LENGTH_LONG).show();
                } else {

                    bus.postSticky(new User(etName.getText().toString(),etPhone.getText().toString(),etEmail.getText().toString()));
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please fill in all empty field",Toast.LENGTH_LONG).show();
                } else {

                    bus.post(new User(etName.getText().toString(),etPhone.getText().toString(),etEmail.getText().toString()));
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    public void onStop() {
        bus.unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getUser(User event){
        txtName.setText( event.getName());
        txtPhone.setText(event.getPhone());
        txtEmail.setText(event.getEmail());
    }

}
