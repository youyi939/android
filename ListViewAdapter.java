package com.example.youyi.listview;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter {
    private int resourceId;
    private Context context;
    public  List<Book>books;
    public ListViewAdapter(Context context, int textViewResourceId, List<Book> objects){
        super(context,textViewResourceId,objects);
        this.resourceId = textViewResourceId;
        this.books = objects;
        this.context = context;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        final Book book = (Book) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        final TextView bookPrice = view.findViewById(R.id.book_price);                    //实例化price属性
        final TextView bookName = view.findViewById(R.id.book_name);                      //实例化name属性
        final TextView bookId = view.findViewById(R.id.book_id);                          //实例化ID属性

        bookPrice.setText(String.valueOf(book.getPrice()));
        bookName.setText(book.getName());
        bookId.setText(book.getId());

        bookPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                           //TextView的点击事件
                Toast.makeText(context, bookPrice.getText(), Toast.LENGTH_SHORT).show();
                Log.d("MainActivity","正在点击Book price");
            }
        });
        bookId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,bookId.getText(),Toast.LENGTH_SHORT).show();
                Log.d("MainActivity","正在点击Book ID");
            }
        });
        bookName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,bookName.getText(),Toast.LENGTH_SHORT).show();
                Log.d("MainActivity","正在点击Book Name");
            }
        });

        Button removeButton = view.findViewById(R.id.delete_list);              //实例化删除按钮
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {               //给删除按钮设置点击事件
                books.remove(book);
                notifyDataSetChanged();
            }
        });
        Button modifyButton = view.findViewById(R.id.book_xiugai);
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                books.remove(book);
                Intent intent = new Intent();
                intent.setClass(getContext(),Modify.class);
                getContext().startActivities(new Intent[]{intent});
                notifyDataSetChanged();
            }
        });
        return view;
    }
}