package com.example.youyi.listview;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListViewAdapter listViewAdapter;
    public static List<Book> bookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.add_list);
        listViewAdapter = new ListViewAdapter(MainActivity.this,R.layout.goods,bookList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(listViewAdapter);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Add_Activity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {                  //item的点击事件
                Book book =  bookList.get(position);
                Toast.makeText(MainActivity.this,book.getId()+book.getName()+book.getPrice(),Toast.LENGTH_SHORT).show();
                Log.d("MainActivity","正在点击item");
            }
        });
    }

}
