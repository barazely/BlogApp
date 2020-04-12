package com.barazeli.blogapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Objects;

public class UpSign extends AppCompatActivity {
    private TextInputLayout email_edit,pass_edit,fullname_edit,username_edit;
    private Button up_sign,backtologin;
    private FirebaseAuth auth;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        setContentView(R.layout.activity_up_sign);
        auth=FirebaseAuth.getInstance();
        up_sign=findViewById(R.id.sign_up_insignup);
        backtologin=findViewById(R.id.backtologin);
        email_edit=findViewById(R.id.email_signup);
        pass_edit=findViewById(R.id.password_signup);
        fullname_edit=findViewById(R.id.fullname_signup);
        username_edit=findViewById(R.id.username_signup);

        up_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailValidate()||passValidate()){

                    String email= Objects.requireNonNull(email_edit.getEditText()).getText().toString();
                    String pass= Objects.requireNonNull(pass_edit.getEditText()).getText().toString();
                    auth.createUserWithEmailAndPassword(email,pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent=new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(UpSign.this, "Problem..",
                                        Toast.LENGTH_SHORT).show();
                            //    Snackbar.make(getApplicationContext(),"Problem..",Snackbar.LENGTH_SHORT)
                            }
                        }   }); }}});


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


//
//    private boolean fullNamelValidate() {
//        String fullName=fullname_edit.getEditText().getText().toString();
//        if (fullName.isEmpty()){
//            fullname_edit.setError("Require Field..");
//            return false;
//        }else {
//            fullname_edit.setError(null);
//            fullname_edit.setErrorEnabled(false);
//            return true;
//        }
//    }
//    private boolean userNamelValidate() {
//        String userName=username_edit.getEditText().getText().toString();
//        if (userName.isEmpty()){
//            username_edit.setError("Require Field..");
//            return false;
//        }else {
//            username_edit.setError(null);
//            username_edit.setErrorEnabled(false);
//            return true;
//        }
//    }

}
