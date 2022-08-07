package com.example.angka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

import android.view.*;
import android.widget.*;
import java.util.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //deklarasi
    Button btnTebak;
    EditText etAngka;
    int angkaRandom  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTebak = (Button) findViewById(R.id.btnTebak);
        etAngka = (EditText) findViewById(R.id.etAngka);
        angkaRandom = buatAngkaRandom(1,3);
        btnTebak.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view){
            if (!etAngka.equals("")) {
                tebakAngka();
            }
        }

        });
    }

    private void tebakAngka(){
        int angkaTebakan = Integer.parseInt(etAngka.getText().toString());
        if(angkaTebakan == angkaRandom){
            tampilkanPopup("Tebakan Anda Benar");
        }else{
            tampilkanPopup("Tebakan Anda salah");
        }
        angkaRandom = buatAngkaRandom(1,3);

    }
    private int buatAngkaRandom(int angkaMin, int angkaMax){
        Random rand = new Random();
        int randomNum = rand.nextInt(angkaMax - angkaMin) + angkaMin;
        return randomNum;

    }
    private  void tampilkanPopup(String pesan){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(pesan +" jawaban: " +angkaRandom).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                etAngka.setText("");
            }
        });
        //create AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}