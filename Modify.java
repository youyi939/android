package com.example.youyi.listview;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.youyi.listview.MainActivity.bookList;

public class Modify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);


        final EditText idEditText1 = (EditText) findViewById(R.id.modify_id);
        final EditText nameEditText1 = (EditText) findViewById(R.id.modify_name);
        final EditText priceEditText1 = (EditText) findViewById(R.id.modify_price);
        final Button saveButton1 = findViewById(R.id.modify_save);
        saveButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = String.valueOf(priceEditText1.getText());
                if(number1.contains(".")) {
                    Book book = new Book(idEditText1.getText().toString(),nameEditText1.getText().toString(),Double.valueOf(priceEditText1.getText().toString()));
                    bookList.add(book);
                    Intent intent = new Intent(Modify.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (nameEditText1.getText().toString().equals("") || priceEditText1.getText().toString().equals("")
                        || idEditText1.getText().toString().equals("")){
                    Toast.makeText(Modify.this,"输入内容不得为空",Toast.LENGTH_SHORT).show();     //设置输入不得为空
                }else {
                    Toast.makeText(Modify.this,"price请输入至小数点后一位",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}