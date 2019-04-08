package com.example.youyi.listview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.youyi.listview2.BookAdatper.book_modify;
import static com.example.youyi.listview2.MainActivity.bookList;

public class modify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        Button modify_return = findViewById(R.id.modify_return);
        Button modify_save = findViewById(R.id.modify_save);
        final EditText modify_id = findViewById(R.id.modify_id);
        final EditText modify_name = findViewById(R.id.modify_name);
        final EditText modify_price = findViewById(R.id.modify_price);

        modify_id.setText(book_modify.getId());
        modify_name.setText(book_modify.getName());
        modify_price.setText(book_modify.getPrice().toString());

        modify_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = String.valueOf(modify_price.getText());
                if (number.contains(".")){
                    book_modify.setName(modify_name.getText().toString());
                    book_modify.setId(modify_id.getText().toString());
                    book_modify.setPrice(Double.valueOf(modify_price.getText().toString()));
                    bookList.add(book_modify);
                    Toast.makeText(modify.this,"修改成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(modify.this,MainActivity.class);
                    startActivity(intent);
                }else if (modify_name.getText().toString().equals("") ||
                        modify_id.getText().toString().equals("")||
                        modify_price.getText().toString().equals("")
                        ){
                    Toast.makeText(modify.this,"添加不得为空",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(modify.this,"price添加到小数点后一位",Toast.LENGTH_SHORT).show();
                }
            }
        });
        modify_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(modify.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
