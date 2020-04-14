package com.example.listviewandadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class Table extends AppCompatActivity {
    SeekBar seekBar;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        seekBar=findViewById(R.id.seekBar1);
        seekBar.setMin(1);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              //  Toast.makeText(Table.this, "Current selection is : " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Table.this, "Select value from 1 upto 20", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Table.this, "Current : " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
                populate(seekBar.getProgress());
            }
        });
    }
    private void populate(int table){
    lv=findViewById(R.id.listView1);
        ArrayList<String> mul=new ArrayList<>();
        for(int i=1; i<14; i++){
            mul.add(table + " X " + i + " = " + table * i);
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,mul);
        lv.setAdapter(arrayAdapter);

    }
}
