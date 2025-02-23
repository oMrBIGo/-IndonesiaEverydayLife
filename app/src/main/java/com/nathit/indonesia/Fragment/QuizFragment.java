package com.nathit.indonesia.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nathit.indonesia.Activity.MainActivity;
import com.nathit.indonesia.Activity.QuizListenActivity;
import com.nathit.indonesia.Model.QuizListenModel;
import com.nathit.indonesia.R;

import java.util.ArrayList;
import java.util.List;

public class QuizFragment extends Fragment {

    public QuizFragment() {
        // Required empty public constructor
    }

    FirebaseAuth authProfile;
    FirebaseUser firebaseUser;
    private String selectedName = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        authProfile = FirebaseAuth.getInstance();
        firebaseUser = authProfile.getCurrentUser();

        Button Btn_QuizRead = (Button) view.findViewById(R.id.Btn_QuizRead);
        Button Btn_QuizListen = (Button) view.findViewById(R.id.Btn_QuizListen);
        Button Btn_QuizPicture = (Button) view.findViewById(R.id.Btn_QuizPicture);

        Btn_QuizRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        Btn_QuizListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedName = "แบบฝึกหัดฟังเสียงคำศัพท์";
                Intent intent = new Intent(getContext(), QuizListenActivity.class);
                intent.putExtra("selectedTopic", selectedName);
                startActivity(intent);
                getActivity().finish();
            }
        });

        Btn_QuizPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}