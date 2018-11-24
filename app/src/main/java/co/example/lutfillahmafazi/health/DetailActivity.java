package co.example.lutfillahmafazi.health;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends Activity {


    @BindView(R.id.imgDetailPenyakit)
    ImageView imgDetailPenyakit;
    @BindView(R.id.txtDetailPenyakit)
    TextView txtDetailPenyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        txtDetailPenyakit.setText(getIntent().getStringExtra("dp"));
        Glide.with(this).load(getIntent().getIntExtra("gp",0)).into(imgDetailPenyakit);
    }
}
