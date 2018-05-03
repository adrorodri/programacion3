package com.programacion3.myapplication.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.programacion3.myapplication.Model.Product;
import com.programacion3.myapplication.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adro_ on 4/17/2018.
 */

public class ProductsAdapter extends BaseAdapter{

    Context context;
    List<Product> productList = new LinkedList<>();
    LayoutInflater inflater;

    public ProductsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.layout_list_item, null);
        TextView textView = convertView.findViewById(R.id.textViewItem);
        textView.setText(productList.get(position).getDescription());

        ImageView imageView = convertView.findViewById(R.id.imageViewItem);
        imageView.setImageResource(productList.get(position).getImage());

        return convertView;
    }
}
