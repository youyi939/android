package com.example.youyi.listview2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import static com.example.youyi.listview2.MainActivity.bookList;

public class BookAdatper extends ArrayAdapter<Book> {
    private int resourceId;
    private Context context;
    public static Book book_modify;
    public BookAdatper(Context context, int resource,  List<Book> objects) {
        super(context, resource, objects);
        resourceId = resource;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        final Book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        final TextView bookId = view.findViewById(R.id.book_id);
        final TextView bookPrice = view.findViewById(R.id.book_price);
        final TextView bookName = view.findViewById(R.id.book_name);
        Button delete  = view.findViewById(R.id.delete);
        final Button modify = view.findViewById(R.id.xiugai);

        bookId.setText(String.valueOf(book.getId()));
        bookName.setText(book.getName());
        bookPrice.setText(String.valueOf(book.getPrice()));

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
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookList.remove(book);
                notifyDataSetChanged();
            }
        });
        book_modify = new Book(book.getId(),book.getName(),book.getPrice());
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),modify.class);
                getContext().startActivities(new Intent[]{intent});
                bookList.remove(book);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
