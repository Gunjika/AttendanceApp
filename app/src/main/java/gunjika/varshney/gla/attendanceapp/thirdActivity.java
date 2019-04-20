package gunjika.varshney.gla.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

public class thirdActivity extends AppCompatActivity {
    ListView lst;
    String[] studentName={"Gunjika","Raksha","Shweta","Kishor"};
    int[] studentId={123,234,345,456};
    Integer[] ImgId={R.drawable.gunjika,R.drawable.raksha,R.drawable.shweta,R.drawable.ss};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        lst=findViewById(R.id.listview);
        customlistview customListView = new customlistview(this,studentName,studentId,ImgId);
        lst.setAdapter(customListView);
    }
}
