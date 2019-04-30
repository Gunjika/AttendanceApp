package gunjika.varshney.gla.attendanceapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    TextView date,time1,teachName,teachId;
    Button takeAttend,logout;
    Spinner spinner;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    User userr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        time1=findViewById(R.id.textView9);
        takeAttend=findViewById(R.id.button12);
        date=findViewById(R.id.textView12);
        teachName=findViewById(R.id.textView3);
        teachId=findViewById(R.id.textView4);
        //logout=findViewById(R.id.button13);
        spinner=findViewById(R.id.spinner);
        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        Calendar calendar=Calendar.getInstance();
        String currentdate= DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        String time=format.format(calendar.getTime());
        time1.setText((CharSequence) time);
        date.setText(currentdate);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                teachName.setText(dataSnapshot.child("-LdgR-ni6Wf4o6uvbfqc").child("name").getValue().toString());
                teachId.setText(dataSnapshot.child("-LdgR-ni6Wf4o6uvbfqc").child("id").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SecondActivity.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        takeAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent wifiIntent=new Intent(SecondActivity.this,Wifi_activity.class);
                startActivity(wifiIntent );
            }
        });
        /*logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth fAuth = FirebaseAuth.getInstance();
                fAuth.signOut();
                Intent logoutIntent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(logoutIntent);
            }
        });*/
    }
    private void addCourse(){
        String genre=spinner.getSelectedItem().toString();
    }
}
