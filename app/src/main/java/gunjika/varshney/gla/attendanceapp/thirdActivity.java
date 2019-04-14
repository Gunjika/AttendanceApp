package gunjika.varshney.gla.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class thirdActivity extends AppCompatActivity {
    RecyclerView programminglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        programminglist=findViewById(R.id.programminglist);

    }
}
