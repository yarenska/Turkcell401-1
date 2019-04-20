package com.example.asuss.turkcell401.com.example.asuss.turkcell401.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asuss.turkcell401.R;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.adaptors.KisiListAdapter;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.models.Kisi;

import java.util.ArrayList;

public class KisiFragment extends Fragment {
    final private ArrayList<Kisi> kisiler = new ArrayList<Kisi>();
    private OnFragmentInteractionListener mListener;

    public KisiFragment(){
        Log.i("Constructor","Constructor");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kisi_fragment, container, false);
        kisiler.add(new Kisi(R.drawable.avatar,"Ali Güneş","Mühendis"));
        kisiler.add(new Kisi(R.drawable.avatar2,"Melis Çıkış","Öğrenci"));
        kisiler.add(new Kisi(R.drawable.avatar3,"Özlem Güneş","Hemşire"));
        kisiler.add(new Kisi(R.drawable.avatar6,"Ali Yıldız","Emekli"));

        ListView kisiListView = (ListView)view.findViewById(R.id.listViewKisi);
        KisiListAdapter kisiListAdapter = new KisiListAdapter(getLayoutInflater(),kisiler);
        kisiListView.setAdapter(kisiListAdapter);

        /*kisiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);
    }
}
