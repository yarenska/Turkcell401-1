package com.example.asuss.turkcell401;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.asuss.turkcell401.com.example.asuss.turkcell401.fragments.DietFragment;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.fragments.HealthFragment;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.fragments.HomeFragment;
import com.example.asuss.turkcell401.com.example.asuss.turkcell401.fragments.KisiFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Bu activity nin hangi xml dosyasıyla alakalı olduğunu söyler.

        //XML dosyasındaki bottom navigation ı tanımladık.
        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        // Sonra Bottom Navigation'ın listener'ına tanımladık ki butonlara bastığımızda hangi fragment'a geçecek haberi olsun.
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemsSelectedListener);

        // Default olarak ilk HomeFragment gelsin diye alttaki 3 satırı tanımladık.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//Çok merak edersen Ctrl + B
        transaction.replace(R.id.frame_layout, new HomeFragment()); //Eğer daha önce bir fragment varsa değiştir anlamına geliyor. frame_layoutu da daha önce tanmlamıştık.
        transaction.commit();

        // Transaction.commit dedikten sonra çalışır.
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemsSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch(menuItem.getItemId()){
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_health:
                    selectedFragment = new HealthFragment();
                    break;
                case R.id.navigation_diet:
                    selectedFragment = new DietFragment();
                    //selectedFragment = new KisiFragment();
                    break;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }
    };

}

//İlk önce breakpoint koyuyoruz
//Sonra Debug App diyoruz.
//F8 ile ilerliyoruz.
//F9 ile debug moddan çıkıyoruz.(olduğumuz breakpointli kısımdan)
//F10 ile tsmamen çıkıyoruz.