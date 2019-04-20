package com.example.asuss.turkcell401.com.example.asuss.turkcell401.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asuss.turkcell401.R;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.models.Kisi;

import java.util.ArrayList;

public class KisiListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Kisi> kisiler;

    public KisiListAdapter(LayoutInflater layoutInflater, ArrayList<Kisi> kisiler){
        this.layoutInflater = layoutInflater;
        this.kisiler = kisiler;
    }

    @Override
    public int getCount() {
        return kisiler.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View kisiView = layoutInflater.inflate(R.layout.kisi_satir, null);
        ImageView kisiImage = (ImageView)kisiView.findViewById(R.id.imageView2);
        TextView kisiName = (TextView)kisiView.findViewById(R.id.textView3);
        TextView kisiJob = (TextView)kisiView.findViewById(R.id.textView4);

        Kisi myKisi = kisiler.get(position);
        kisiImage.setImageResource(myKisi.getPhotoID());
        kisiName.setText(myKisi.getName());
        kisiJob.setText(myKisi.getJob());

        return kisiView;
    }
}
