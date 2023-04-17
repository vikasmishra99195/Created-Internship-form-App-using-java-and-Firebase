package com.example.databaseinterns;

import static com.example.databaseinterns.R.id.fullname;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class InternshipForms extends AppCompatActivity {

    TextInputEditText fullname, phonenumber, email;
    EditText whyHireEdtText;
    Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_internship_forms);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phonenumber = findViewById(R.id.phonenumber);
        whyHireEdtText = findViewById(R.id.whyHireEdtText);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Hash Map used to store multiple data in firebase

                HashMap<String, Object> intern= new HashMap<String, Object>();
                intern.put("fullname",fullname.getText().toString());
                intern.put("contact", phonenumber.getText().toString());
                intern.put("email",email.getText().toString());
                intern.put("whyShouldWeHireYou",whyHireEdtText.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("intern").push().setValue(intern);

                Toast.makeText(InternshipForms.this, "Form Submitted", Toast.LENGTH_SHORT).show();

//                FirebaseDatabase.getInstance().getReference().child("Intern 1").setValue("Vikas Mishra");
            }
        });

    }
}