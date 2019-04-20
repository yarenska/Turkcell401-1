package com.example.asuss.turkcell401.com.example.asuss.turkcell401.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asuss.turkcell401.R;

//Bu classın xml dosyasındaki Scroll View'ı eğer yazımız çok büyükse kullanıcılar kaydırarak bakabilsin diye tanımladık.
//Eğer liste falan yaparsak da bazen Scroll View koymamız gerekebilir. Default olarak tanımlıdır aslında ListView'da.
public class HealthFragment extends Fragment {

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HealthFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.health_fragment, container, false);
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
