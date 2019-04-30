package gunjika.varshney.gla.attendanceapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import gunjika.varshney.gla.attendanceapp.R;

public class CustomListView extends ArrayAdapter<String> {
    private String[] name;
    private String[] id;
    private Activity context;
    public CustomListView(Activity context,String[] name,String[] id) {
        super(context, R.layout.listview_layout,name);
        this.context=context;
        this.name=name;
        this.id=id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.tvw1.setText(name[position]);
        viewHolder.tvw2.setText(id[position]);

        return r;
    }
    class ViewHolder
    {
        TextView tvw1,tvw2;
        ViewHolder(View v)
        {
            tvw1=v.findViewById(R.id.textView10);
            tvw2=v.findViewById(R.id.textView11);
        }
    }
}
