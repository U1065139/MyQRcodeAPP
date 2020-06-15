package com.example.myqrcodeapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private EditText edtInputText;
    private ImageView imgQRcode;
    private Button btnQRcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInputText = findViewById(R.id.edtInputText);
        imgQRcode = findViewById(R.id.imgQRcode);
        btnQRcode = findViewById(R.id.btnQRcode);

        btnQRcode.setOnClickListener(btn_qrcode);

    }
    private Button.OnClickListener btn_qrcode = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            getCode(v);
        }
    };
    public void getCode(View v){
        BarcodeEncoder encoder = new BarcodeEncoder();
        try {
            Bitmap bit = encoder.encodeBitmap(edtInputText.getText().toString(),
                    BarcodeFormat.QR_CODE,
                    250,250);
            imgQRcode.setImageBitmap(bit);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
