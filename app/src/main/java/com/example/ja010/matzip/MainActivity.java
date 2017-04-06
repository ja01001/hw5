package com.example.ja010.matzip;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<data> store = new ArrayList<>();
    ArrayList<String> CONNECT_LIST = new ArrayList<>();

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListview();

    }
    public void onClick(View v){
        Intent i  = new Intent(this,Main2Activity.class);
        startActivity(i);
    }
    public void setListview(){
        listview =(ListView)findViewById(R.id.listview);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("취소?").setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                        CONNECT_LIST.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dig.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"원상태로.",Toast.LENGTH_SHORT).show();
                    }
                });
                dig.show();


                return false;
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent j = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(j);
            }
        });
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,CONNECT_LIST);

        listview.setAdapter(adapter);


    }

}