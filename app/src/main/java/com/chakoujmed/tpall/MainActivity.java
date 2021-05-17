package com.chakoujmed.tpall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

public  static  CondidatsDataBase dataBase;
EditText etNom,etPrenom;
RadioButton rbM,rbF;
Spinner spFil;
ListView lv;
Button btnAjouter,btnVider,btnAll,btnBySex,btnByFil,btnSta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spFil=findViewById(R.id.spFil);
        etNom=findViewById(R.id.etNom);
        etPrenom=findViewById(R.id.etPrenom);
        rbM=findViewById(R.id.rbM);
        rbF=findViewById(R.id.rbF);
        lv=findViewById(R.id.lvCondidats);
        btnAjouter=findViewById(R.id.btnAdd);
        btnAll=findViewById(R.id.btngetAll);
        btnByFil=findViewById(R.id.btnByFiliere);
        btnBySex=findViewById(R.id.btnBySexe);
        btnVider=findViewById(R.id.btnVider);
        btnSta=findViewById(R.id.btnStatistiques);
        btnSta.setOnClickListener(this);

        btnBySex.setOnClickListener(this);
        btnByFil.setOnClickListener(this);
        btnAll.setOnClickListener(this);
        btnAjouter.setOnClickListener(this);
        btnVider.setOnClickListener(this);


//        String[] tfil=getResources().getStringArray(R.array.filieres);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tfil);
//        spFil.setAdapter(adapter);
        dataBase= Room.databaseBuilder(this,CondidatsDataBase.class,"dbCondidat")
                .allowMainThreadQueries()
                .build();
    }

    @Override
    public void onClick(View v) {
        ArrayList<Condidat> liste;
        CondidatAdapter adapter;
        String sexe;
        int id=v.getId();
        switch (id){
            case R.id.btnAdd:
                Condidat c=new Condidat();
                 c.setNom(etNom.getText().toString());
                 c.setPrenom(etPrenom.getText().toString());
                 c.setFiliere(spFil.getSelectedItem().toString());
                  sexe=(rbF.isChecked())? "F":"M";
                 c.setSexe(sexe);
                 MainActivity.dataBase.getDaoCondidat().AddCondidat(c);
                Toast.makeText(MainActivity.this,"Condidat ajoute avec succes",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnVider:
                etPrenom.setText("");
                etNom.setText("");
                break;
            case R.id.btngetAll:

                liste=(ArrayList<Condidat>)MainActivity.dataBase.getDaoCondidat().getAll();
                 adapter=new CondidatAdapter(liste,MainActivity.this);
                lv.setAdapter(adapter);

                break;
            case R.id.btnByFiliere:
               String fil=spFil.getSelectedItem().toString();
                liste=(ArrayList<Condidat>)MainActivity.dataBase.getDaoCondidat().getByFiliere(fil);
                adapter=new CondidatAdapter(liste,MainActivity.this);
                lv.setAdapter(adapter);

                break;
            case R.id.btnBySexe:
                sexe=(rbF.isChecked())?"F":"M";
                liste=(ArrayList<Condidat>)MainActivity.dataBase.getDaoCondidat().getBySexe(sexe);
                adapter=new CondidatAdapter(liste,MainActivity.this);
                lv.setAdapter(adapter);

                break;
            case R.id.btnStatistiques:
                liste=(ArrayList<Condidat>)MainActivity.dataBase.getDaoCondidat().getAll();
                int nbF=0,nbM=0,nbTDI=0,nbTRI=0,nbTDM=0;
                int nbrCondidats=liste.size();
                for(int i=0;i< nbrCondidats;i++){
                    Condidat con=liste.get(i);
                    if(con.getSexe().compareTo("F")==0) nbF++;
                    if(con.getSexe().compareTo("M")==0) nbM++;
                    if(con.getFiliere().compareTo("TDI")==0) nbTDI++;
                    if(con.getFiliere().compareTo("TRI")==0) nbTRI++;
                    if(con.getFiliere().compareTo("TDM")==0) nbTDM++;
                }
                double tf=(double)nbF/nbrCondidats;
                double tm=(double)nbM/nbrCondidats;
                double ttdi=(double)nbTDI/nbrCondidats;
                double ttri=(double)nbTRI/nbrCondidats;
                double ttdm=(double)nbTDM/nbrCondidats;
                Intent intent=new Intent(MainActivity.this,StatistiqueActivity.class);
                intent.putExtra("f",tf*100);
                intent.putExtra("m",tm*100);
                intent.putExtra("tdi",ttdi*100);
                intent.putExtra("tri",ttri*100);
                intent.putExtra("tdm",ttdm*100);
                startActivity(intent);
                break;

        }


    }
}