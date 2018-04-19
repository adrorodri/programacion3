package com.programacion3.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by adro_ on 4/19/2018.
 */

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductsViewHolder> {

    Context context;
    List<Product> productList;
    LayoutInflater inflater;

    public ProductsRecyclerAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayout = inflater.inflate(R.layout.layout_list_item, null);
        return new ProductsViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.textView.setText(productList.get(position).getDescription());
        holder.imageView.setImageResource(productList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public ProductsViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewItem);
            imageView = itemView.findViewById(R.id.imageViewItem);
        }
    }
}
