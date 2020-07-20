package com.example.lifter.ui.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lifter.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class lift extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SoundPool sp;
    Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public lift() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static lift newInstance(String param1, String param2) {
        lift fragment = new lift();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lift","onCreate invoked");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.d("lift","onCreateView invoked");

        final View lift = inflater.inflate(R.layout.fragment_lift, container, false);

        Spinner menu = lift.findViewById(R.id.spinner1);

        String[] items = new String[] {"1", "2", "3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                R.layout.support_simple_spinner_dropdown_item, items);

        menu.setAdapter(adapter);

        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0: {
                        TextView text = lift.findViewById(R.id.workout_name1);
                        text.setText("Squat");

                        text = lift.findViewById(R.id.workout_name2);
                        text.setText("Bench Press");

                        text = lift.findViewById(R.id.workout_name3);
                        text.setText("Lat Raises");

                        text = lift.findViewById(R.id.workout_name4);
                        text.setText("Bicep Curls");

                        text = lift.findViewById(R.id.workout_name5);
                        text.setText("Leg Raises");
                        break;
                    }

                    case 1: {
                        TextView text = lift.findViewById(R.id.workout_name1);
                        text.setText("Deadlift");

                        text = lift.findViewById(R.id.workout_name2);
                        text.setText("Overhead Press");

                        text = lift.findViewById(R.id.workout_name3);
                        text.setText("Incline DB Press");

                        text = lift.findViewById(R.id.workout_name4);
                        text.setText("Shrugs");

                        text = lift.findViewById(R.id.workout_name5);
                        text.setText("Cable Crunches");
                        break;
                    }

                    case 2: {
                        TextView text = lift.findViewById(R.id.workout_name1);
                        text.setText("Squat");

                        text = lift.findViewById(R.id.workout_name2);
                        text.setText("Bench Press");

                        text = lift.findViewById(R.id.workout_name3);
                        text.setText("Tricep pushdown");

                        text = lift.findViewById(R.id.workout_name4);
                        text.setText("Lateral Pulldown");

                        text = lift.findViewById(R.id.workout_name5);
                        text.setText("Plank");
                        break;
                    }
                }

                final Button button = lift.findViewById(R.id.button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonResponse(v);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;

            }
        });
        return lift;
    }

    public void buttonResponse(View view) {

        TextView text = getView().findViewById(R.id.workout_name1);
        Log.d("buttonResponse", text.getText().toString());

    }

}