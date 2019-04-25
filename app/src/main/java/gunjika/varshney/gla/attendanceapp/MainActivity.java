package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c1=textEmail.getText().toString().trim();
                String c2=textPass.getText().toString().trim();
                if (c1.equals("gunjika")&&c2.equals("12345"))
                {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent sendIntent= new Intent(MainActivity.this,SecondActivity.class);
                    sendIntent.putExtra("gunjika",c1);
                    startActivity(sendIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "login unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent=new Intent(MainActivity.this,new_account.class);
                startActivity(newIntent);
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seIntent=new Intent(MainActivity.this,forgot_pass.class);
                startActivity(seIntent);
            }
        });
    }
}
