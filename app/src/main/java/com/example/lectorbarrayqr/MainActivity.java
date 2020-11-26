package com.example.lectorbarrayqr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {

    EditText codigo;
    Button escaner;
    

    private ZXingScannerView vistaEscaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Escaner (View view){
        vistaEscaner = new ZXingScannerView(this);
        vistaEscaner.setResultHandler(new zxingsScanner());
        setContentView(vistaEscaner);
        vistaEscaner.startCamera();
    }


    class  zxingsScanner implements  ZXingScannerView.ResultHandler{


        @Override
        public void handleResult(Result rawResult) {
            String dato = rawResult.getText();
            setContentView(R.layout.activity_main);
            vistaEscaner.stopCamera();
            codigo = (EditText) findViewById(R.id.edtCodigo);
            codigo.setText(dato);

        }
    }
}