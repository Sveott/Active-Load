package com.nordicsemi.nrfUARTv2;

import android.app.Activity;
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
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Home extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button selectDevice = (Button) findViewById(R.id.selectDevice);
        selectDevice.setOnClickListener(startListener);
    }

private View.OnClickListener startListener = new View.OnClickListener() {
    public void onClick(View v) {
        Intent i = new Intent(Home.this, MainActivity.class);
        startActivity(i);
    }
};
}



