package gunjika.varshney.gla.attendanceapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

 public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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
         ImageView iView;
         TextView id,name;
         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             iView=itemView.findViewById(R.id.imageView);
             id=itemView.findViewById(R.id.textView);
             name=itemView.findViewById(R.id.textView2);
         }
     }
 }
