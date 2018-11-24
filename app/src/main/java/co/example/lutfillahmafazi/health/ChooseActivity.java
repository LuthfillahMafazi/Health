package co.example.lutfillahmafazi.health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseActivity extends AppCompatActivity {

    @BindView(R.id.btnRingan)
    Button btnRingan;
    @BindView(R.id.btnBerat)
    Button btnBerat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btnRingan, R.id.btnBerat})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnRingan:
                intent = new Intent(this,RecyleActivity.class);
                intent.putExtra("penyakit","ringan");
                startActivity(intent);
                break;
            case R.id.btnBerat:
                intent = new Intent(this,RecyleActivity.class);
                intent.putExtra("penyakit","berat");
                startActivity(intent);
                break;
        }
    }
}
