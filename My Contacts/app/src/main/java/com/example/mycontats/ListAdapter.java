package com.example.mycontats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context applicationContext, ArrayList<User> users) {
        super(applicationContext, R.layout.item_contact, users);
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        User user =getItem(position);
        view = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, null);
        TextView PersonName = (TextView) view.findViewById(R.id.PersonName);
        ImageView PersonImage = (ImageView) view.findViewById(R.id.personImage);
        TextView PersonNumber = (TextView) view.findViewById(R.id.PersonNumber);
        TextView PersonType = (TextView) view.findViewById(R.id.PersonType);
        PersonName.setText(user.name);
        PersonImage.setImageResource(user.imageId);
        PersonNumber.setText(user.number);
        PersonType.setText(user.type);
        return view;
    }


}