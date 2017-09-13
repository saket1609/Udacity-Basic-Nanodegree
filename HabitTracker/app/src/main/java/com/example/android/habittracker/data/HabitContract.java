package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by SAKET KUMAR SINGH on 22-08-2017.
 */
public final class HabitContract {

    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME = "name";
        public final static String COLUMN_HABIT_REPETITION = "repetition";
        public final static String COLUMN_HABIT_PRIORITY = "priority";
        public static final int PRIORITY_UNKNOWN = 0;
        public static final int PRIORITY_HIGH = 1;
        public static final int PRIORITY_LOW = 2;

    }
}