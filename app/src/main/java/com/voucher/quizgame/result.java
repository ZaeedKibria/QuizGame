package com.voucher.quizgame;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class result extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main_cont = inflater.inflate(R.layout.fragment_result, container, false);
        TextView scoreTextView = main_cont.findViewById(R.id.score);
        scoreTextView.setText(String.valueOf(Quiz_Game.getInstance().getPointScore()) + "/" + String.valueOf(Quiz_Game.getInstance().getTotalNumberOfQuestion()));

        ImageView settings = main_cont.findViewById(R.id.setting_icon);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.settings);
            }
        });

        return main_cont;
    }

    public void BackPressedButton() {
        Log.d("Works", "BackPressedButton: Works ");
    }
}