package com.example.youyi.listview2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Book> bookList = new ArrayList<Book>();
    private BookAdatper bookAdatper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookAdatper = new BookAdatper(MainActivity.this,R.layout.book_item,bookList);
        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(bookAdatper);
        Button button = findViewById(R.id.add_book);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,add_Book.class);
                startActivity(intent);
            }
        });

    }

}