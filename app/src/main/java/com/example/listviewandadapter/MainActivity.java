package com.example.listviewandadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  populateList();
        generateView(populateList());
    }
    
    private ArrayList<String> populateList(){
        ArrayList<String> names=new ArrayList<>();
        names.add("Hasan");
        names.add("Ali");
        names.add("Misbah");
        names.add("Adeel");
        names.add("Asad");
        names.add("Salman");
        names.add("Sheraz");
        names.add("Bilal");
        names.add("Sharjil");
        names.add("Merchant");
        names.add("Adnan");
        names.add("Huzaifa");
        return names;
    }
    private void generateView(ArrayList<String> list){
        listView=findViewById(R.id.list1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You have selected :  " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
