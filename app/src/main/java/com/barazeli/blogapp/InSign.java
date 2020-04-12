package com.barazeli.blogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InSign extends AppCompatActivity {
    private TextInputLayout email_edit,pass_edit;
    private Button login,backtoregi;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_sign);
        login=findViewById(R.id.login_login);
        backtoregi=findViewById(R.id.backtoregi);
        email_edit=findViewById(R.id.email_login);
        pass_edit=findViewById(R.id.password_login);
       auth=FirebaseAuth.getInstance();
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (emailValidate()||passValidate()){
                   String email=email_edit.getEditText().getText().toString();
                   String pass=pass_edit.getEditText().getText().toString();
                   auth.signInWithEmailAndPassword(email,pass)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()){
                                       Intent intent=new Intent(getApplicationContext(),Home.class);
                                       startActivity(intent);
                                   }else {
                                       Toast.makeText(InSign.this, "Problem..",
                                               Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });
               }
           }
       });

    }
    private boolean passValidate() {
        String pass=pass_edit.getEditText().getText().toString();
        if (pass.isEmpty()){
            pass_edit.setError("Require Field..");
            return false;
        }else {
            pass_edit.setError(null);
            pass_edit.setErrorEnabled(false);
            return true;
        }
    }
    private boolean emailValidate() {
        String email=email_edit.getEditText().getText().toString();
        if (email.isEmpty()){
            email_edit.setError("Require Field..");
            return false;
        }else {
            email_edit.setError(null);
            email_edit.setErrorEnabled(false);
            return true;
        }
    }
}
