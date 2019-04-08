package com.example.youyi.listview;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.youyi.listview.MainActivity.bookList;

public class Add_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);

        final EditText nameEditText = (EditText) findViewById(R.id.new_book_name);                  //按钮等实例化
        final EditText priceEditText = (EditText) findViewById(R.id.new_book_price);
        final EditText idEditText = (EditText) findViewById(R.id.new_book_id);
        final Button retrunButton = findViewById(R.id.return_main);
        final Button saveButton = findViewById(R.id.save_list);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                                   //保存按钮的点击事件
                String number = String.valueOf(priceEditText.getText());
                if(number.contains(".")) {
                    Book book = new Book(idEditText.getText().toString(),nameEditText.getText().toString(),Double.valueOf(priceEditText.getText().toString()));
                    bookList.add(book);
                    Intent intent = new Intent(Add_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (nameEditText.getText().toString().equals("") || priceEditText.getText().toString().equals("")
                        || idEditText.getText().toString().equals("")){
                    Toast.makeText(Add_Activity.this,"输入内容不得为空",Toast.LENGTH_SHORT).show();     //设置输入不得为空
                }else {
                    Toast.makeText(Add_Activity.this,"price请输入至小数点后一位",Toast.LENGTH_SHORT).show();
                }
            }
        });
        retrunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                               //返回主页面的点击事件
                Intent intent = new Intent(Add_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}