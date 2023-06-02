package com.programminghut.realtime_object;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanningActivity extends AppCompatActivity {

    String product_id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanningactivity);

        // Création de l'objet IntentIntegrator pour la numérisation
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("For flash use volume up key");
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(Capture.class);

        // Lancement du processus de numérisation dès que l'activité est créée
        intentIntegrator.initiateScan();
    }

    // Méthode appelée lorsque le résultat de la numérisation est obtenu
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Récupération du résultat de la numérisation à partir de IntentResult
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        product_id = intentResult.getContents();

        // Création de l'intention pour démarrer l'activité ScanActivity
        Intent intent = new Intent(com.programminghut.realtime_object.ScanningActivity.this, ScanActivity.class);
        intent.putExtra("TextView", product_id);

        // Démarrage de l'activité ScanActivity
        startActivity(intent);
    }
}
