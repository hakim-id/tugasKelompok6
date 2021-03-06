package org.d3ifcool.zeitplannew;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.d3ifcool.zeitplannew.data.JadwalContract;

import maes.tech.intentanim.CustomIntent;

public class FragmentSchedule extends Fragment {

    public FragmentSchedule() {}

    Context appContext = MainActivity.getContextOfApplication();

    Button btnSenin, btnSelasa, btnRabu, btnKamis, btnJumat, btnSabtu, btnMinggu;
    FloatingActionButton fab;

    String cursorHari;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule,container,false);

        fab = view.findViewById(R.id.fab);

        btnSenin = view.findViewById(R.id.button_senin);
        btnSelasa = view.findViewById(R.id.button_selasa);
        btnRabu = view.findViewById(R.id.button_rabu);
        btnKamis = view.findViewById(R.id.button_kamis);
        btnJumat = view.findViewById(R.id.button_jumat);
        btnSabtu = view.findViewById(R.id.button_sabtu);
        btnMinggu = view.findViewById(R.id.button_minggu);

        btnSenin.setEnabled(false);
        btnSenin.setBackgroundColor(Color.LTGRAY);
        btnSelasa.setEnabled(false);
        btnSelasa.setBackgroundColor(Color.LTGRAY);
        btnRabu.setEnabled(false);
        btnRabu.setBackgroundColor(Color.LTGRAY);
        btnKamis.setEnabled(false);
        btnKamis.setBackgroundColor(Color.LTGRAY);
        btnJumat.setEnabled(false);
        btnJumat.setBackgroundColor(Color.LTGRAY);
        btnSabtu.setEnabled(false);
        btnSabtu.setBackgroundColor(Color.LTGRAY);
        btnMinggu.setEnabled(false);
        btnMinggu.setBackgroundColor(Color.LTGRAY);

        readData();

        btnSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,ScheduleActivity.class);
                intent.putExtra("hari","Senin");
                startActivity(intent);
                CustomIntent.customType(getContext(),"left-to-right");
            }
        });

        btnSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,ScheduleActivity.class);
                intent.putExtra("hari","Selasa");
                startActivity(intent);
                CustomIntent.customType(getContext(),"left-to-right");
            }
        });

        btnRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,ScheduleActivity.class);
                intent.putExtra("hari","Rabu");
                startActivity(intent);
                CustomIntent.customType(getContext(),"left-to-right");
            }
        });

        btnKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,ScheduleActivity.class);
                intent.putExtra("hari","Kamis");
                startActivity(intent);
                CustomIntent.customType(getContext(),"left-to-right");
            }
        });

        btnJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,ScheduleActivity.class);
                intent.putExtra("hari","Jumat");
                startActivity(intent);
                CustomIntent.customType(getContext(),"left-to-right");
            }
        });

        btnSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,ScheduleActivity.class);
                intent.putExtra("hari","Sabtu");
                startActivity(intent);
                CustomIntent.customType(getContext(),"left-to-right");
            }
        });

        btnMinggu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,ScheduleActivity.class);
                intent.putExtra("hari","Minggu");
                startActivity(intent);
                CustomIntent.customType(getContext(),"left-to-right");
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext,AddActivity.class);
                startActivity(intent);
                CustomIntent.customType(getContext(),"bottom-to-up");
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        btnSenin.setEnabled(false);
        btnSenin.setBackgroundColor(Color.LTGRAY);
        btnSelasa.setEnabled(false);
        btnSelasa.setBackgroundColor(Color.LTGRAY);
        btnRabu.setEnabled(false);
        btnRabu.setBackgroundColor(Color.LTGRAY);
        btnKamis.setEnabled(false);
        btnKamis.setBackgroundColor(Color.LTGRAY);
        btnJumat.setEnabled(false);
        btnJumat.setBackgroundColor(Color.LTGRAY);
        btnSabtu.setEnabled(false);
        btnSabtu.setBackgroundColor(Color.LTGRAY);
        btnMinggu.setEnabled(false);
        btnMinggu.setBackgroundColor(Color.LTGRAY);

        readData();
    }

    private void readData(){
        String[] projection = {JadwalContract.JadwalEntry.COLUMN_HARI};
        Cursor cursor = appContext.getContentResolver().query(JadwalContract.JadwalEntry.CONTENT_URI,projection,null, null,null);
        while (cursor.moveToNext()){
            cursorHari = cursor.getString(cursor.getColumnIndex(JadwalContract.JadwalEntry.COLUMN_HARI));
            if (cursorHari!=null){
                if (cursorHari.equals("Senin")){
                    btnSenin.setEnabled(true);
                    btnSenin.setBackgroundResource(R.drawable.shadow);
                }else if (cursorHari.equals("Selasa")){
                    btnSelasa.setEnabled(true);
                    btnSelasa.setBackgroundResource(R.drawable.shadow);
                }else if (cursorHari.equals("Rabu")){
                    btnRabu.setEnabled(true);
                    btnRabu.setBackgroundResource(R.drawable.shadow);
                }else if (cursorHari.equals("Kamis")){
                    btnKamis.setEnabled(true);
                    btnKamis.setBackgroundResource(R.drawable.shadow);
                }else if (cursorHari.equals("Jumat")){
                    btnJumat.setEnabled(true);
                    btnJumat.setBackgroundResource(R.drawable.shadow);
                }else if (cursorHari.equals("Sabtu")){
                    btnSabtu.setEnabled(true);
                    btnSabtu.setBackgroundResource(R.drawable.shadow);
                }else if (cursorHari.equals("Minggu")){
                    btnMinggu.setEnabled(true);
                    btnMinggu.setBackgroundResource(R.drawable.shadow);
                }
            }
        }
        cursor.close();
    }
}
