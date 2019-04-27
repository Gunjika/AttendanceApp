package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    TextView date,time1;
    Button takeAttend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Calendar calendar=Calendar.getInstance();
        String currentdate= DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        String time=format.format(calendar.getTime());
        date=findViewById(R.id.editText7);
        date.setText(currentdate);
        time1=findViewById(R.id.editText8);
        time1.setText((CharSequence) time1);
        takeAttend=findViewById(R.id.button5);
        takeAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wifiIntent=new Intent(SecondActivity.this,Wifi_activity.class);
                startActivity(wifiIntent);
            }
        });
    }
}
