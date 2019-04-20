package com.example.asuss.turkcell401.com.example.asuss.turkcell401.adaptors;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asuss.turkcell401.R;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.models.Diet;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DietListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Diet> dietList;

    //Normalde constructor ın ilk parametresi context'Ti. ListView için Adaptor ü çağırdığımız activity'nin context'ini veriyorduk.
    //Ve constructor'ın içinde o context'ten bir layout inflater oluşuturuyorduk.
    //Bu örnekte de direkt activity'nin içinden getLayoutInflater() olarak çağırdık.

    public DietListAdapter(LayoutInflater layoutInflater, ArrayList<Diet> dietList){
        this.layoutInflater = layoutInflater;
        this.dietList = dietList;
    }
    @Override
    public int getCount() {
        return dietList.size();
    }

    @Override
    public Object getItem(int position) {
        return dietList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //ListView'ın içine koyacağımız element'in view'ını layout dosyasından alıyoruz.
        View dietView = layoutInflater.inflate(R.layout.diet_satir, null);
        //Aldıktan sonra tek tek elementlerimizi tanımlıyoruz.
        ImageView foodPicture = (ImageView)dietView.findViewById(R.id.imageView);
        TextView foodName = (TextView)dietView.findViewById(R.id.textView);
        TextView foodCalorie = (TextView)dietView.findViewById(R.id.textView2);

        //Her bir Diet nesnesini dietList listemizden alıyoruz.
        Diet diet = dietList.get(position);
        foodPicture.setImageResource(diet.getFoodPicture());
        foodName.setText(diet.getFoodName());
        foodCalorie.setText(diet.getTotalCalorie());

        //Son olarak ListView içine koyacağımız element'in view'ını döndürüyoruz.
        return dietView;
    }
}
