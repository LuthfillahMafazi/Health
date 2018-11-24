package co.example.lutfillahmafazi.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.example.lutfillahmafazi.health.Adapter.AdapterPenyakit;

public class RecyleActivity extends AppCompatActivity {


    String[] namaPenyakitRingan, namaPenyakitBerat, detailPenyakitBerat, detailPenyakitRingan;
    int[] gambarPenyakitRingan, gambarPenyakitBerat;

    AdapterPenyakit adapterPenyakit;
    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyle);
        ButterKnife.bind(this);

        namaPenyakitRingan = getResources().getStringArray(R.array.sakit_ringan);
        namaPenyakitBerat = getResources().getStringArray(R.array.penyakit_berat);
        detailPenyakitRingan = getResources().getStringArray(R.array.detail_sakit_ringan);
        detailPenyakitBerat = getResources().getStringArray(R.array.detail_penyakit_berat);
        gambarPenyakitRingan = new int[]{R.drawable.sakit_kepala, R.drawable.flu, R.drawable.batuk, R.drawable.asam_urat, R.drawable.sakit_perut};
        gambarPenyakitBerat = new int[]{R.drawable.batu_ginjal, R.drawable.stroke, R.drawable.hipertensi, R.drawable.serangan_jantung, R.drawable.radang_sendi, R.drawable.osteoporosis, R.drawable.alzheimer};

        String penyakit = getIntent().getStringExtra("penyakit");
        Log.i("nama_penyakit", penyakit);

        if (penyakit.equals("ringan")) {
            adapterPenyakit = new AdapterPenyakit(RecyleActivity.this, namaPenyakitRingan, detailPenyakitRingan, gambarPenyakitRingan);
        } else {
            adapterPenyakit = new AdapterPenyakit(RecyleActivity.this, namaPenyakitBerat, detailPenyakitBerat, gambarPenyakitBerat);
        }

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapterPenyakit);
    }

}
