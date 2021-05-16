package com.voucher.quizgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount googleSignInAccount = task.getResult(ApiException.class);
                assert googleSignInAccount != null;

                Bundle bundle = new Bundle();
                bundle.putString("username",googleSignInAccount.getDisplayName());
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.welcome_screen, bundle);

            } catch (ApiException ex) {
                Toast.makeText(this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("QGSettings", Context.MODE_PRIVATE);

        if(sharedPreferences.getBoolean("Mode", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        if(sharedPreferences.getBoolean("XL", false)) {
            setTheme(R.style.Theme_QuizGame_XL);
        } else {
            setTheme(R.style.Theme_QuizGame_Normal);
        }
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        for(Fragment fs : fragmentList) {
            if(!fs.isDetached()) {
                Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.starter);
                Quiz_Game.getInstance().purgeInstance();
                return;
            }
        }

        super.onBackPressed();
    }
}