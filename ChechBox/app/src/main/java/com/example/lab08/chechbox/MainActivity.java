package com.example.lab08.chechbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	/* Adem YILMAZ
  adem2817@gmail.com
  İstanbul 2018
   */


    Button btnGonder;
    CheckBox tiyatro,sinema,futbol,yuzme;
    EditText ad;
    public RadioGroup SecimRadioGroup;
    public RadioButton secimRadioButton;
    String secilenString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGonder = findViewById(R.id.buttonGonder);
        tiyatro = findViewById(R.id.checkBoxTiyatro);
        sinema = findViewById(R.id.checkBoxSinema);
        futbol = findViewById(R.id.checkBoxFutbol);
        yuzme = findViewById(R.id.checkBoxYuzme);
        ad = findViewById(R.id.editAd);



        //checkbox için kodlanan kısım
        yuzme.setChecked(true);

        yuzme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "yuzme seçildi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tiyatro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "tiyatro seçildi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        futbol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "futbol seçildi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sinema.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "sinema seçildi", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //buraya kadar




        //radiobuton için kodlanan kısım
        SecimRadioGroup = findViewById(R.id.cinsiyet);
        SecimRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                secimRadioButton = findViewById(checkedId);
                secilenString = secimRadioButton.getText()+"";

                Toast.makeText(MainActivity.this, secilenString, Toast.LENGTH_SHORT).show();

            }
        });

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secimRadioButton = findViewById(SecimRadioGroup.getCheckedRadioButtonId());
                secilenString = secimRadioButton.getText().toString();
                Toast.makeText(MainActivity.this, secilenString, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder pencere = new AlertDialog.Builder(MainActivity.this);
                pencere.setTitle("Bilgiler");
                pencere.setMessage("Bilgileri onaylıyor musunuz");
                pencere.setNeutralButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Onaylandı", Toast.LENGTH_SHORT).show();
                    }
                });
                pencere.show();

            }
        });




        //buraya kadar




    }
}
