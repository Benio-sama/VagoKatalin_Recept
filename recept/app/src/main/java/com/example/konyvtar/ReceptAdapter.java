package com.example.konyvtar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ReceptAdapter extends BaseAdapter {
    private List<Recept> receptek;
    private Context context;

    public ReceptAdapter(List<Recept> receptek, Context context) {
        this.receptek = receptek;
        this.context = context;
    }

    @Override
    public int getCount() {
        return receptek.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.lista_elem, viewGroup, false);
        TextView receptview = view.findViewById(R.id.recepttextview);
        TextView minosegview = view.findViewById(R.id.minosegtextview);
        TextView nehezsegview = view.findViewById(R.id.nehezsegtextview);
        Button torles = view.findViewById(R.id.torles);
        receptview.setText("Recept: " + receptek.get(position).getRecept());
        minosegview.setText("Minoseg: " + receptek.get(position).getMinoseg());
        nehezsegview.setText("Nehezseg: " + receptek.get(position).getNehezseg());

        torles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Torles")
                        .setMessage("Biztos torolni szeretned?")
                        .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                receptek.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Nem", null)
                        .show();
            }
        });

        return view;
    }
}
