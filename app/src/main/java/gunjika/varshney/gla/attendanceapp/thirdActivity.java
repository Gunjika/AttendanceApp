package gunjika.varshney.gla.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class thirdActivity extends AppCompatActivity {
    Button save;
    private ListView lst;
    String[] name={"Aastha","Aarchi","Divyanshi","Gunjika","Neha","Raksha","Shruti","Shweta","Vaishali"};
    String[] id={"01","09","18","22","36","42","50","53","60"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        lst =(ListView) findViewById(R.id.listview);
        save=findViewById(R.id.button5);
        CustomListView customListView=new CustomListView(this,name,id);
        lst.setAdapter(customListView);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(thirdActivity.this, "data saved", Toast.LENGTH_SHORT).show();
            }
        });
        /*
         * Create a DatabaseReference to the data; works with standard DatabaseReference methods
         * like limitToLast() and etc.
         */
        /*DatabaseReference peopleReference = FirebaseDatabase.getInstance().getReference().child("people");

        // Now set the adapter with a given layout
        lst.setAdapter(new FirebaseListAdapter<Person>(this, Person.class,
                android.R.layout.one_line_list_item, peopleReference) {

            // Populate view as needed
            @Override
            protected void populateView(View view, Person person, int position) {
                ((TextView) view.findViewById(android.R.id.text1)).setText(person.getName());
            }
        });*/
    }

}
