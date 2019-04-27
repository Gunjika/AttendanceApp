package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class new_account extends AppCompatActivity {
    TextView USid,Nam,emailid,pass,Cpass;
    Button register;
    CheckBox already;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        mAuth=FirebaseAuth.getInstance();
        USid=findViewById(R.id.editText3);
        Nam=findViewById(R.id.editText4);
        emailid=findViewById(R.id.editText5);
        pass=findViewById(R.id.editText6);
        Cpass=findViewById(R.id.editText10);
        register=findViewById(R.id.button9);
        already=findViewById(R.id.checkBox2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=USid.getText().toString().trim();
                String s2=Nam.getText().toString().trim();
                String s3=emailid.getText().toString().trim();
                String s4=pass.getText().toString().trim();
                String s5=Cpass.getText().toString().trim();
                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals(""))
                {
                    Toast.makeText(new_account.this, "please fill the entry", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    register(s1,s2,s3,s4,s5);
                    Toast.makeText(new_account.this, "Registarion Successfull", Toast.LENGTH_SHORT).show();
                    Intent RegIntent=new Intent(new_account.this,MainActivity.class);
                    startActivity(RegIntent);
                }
            }

            private void register(String s1, String s2, String s3, String s4, String s5) {
                mAuth.createUserWithEmailAndPassword(s1, s4)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                    Toast.makeText(new_account.this, "Registered Successfully!!", Toast.LENGTH_SHORT).show();
                                else
                                if (task.getException() instanceof FirebaseAuthWeakPasswordException)
                                    Toast.makeText(new_account.this, "PassWord Too Weak.\nTry Again!!", Toast.LENGTH_SHORT).show();
                                else if (task.getException() instanceof FirebaseAuthUserCollisionException)
                                    Toast.makeText(new_account.this, "User Already Exists!! \nTry Again!!", Toast.LENGTH_SHORT).show();
                                else if (task.getException() instanceof FirebaseNetworkException)
                                    Toast.makeText(new_account.this, "Internet Not Available!\nRetry... ", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(new_account.this, task.getException().toString(), Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alreadyIntent=new Intent(new_account.this,MainActivity.class);
                startActivity(alreadyIntent);
            }
        });
    }
}
