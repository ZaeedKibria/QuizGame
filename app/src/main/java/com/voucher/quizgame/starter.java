package com.voucher.quizgame;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.GoogleAuthProvider;

public class starter extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main_container = inflater.inflate(R.layout.fragment_starter, container, false);
        EditText username = main_container.findViewById(R.id.enter_your_name_editbox);
        MaterialButton button = main_container.findViewById(R.id.BlueBtn);

        ImageView settings = main_container.findViewById(R.id.setting_icon);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.settings);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                Bundle bundle = new Bundle();
                String usernameStr = username.getText().toString();
                if(usernameStr != null) {
                    bundle.putString("username",usernameStr);
                    navController.navigate(R.id.welcome_screen,bundle);
                } else {
                    Toast.makeText(view.getContext(), "You did not enter your username", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_ids))
                .requestEmail()
                .build();

        GoogleSignInClient gsic = GoogleSignIn.getClient(getContext(), gso);


        MaterialButton gmailBtn = main_container.findViewById(R.id.GmailBtn);
        gmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = gsic.getSignInIntent();
                requireActivity().startActivityForResult(intent, 10);
            }
        });

        return main_container;
    }
}