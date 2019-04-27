package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textEmail,textPass;
    Button button,button1;
    CheckBox checkBox;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEmail=findViewById(R.id.editText);
        textPass=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        button1=findViewById(R.id.button6);
        checkBox=findViewById(R.id.checkBox);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),SecondActivity.class));
        }
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        checkBox.setOnClickListener(this);
    }
    private void userLogin()
    {
        String email=textEmail.getText().toString().trim();
        String pass=textPass.getText().toString().trim();

        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "enter the email id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass))
        {
            Toast.makeText(this, "enter the pass", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v==button)
        {
            userLogin();
        }
        if (v==button1){
            finish();
            startActivity(new Intent(this,new_account.class));
        }
        if (v==checkBox)
        {
            finish();
            startActivity(new Intent(this,forgot_pass.class));
        }
    }
}
