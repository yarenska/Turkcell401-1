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
import android.widget.ListView;

import com.example.asuss.turkcell401.R;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.adaptors.DietListAdapter;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.models.Diet;

import java.util.ArrayList;

public class DietFragment extends Fragment {
    final ArrayList<Diet> dietList = new ArrayList<Diet>();
    private OnFragmentInteractionListener mListener;
    public DietFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment","onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("Fragment","onCreateView");

        // Bu dosyanın xml dosyasını inflate ediyoruz.
        View view = inflater.inflate(R.layout.diet_fragment, null);

        // Diet classının constructorına resim gönderdiğimiz zaman drawable olarak gönderince bir ID değeri gitmiş oluyor.
        dietList.add(new Diet(R.drawable.menu_3, "Yumurta, peynir, zeytin", "5000C"));
        dietList.add(new Diet(R.drawable.menu_1,"Mevsim yeşillikleri salata", "2000C"));
        dietList.add(new Diet(R.drawable.menu_2,"Badem,fındık,ceviz", "4000C"));
        dietList.add(new Diet(R.drawable.menu_4,"Kivi,çilek,muz", "1000C"));

        // Bu dosyanın içindeki ListView'ı buluyoruz.
        ListView dietListView = (ListView)view.findViewById(R.id.list_fragment_diet_listview);
        // Adaptörümüzü çağırıyoruz.(layout inflater ve ekrana basmasını istediğimiz diet list ile)
        DietListAdapter dietListAdapter = new DietListAdapter(getLayoutInflater(), dietList);
        dietListView.setAdapter(dietListAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);
    }
}
