package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class forgot_pass extends AppCompatActivity {
    TextView Uid,email;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        Uid=findViewById(R.id.editText9);
        email=findViewById(R.id.editText11);
        confirm=findViewById(R.id.button3);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=Uid.getText().toString().trim();
                String y=email.getText().toString().trim();
                if (x.equals("")||y.equals(""))
                {
                    Toast.makeText(forgot_pass.this, "fill all entries", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent emailIntent=new Intent(Intent.ACTION_SENDTO, Uri.EMPTY.fromParts("mailto",y,null));
                    emailIntent.putExtra(Intent.EXTRA_TEXT,x);
                    if (emailIntent.resolveActivity(getPackageManager())!=null)
                    {
                        startActivity(emailIntent);
                    }
                    else
                    {
                        Toast.makeText(forgot_pass.this, "No Activity found to handle Intent", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
