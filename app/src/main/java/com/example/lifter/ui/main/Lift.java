package com.example.lifter.ui.main;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lifter.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Lift extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SoundPool sp;
    Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Lift() {
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
    public static Lift newInstance(String param1, String param2) {
        Lift fragment = new Lift();
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

        SimpleDateFormat formatter = new SimpleDateFormat(("dd_MM_yyyy"), Locale.ENGLISH);
        Date now = new Date();
        String filename = formatter.format(now)+ ".txt";

        File file = new File(Environment.getExternalStorageDirectory() +
                File.separator + filename);



        try {

            int permissionCheck = ContextCompat.checkSelfPermission(
                    getContext(),
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (file.exists()) {
                    OutputStream fo = new FileOutputStream(filename);



                    RelativeLayout include1 = getView().findViewById(R.id.include1);

                    for (int i = 0; i < include1.getChildCount(); i++) {
                        TextView text = (TextView) include1.getChildAt(i);
                        fo.write(text.getText().toString().getBytes());
                        fo.write("-".getBytes());
                    }

                    fo.write("\n".getBytes());

                    RelativeLayout include2 = getView().findViewById(R.id.include2);

                    for (int i = 0; i < include2.getChildCount(); i++) {
                        TextView text = (TextView) include2.getChildAt(i);
                        fo.write(text.getText().toString().getBytes());
                        fo.write("-".getBytes());
                    }

                    fo.write("\n".getBytes());

                    RelativeLayout include3 = getView().findViewById(R.id.include3);

                    for (int i = 0; i < include3.getChildCount(); i++) {
                        TextView text = (TextView) include3.getChildAt(i);
                        fo.write(text.getText().toString().getBytes());
                        fo.write("-".getBytes());
                    }

                    fo.write("\n".getBytes());

                    RelativeLayout include4 = getView().findViewById(R.id.include4);

                    for (int i = 0; i < include4.getChildCount(); i++) {
                        TextView text = (TextView) include4.getChildAt(i);
                        fo.write(text.getText().toString().getBytes());
                        fo.write("-".getBytes());
                    }

                    fo.write("\n".getBytes());

                    RelativeLayout include5 = getView().findViewById(R.id.include5);

                    for (int i = 0; i < include5.getChildCount(); i++) {
                        TextView text = (TextView) include5.getChildAt(i);
                        fo.write(text.getText().toString().getBytes());
                        fo.write("-".getBytes());
                    }

                    fo.write("\n\n".getBytes());

                    fo.close();

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}