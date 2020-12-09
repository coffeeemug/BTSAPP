package com.example.bts530;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CarsAdapter extends ArrayAdapter<Cars> {

    private Context mContext;
    private int mResource;

    public CarsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Cars> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView =layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);

        TextView carName = convertView.findViewById(R.id.carName);

        TextView carDes = convertView.findViewById(R.id.carDes);

        imageView.setImageResource(getItem(position).getImage());

        carName.setText(getItem(position).getName());

        carDes.setText(getItem(position).getDes());
        return convertView;
    }
}
