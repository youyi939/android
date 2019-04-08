package com.example.youyi.listview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.youyi.listview2.MainActivity.bookList;

public class add_Book extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__book);
        Button return_button = findViewById(R.id.return_main);
        Button save_button = findViewById(R.id.save_book);
        final EditText new_book_ID = findViewById(R.id.new_book_id);
        final EditText new_book_name  = findViewById(R.id.new_book_name);
        final EditText new_book_price = findViewById(R.id.new_book_price);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = String.valueOf(new_book_price.getText());
                if (number.contains(".")){
                    Book book = new Book(new_book_ID.getText().toString(),new_book_name.getText().toString(),Double.valueOf(new_book_price.getText().toString()));
                    bookList.add(book);
                    Toast.makeText(add_Book.this,"添加成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(add_Book.this,MainActivity.class);
                    startActivity(intent);
                }else if (new_book_name.getText().toString().equals("") ||
                        new_book_ID.getText().toString().equals("")||
                        new_book_price.getText().toString().equals("")
                        ){
                    Toast.makeText(add_Book.this,"添加不得为空",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(add_Book.this,"price添加到小数点后一位",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_Book.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
