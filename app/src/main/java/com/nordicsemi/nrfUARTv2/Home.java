package com.nordicsemi.nrfUARTv2;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Intent;
import java.io.UnsupportedEncodingException;

public class Home extends Activity {

    public static UartService uartService;
    public static BluetoothAdapter mBtAdapter;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button selectDevice = (Button) findViewById(R.id.selectDevice);
        selectDevice.setOnClickListener(startListener);

    }

    public void sendVolt(View view) {
        EditText editText = (EditText) findViewById(R.id.setVolt);
        String combine = editText.getText().toString();
        String voltSend = "1" + combine;
        try {
            byte[] getByte = voltSend.getBytes("UTF-8");
            uartService.writeRXCharacteristic(getByte);
        }
        catch (UnsupportedEncodingException e){
        }
    }

    public void sendAmp(View view) {
        EditText editText = (EditText) findViewById(R.id.setAmp);
        String combine = editText.getText().toString();
        String ampSend = "0" + combine;
        try {
            byte[] getByte = ampSend.getBytes("UTF-8");
            uartService.writeRXCharacteristic(getByte);
        }
        catch (UnsupportedEncodingException e){
        }
    }

    private View.OnClickListener startListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent openMainActivity= new Intent(Home.this, MainActivity.class);
            openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(openMainActivity);
        }
    };
}




