package com.android.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.android.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonUm, buttonDois, buttonTres, buttonQuatro, buttonCinco, buttonSeis;
    private MediaPlayer mediaPlayer;


    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        buttonUm = view.findViewById(R.id.ButtonUm);
        buttonDois = view.findViewById(R.id.ButtonDois);
        buttonTres = view.findViewById(R.id.ButtonTres);
        buttonQuatro = view.findViewById(R.id.ButtonQuatro);
        buttonCinco = view.findViewById(R.id.ButtonCinco);
        buttonSeis = view.findViewById(R.id.ButtonSeis);

        buttonUm.setOnClickListener(this);
        buttonDois.setOnClickListener(this);
        buttonTres.setOnClickListener(this);
        buttonQuatro.setOnClickListener(this);
        buttonCinco.setOnClickListener(this);
        buttonSeis.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ButtonUm:
                /*
                 * queremos passar o contexto da activity. Para recuperar o contexto da activity dentro do
                 * Fragment, utilizamos o getActivity
                 * */
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;

            case R.id.ButtonDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;

            case R.id.ButtonTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;

            case R.id.ButtonQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;

            case R.id.ButtonCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;

            case R.id.ButtonSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;

        }
    }

    public void  tocarSom(){
        if( mediaPlayer!= null ){
            mediaPlayer.start();

            //permite adicionar um evento quando a musica finalizar
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //para liberar os recursos utilzados
                    mediaPlayer.release();
                }
            });
        }
    }
}
