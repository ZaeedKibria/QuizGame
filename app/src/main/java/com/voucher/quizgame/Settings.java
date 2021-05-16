package com.voucher.quizgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Settings extends Fragment {

    private SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main_cont = inflater.inflate(R.layout.fragment_settings, container, false);

        SwitchMaterial switchMaterial1 = main_cont.findViewById(R.id.Switch1);
        SwitchMaterial switchMaterial2 = main_cont.findViewById(R.id.Switch2);

        sp = getActivity().getSharedPreferences("QGSettings", Context.MODE_PRIVATE);
         SharedPreferences.Editor spe = sp.edit();

        switchMaterial1.setChecked(sp.getBoolean("XL", false));
        switchMaterial2.setChecked(sp.getBoolean("Mode", false));

        switchMaterial1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    requireActivity().setTheme(R.style.Theme_QuizGame_XL);
                    spe.putBoolean("XL", b);
                    spe.apply();

                } else {
                    requireActivity().setTheme(R.style.Theme_QuizGame_Normal);
                    spe.putBoolean("XL", b);
                    spe.apply();
                }
            }
        });

        switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    spe.putBoolean("Mode",b);
                    spe.apply();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    spe.putBoolean("Mode",b);
                    spe.apply();
                }
            }
        });

        return main_cont;
    }
}