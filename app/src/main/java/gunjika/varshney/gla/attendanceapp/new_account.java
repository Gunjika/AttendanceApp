package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class new_account extends AppCompatActivity {
    TextView USid,Nam,emailid,pass,Cpass;
    Button register;
    CheckBox already;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
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
                if (s1.equals(" ")||s2.equals(" ")||s3.equals(" ")||s4.equals(" ")||s5.equals(" "))

                {
                    Toast.makeText(new_account.this, "please fill the entry", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(new_account.this, "Registarion Successfull", Toast.LENGTH_SHORT).show();
                    Intent RegIntent=new Intent(new_account.this,MainActivity.class);
                    startActivity(RegIntent);
                }
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
