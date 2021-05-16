package com.voucher.quizgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class welcome_screen extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main_cont = inflater.inflate(R.layout.fragment_welcome_screen, container, false);
        TextView textView = main_cont.findViewById(R.id.welcome_username__lable);
        textView.setText(getArguments().getString("username"));

        MaterialButton starter = main_cont.findViewById(R.id.BlueBtn1);
        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.quiz_board);
            }
        });


        return main_cont;
    }
}