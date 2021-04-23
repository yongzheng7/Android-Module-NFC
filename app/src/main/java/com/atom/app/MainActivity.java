package com.atom.app;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.NdefMessage;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atom.module.nfc.NFCActivity;
import com.atom.module.nfc.NFCListener;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String nfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final TextView viewById = findViewById(R.id.show);
        if (nfc != null) {
            viewById.setText(nfc);
        }
    }

    public void test(View view) {
        NFCActivity.start(this, (arrayMsg, values) -> {
            StringBuilder builder = new StringBuilder("NFC 显示").append('\n');
            for (Object obj : values
            ) {
                builder.append(obj.toString()).append('\n');
            }
            nfc = builder.toString();
        });
    }
}