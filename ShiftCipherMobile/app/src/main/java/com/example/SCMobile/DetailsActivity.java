package com.example.SCMobile;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caesarcb.R;

import java.util.Timer;
import java.util.TimerTask;

public class DetailsActivity extends AppCompatActivity {

Button bSCode,bLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        bSCode= findViewById(R.id.scode);
        bLink = findViewById(R.id.scode2);

        bSCode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/BNorelden/Shift-Cipher-Mobile"));
                startActivity(intent);
            }
        });

        bLink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Soruce Code Link", "https://github.com/BNorelden/Shift-Cipher-Mobile");
                        clipboard.setPrimaryClip(clip);
                         Toast.makeText(DetailsActivity.this, "Link Copied", Toast.LENGTH_SHORT).show();
            }
        });


    }



}



