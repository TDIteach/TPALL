package com.chakoujmed.tpall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StatistiqueActivity extends AppCompatActivity {
TextView tvf,tvm,tvtdi,tvtri,tvtdm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistique);
        tvf=findViewById(R.id.tauxF);
        tvm=findViewById(R.id.tauxM);
        tvtdi=findViewById(R.id.tauxTDI);
        tvtdm=findViewById(R.id.tauxTDM);
        tvtri=findViewById(R.id.tauxTRI);
        Intent intent=getIntent();
        tvf.append(Math.round(intent.getDoubleExtra("f",0))+" %");
        tvm.append(Math.round(intent.getDoubleExtra("m",0))+" %");
        tvtdi.append(Math.round(intent.getDoubleExtra("tdi",0))+" %");
        tvtri.append(Math.round(intent.getDoubleExtra("tri",0))+" %");
        tvtdm.append(Math.round(intent.getDoubleExtra("tdm",0))+" %");
    }
}