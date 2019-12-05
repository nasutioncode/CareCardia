package com.ghuroba.carecardia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.text.TextUtils.isEmpty;

public class CreateDiagnosaJantungActivity extends AppCompatActivity {

    private DatabaseReference database;

    private RadioGroup rdDiabetes;
    private RadioGroup rdKelamin;
    private RadioGroup rdRokok;
    private EditText etUsia;
    private EditText etTensi;
    private Spinner spinKolesterol;
    private Button btHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_diagnosa_jantung);

        // Inisialisasi
        rdDiabetes = (RadioGroup) findViewById(R.id.radio_diabetes);
        rdKelamin = (RadioGroup) findViewById(R.id.radio_kelamin);
        rdRokok = (RadioGroup) findViewById(R.id.radio_rokok);
        etUsia = (EditText) findViewById(R.id.text_usia);
        etTensi = (EditText) findViewById(R.id.text_tensi);
        spinKolesterol = (Spinner) findViewById(R.id.spinner_kolesterol);
        btHasil = (Button) findViewById(R.id.button_hasil);

        // Spinner
        final Spinner spinner = findViewById(R.id.spinner_kolesterol);

        List<String> categories = new ArrayList<>();
        categories.add(0,"Pilih jumlah kolesterol");
        categories.add("4 = 154,44");
        categories.add("5 = 193,05");
        categories.add("6 = 231,66");
        categories.add("7 = 270,27");
        categories.add("8 = 308,88");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        // Gaya drop layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (parent.getItemAtPosition(position).equals("Choose Category")) {

                    }
                    else {
                        parent.getItemAtPosition(position).toString();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        // Memanggil referensi ke firebase
        database = FirebaseDatabase.getInstance().getReference();

        btHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateDiagnosaJantungActivity.this, HasilDiagnosaJantungActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.diabetesYes:
                break;
            case R.id.diabetesNo:
                break;
            default:
                break;
        }

        switch (view.getId()) {
            case R.id.rokokYes:
                break;
            case R.id.rokokNo:
                break;
            default:
                break;
        }

        switch (view.getId()) {
            case R.id.kelaminPria:
                break;
            case R.id.kelaminWanita:
                break;
            default:
                break;
        }
    }
}


