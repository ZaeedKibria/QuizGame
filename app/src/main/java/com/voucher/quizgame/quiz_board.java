package com.voucher.quizgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class quiz_board extends Fragment {
    private Quiz_Game quiz_game;
    private TextView question_text_view;
    private MaterialButton option1;
    private MaterialButton option2;
    private MaterialButton option3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModel_QuizBoard viewModel_quizBoard = (ViewModel_QuizBoard) new ViewModelProvider(this).get(ViewModel_QuizBoard.class);
        quiz_game = viewModel_quizBoard.getInstanceQuizGame();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main_containers = inflater.inflate(R.layout.fragment_quiz_board, container, false);
        question_text_view = main_containers.findViewById(R.id.questions);
        option1 = main_containers.findViewById(R.id.option1);
        option2 = main_containers.findViewById(R.id.option2);
        option3 = main_containers.findViewById(R.id.option3);

        ImageView settings = main_containers.findViewById(R.id.setting_icon);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.settings);
            }
        });

        nextQuestion();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz_game.SubmitAnswer(option1.getText().toString());
                nextQuestion();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz_game.SubmitAnswer(option2.getText().toString());
                nextQuestion();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz_game.SubmitAnswer(option3.getText().toString());
                nextQuestion();
            }
        });

        return main_containers;
    }

    private void nextQuestion() {
        QuizQuestion qq = quiz_game.getQuestion();
        if(qq != null) {
            question_text_view.setText(qq.getQuestion());
            option1.setText(qq.getOption1());
            option2.setText(qq.getOption2());
            option3.setText(qq.getOption3());
        } else {
            NavHostFragment.findNavController(this).navigate(R.id.result);
        }
    }
}