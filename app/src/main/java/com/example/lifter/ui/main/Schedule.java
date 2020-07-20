package com.example.lifter.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifter.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Schedule#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Schedule extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    CalendarView calender;
    TextView date_view;

    public Schedule() {
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
    public static Schedule newInstance(String param1, String param2) {
        Schedule fragment = new Schedule();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View schedule = inflater.inflate(R.layout.fragment_schedule, container, false);
        calender = (CalendarView)
                schedule.findViewById(R.id.calender);
        date_view = (TextView)
                schedule.findViewById(R.id.date_view);

        // Add Listener in calendar
        calender.setOnDateChangeListener(new CalendarView
                .OnDateChangeListener() {
            @Override

            // In this Listener have one method
            // and in this method we will
            // get the value of DAYS, MONTH, YEARS
            public void onSelectedDayChange(
                    @NonNull CalendarView view,
                    int year,
                    int month,
                    int dayOfMonth) {

                // Store the value of date with
                // format in String type Variable
                // Add 1 in month because month
                // index is start with 0
                String Date
                        = dayOfMonth + "-"
                        + (month + 1) + "-" + year;

                // set this date in TextView for Display
                date_view.setText(Date);
            }
        });
        return schedule;
    }
}