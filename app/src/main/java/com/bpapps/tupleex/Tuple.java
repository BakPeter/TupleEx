package com.bpapps.tupleex;

import java.util.Comparator;

public class Tuple implements Comparable<Tuple> {
    private int mStartTime;
    private int mEndTime;

    public Tuple(int mStartTime, int mEndTime) {
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
    }

    @Override
    public String toString() {
        return "(" + mStartTime + "," + mEndTime + ")";
    }

    @Override
    public int compareTo(Tuple o) {
        return mEndTime - o.mEndTime;
    }

    public int getStartTime() {
        return mStartTime;
    }

    public void setStartTime(int mStartTime) {
        this.mStartTime = mStartTime;
    }

    public int getEndTime() {
        return mEndTime;
    }

    public void setEndTime(int mEndTime) {
        this.mEndTime = mEndTime;
    }

    public static class Comparators {
        public static Comparator<Tuple> START_TIME = new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.mStartTime - o2.mStartTime;
            }
        };
    }
}
