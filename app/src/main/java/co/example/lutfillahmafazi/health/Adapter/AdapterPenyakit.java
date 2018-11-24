package co.example.lutfillahmafazi.health.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import co.example.lutfillahmafazi.health.DetailActivity;
import co.example.lutfillahmafazi.health.R;

public class AdapterPenyakit extends RecyclerView.Adapter<AdapterPenyakit.ViewHolder> {

    Context context;
    String[] namaPenyakit, detailPenyakit;
    int[] gambarPenyakit;

    public AdapterPenyakit(Context context, String[] namaPenyakit, String[] detailPenyakit, int[] gambarPenyakit) {
        this.context = context;
        this.namaPenyakit = namaPenyakit;
        this.detailPenyakit = detailPenyakit;
        this.gambarPenyakit = gambarPenyakit;
    }

    @NonNull
    @Override
    public AdapterPenyakit.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_penyakit,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPenyakit.ViewHolder viewHolder, final int i) {
        viewHolder.txtPenyakit.setText(namaPenyakit[i]);
        Glide.with(context).load(gambarPenyakit[i]).into(viewHolder.imageButton);

        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("dp",detailPenyakit[i]);
                intent.putExtra("gp",gambarPenyakit[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarPenyakit.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPenyakit;
        ImageButton imageButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPenyakit = itemView.findViewById(R.id.txtList);
            imageButton = itemView.findViewById(R.id.btnGambar);
        }
    }
}
