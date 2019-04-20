package gunjika.varshney.gla.attendanceapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customlistview extends ArrayAdapter<String> {
    private String[] studentName;
    private int[] studentId;
    private Integer[] imgId;
    private Activity context;
    public customlistview(Activity context, String[] studentName,int[] studentId,Integer[] imgId) {
        super(context, R.layout.listview_layout,studentName);
        this.context=context;
        this.studentName=studentName;
        this.studentId=studentId;
        this.imgId=imgId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
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
        viewHolder.ivw.setImageResource(imgId[position]);
        viewHolder.tvw2.setText(studentName[position]);
        viewHolder.tvw1.setText(studentId[position]);
        return r;
    }
    class ViewHolder
    {
        TextView tvw1,tvw2;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1=v.findViewById(R.id.textView10);
            tvw2=v.findViewById(R.id.textView11);
            ivw=v.findViewById(R.id.imageView2);
        }
    }
}
