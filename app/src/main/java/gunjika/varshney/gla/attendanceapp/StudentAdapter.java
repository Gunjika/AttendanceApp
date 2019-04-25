package gunjika.varshney.gla.attendanceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView studentId,studentName;
        ImageView Ivw;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentId=itemView.findViewById(R.id.textView10);
            studentName=itemView.findViewById(R.id.textView11);
            Ivw=itemView.findViewById(R.id.imageView2);
        }
    }
}
