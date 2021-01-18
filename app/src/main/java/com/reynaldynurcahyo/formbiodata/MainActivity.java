package com.reynaldynurcahyo.formbiodata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private String title = "Form";

    EditText edtNama, edtTtl, edtAlamat, edtPekerjaan;
    Spinner spnJenkel, spnAgama, spnStatus;
    Button btnSubmit;

    String[] jenkel= {
            "Laki-Laki",
            "Perempuan"
    };

    String[] agama = {
            "Islam",
            "Kristen",
            "Hindu",
            "Buddha",
    };

    String[] statusKawin = {
            "Belum Kawin",
            "Menikah"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(title);

        edtNama = findViewById(R.id.nama);
        edtTtl = findViewById(R.id.ttl);
        edtAlamat = findViewById(R.id.alamat);
        edtPekerjaan = findViewById(R.id.pekerjaan);

        spnJenkel = findViewById(R.id.jenkel);
        spnJenkel.setOnItemSelectedListener(this);

        spnAgama = findViewById(R.id.agama);
        spnAgama.setOnItemSelectedListener(this);

        spnStatus = findViewById(R.id.statuskawin);
        spnStatus.setOnItemSelectedListener(this);

        btnSubmit = findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);

        setArrayAdapter();
    }

    private void setArrayAdapter() {
        ArrayAdapter arrJenkel = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, jenkel);
        ArrayAdapter arrAgama = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, agama);
        ArrayAdapter arrStatusKawin = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, statusKawin);

        arrJenkel.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        arrAgama.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        arrStatusKawin.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spnJenkel.setAdapter(arrJenkel);
        spnAgama.setAdapter(arrAgama);
        spnStatus.setAdapter(arrStatusKawin);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            String inputNama = edtNama.getText().toString().trim();
            String inputTtl = edtTtl.getText().toString().trim();
            String inputAlamat = edtAlamat.getText().toString().trim();
            String inputPekerjaan = edtPekerjaan.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputNama)) {
                isEmptyFields = true;
                edtNama.setError("Field ini tidak boleh kosong!");
            }

            if (TextUtils.isEmpty(inputTtl)) {
                isEmptyFields = true;
                edtTtl.setError("Field ini tidak boleh kosong!");
            }

            if (TextUtils.isEmpty(inputAlamat)) {
                isEmptyFields = true;
                edtAlamat.setError("Field ini tidak boleh kosong!");
            }

            if (TextUtils.isEmpty(inputPekerjaan)) {
                isEmptyFields = true;
                edtPekerjaan.setError("Field ini tidak boleh kosong!");
            }

            if (!isEmptyFields) {
                Biodata biodata = new Biodata();
                biodata.setNama(String.valueOf(edtNama.getText()));
                biodata.setTtl(String.valueOf(edtTtl.getText()));
                biodata.setJenkel(String.valueOf(spnJenkel.getSelectedItem()));
                biodata.setAlamat(String.valueOf(edtAlamat.getText()));
                biodata.setAgama(String.valueOf(spnAgama.getSelectedItem()));
                biodata.setSk(String.valueOf(spnStatus.getSelectedItem()));
                biodata.setPekerjaan(String.valueOf(edtPekerjaan.getText()));

                Intent submit = new Intent(this, DataActivity.class);
                submit.putExtra("EXTRA_BIODATA", biodata);

                startActivity(submit);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}