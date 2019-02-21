package com.android.aprendaingles.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.aprendaingles.Fragments.BichosFragment;
import com.android.aprendaingles.Fragments.NumerosFragment;
import com.android.aprendaingles.Fragments.VogaisFragment;
import com.android.aprendaingles.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configurações para ActionBar
        //setElevation(0) remove a sombra
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Aprenda Inglês");

        smartTabLayout = findViewById(R.id.smartTabLayoutId);
        viewPager = findViewById(R.id.viewpager);

        //primeiro configuramos o adaptar
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(

                //primeiro parametro - precisamos passar nosso objeto que faz o gerenciamento dos Fragments
                getSupportFragmentManager(),

                //segundo parametro - vamos utilizar essa classe para fazer a configuração dos itens
                FragmentPagerItems.with(this)

                        //adicionando os fragments
                        .add("Bichos", BichosFragment.class)
                        .add("Numeros", NumerosFragment.class)
                        .add("Vogais", VogaisFragment.class)
                        .create()

        );

        //configurando o adapter
        viewPager.setAdapter( adapter );

        //passando viewPager para smartTabLayout
        smartTabLayout.setViewPager( viewPager );
    }
}
