package com.example.asuss.turkcell401.com.example.asuss.turkcell401.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asuss.turkcell401.R;

//Database den veri çekmek istediğim zaman onAttach e ya da onCreate e yazabilirim.
//onAttach - onCreate - onCreateView
//Emre Altunbilek eğitim Youtube

public class HomeFragment extends Fragment {

    EditText userWeightEt;
    EditText userLengthEt;
    TextView userResultTv;
    Button calculateBtn;

    private OnFragmentInteractionListener mListener;

    public HomeFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        userWeightEt = (EditText)view.findViewById(R.id.home_fragment_user_weight_et);
        userLengthEt = (EditText)view.findViewById(R.id.home_fragment_user_length_et);
        userResultTv = (TextView) view.findViewById(R.id.home_fragment_result_tv);

        calculateBtn = (Button)view.findViewById(R.id.home_fragment_calculate_btn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        return view;
    }

    private void calculate() {
        float userWeight = Float.parseFloat(userWeightEt.getText().toString());
        float userLength = Float.parseFloat(userLengthEt.getText().toString());
        if(userLength > 0){
            userLength = userLength/100;
        float result = (userWeight /(userLength*userLength));

        String resultDescription = "";

        if(result < 15){
            resultDescription = "Aşırı zayıf";
        }
        else if(result > 15 && result <= 30){ resultDescription = "Zayıf"; }
        else if(result > 30 && result <= 40){ resultDescription = "Normal"; }
        else if(result > 40 ){ resultDescription = "Aşırı Kilolu"; }
        userResultTv.setText("Vücut kitle endeksiniz: " + result + "\n" + resultDescription);

        }

        else{
            final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Hata!");
            builder.setMessage("Kilo ya da boy boş bırakılamaz.");
            builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.show();

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    //Fragment ilk oluştuğu zaman çağrılır.

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    //Fragment bitirildiği zaman çağrılır.

    //onDetach te null yapmak için tanımladık. Tanımlamasak da çalışır diye düşünüyoruz. :D
    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);
    }
}
