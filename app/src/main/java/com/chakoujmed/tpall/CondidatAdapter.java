package com.chakoujmed.tpall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CondidatAdapter extends BaseAdapter {
    ArrayList<Condidat> listeCondidats;
    Context ctx;
    LayoutInflater inflater;

    public CondidatAdapter(ArrayList<Condidat> listeCondidats, Context ctx) {
        this.listeCondidats = listeCondidats;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return listeCondidats.size();
    }

    @Override
    public Condidat getItem(int position) {
        return listeCondidats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listeCondidats.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      Condidat condidat=listeCondidats.get(position);
        if(convertView==null){
            inflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.ligne_condidat,parent,false);
        }
       TextView tvNom= convertView.findViewById(R.id.tvNom);
        TextView tvPrenom=convertView.findViewById(R.id.tvPrenom);
        TextView tvFil=convertView.findViewById(R.id.tvFil);
        TextView tvSexe=convertView.findViewById(R.id.tvSexe);
        tvNom.setText(condidat.getNom());
        tvPrenom.setText(condidat.getPrenom());
        tvSexe.setText(condidat.getSexe());
        tvFil.setText(condidat.getFiliere());

        return convertView;
    }
}
