package com.example.mycontats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterCountry extends BaseAdapter {
    Context context;
    String[] names;
    int[] images;
    int i;
    LayoutInflater inflater;

    public CustomAdapterCountry(Context applicationContext, String[] names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_country, null);
        TextView name = view.findViewById(R.id.country_item_name);
        ImageView image =view.findViewById(R.id.country_item_image);
        i=position;
        name.setText(names[position]);
        image.setImageResource(images[position]);
        return view;
    }
    public int getPosition() {
        return i;
    }
}
