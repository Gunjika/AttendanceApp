package gunjika.varshney.gla.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textEmail,textPass;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEmail=findViewById(R.id.editText);
        textPass=findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c1=textEmail.getText().toString().trim();
                String c2=textPass.getText().toString().trim();
                if(c1.equals() && c2.equals())
                {

                }
            }
        });
    }
}
