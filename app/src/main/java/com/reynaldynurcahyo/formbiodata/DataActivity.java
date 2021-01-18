package com.reynaldynurcahyo.formbiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DataActivity extends AppCompatActivity {

    private String title = "Data";

    TextView tvNama, tvTtl, tvAlamat, tvPekerjaan, tvJenkel, tvAgama, tvStatus;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        setTitle(title);

        tvNama = findViewById(R.id.bd_nama);
        tvTtl = findViewById(R.id.bd_ttl);
        tvJenkel = findViewById(R.id.bd_jenkel);
        tvAlamat = findViewById(R.id.bd_alamat);
        tvAgama = findViewById(R.id.bd_agama);
        tvStatus = findViewById(R.id.bd_statuskawin);
        tvPekerjaan = findViewById(R.id.bd_pekerjaan);

        getIntentData();
    }

    private void getIntentData() {
        Biodata biodata = getIntent().getParcelableExtra("EXTRA_BIODATA");
        String intNama = biodata.getNama();
        String intTtl = biodata.getTtl();
        String intJenkel = biodata.getJenkel();
        String intAlamat = biodata.getAlamat();
        String intAgama = biodata.getAgama();
        String intStatusKawin = biodata.getSk();
        String intPekerjaan = biodata.getPekerjaan();

        setIntentData(intNama, intTtl, intJenkel, intAlamat, intAgama, intStatusKawin, intPekerjaan);
    }

    private void setIntentData(String intNama, String intTtl, String intJenkel,
                               String intAlamat, String intAgama, String intStatusKawin,
                               String intPekerjaan) {
        tvNama.setText(intNama);
        tvTtl.setText(intTtl);
        tvJenkel.setText(intJenkel);
        tvAlamat.setText(intAlamat);
        tvAgama.setText(intAgama);
        tvStatus.setText(intStatusKawin);
        tvPekerjaan.setText(intPekerjaan);
    }
}