package com.bpapps.tupleex;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Tuple> times = new ArrayList<>();
        times.add(new Tuple(3, 5));
        times.add(new Tuple(4, 8));
        times.add(new Tuple(0, 1));
        times.add(new Tuple(10, 12));
        times.add(new Tuple(9, 10));

        Log.d(TAG, times.toString());
        //  [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
        //  [(0, 1), (3, 8), (9, 12)]
        ArrayList<Tuple> mergedTimes = mergeRanges(times);
        Log.d(TAG, mergedTimes.toString());
    }

    public ArrayList<Tuple> mergeRanges(@NonNull ArrayList<Tuple> times) {
        if (times.size() > 0) {
            times.sort(Tuple.Comparators.START_TIME);
            Log.d(TAG, times.toString());

            ArrayList<Tuple> retVal = new ArrayList<>();
            int j = 0;
            retVal.add(times.get(0));

            for (int i = 1; i < times.size(); i++) {
                if (retVal.get(j).getEndTime() >= times.get(i).getStartTime()) {
                    retVal.get(j).setEndTime(times.get(i).getEndTime());
                } else {
                    retVal.add(times.get(i));
                    j++;
                }
            }

            return retVal;
        }

        return null;
    }
}