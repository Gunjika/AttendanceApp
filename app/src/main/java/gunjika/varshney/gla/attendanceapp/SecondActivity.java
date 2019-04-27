package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    TextView date,time1;
    Button takeAttend,logout;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        time1=findViewById(R.id.textView9);
        takeAttend=findViewById(R.id.button12);
        date=findViewById(R.id.textView12);
        logout=findViewById(R.id.button13);
        spinner=findViewById(R.id.spinner);

        Calendar calendar=Calendar.getInstance();
        String currentdate= DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        String time=format.format(calendar.getTime());
        time1.setText((CharSequence) time);

        date.setText(currentdate);

        takeAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent wifiIntent=new Intent(SecondActivity.this,Wifi_activity.class);
                startActivity(wifiIntent );
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(logoutIntent);
            }
        });
    }
    private void addCourse(){
        String genre=spinner.getSelectedItem().toString();

    }
}
