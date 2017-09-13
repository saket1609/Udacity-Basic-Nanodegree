package com.example.android.habittracker;

        import android.content.ContentValues;
        import android.database.sqlite.SQLiteDatabase;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;

        import com.example.android.habittracker.data.HabitContract.HabitEntry;
        import com.example.android.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        mDbHelper = new HabitDbHelper(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private Cursor read() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_REPETITION,
                HabitEntry.COLUMN_HABIT_PRIORITY};

        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }
    private void displayDatabaseInfo() {

        Cursor cursor = read();

        TextView displayView = (TextView) findViewById(R.id.text_view_habit);

        try {
            displayView.setText("The habits table contains " + cursor.getCount() + " habits.\n\n");
            displayView.append(HabitEntry._ID + " - " +
                    HabitEntry.COLUMN_HABIT_NAME + " - " +
                    HabitEntry.COLUMN_HABIT_REPETITION + " - " +
                    HabitEntry.COLUMN_HABIT_PRIORITY + " - " + "\n");

            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int repetitionColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_REPETITION);
            int priorityColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_PRIORITY);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentRepetition = cursor.getString(repetitionColumnIndex);
                int currentPriority = cursor.getInt(priorityColumnIndex);
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentRepetition + " - " +
                        currentPriority));
            }
        } finally {
            cursor.close();
        }
    }



    private void insertPet() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Music");
        values.put(HabitEntry.COLUMN_HABIT_REPETITION, "2");
        values.put(HabitEntry.COLUMN_HABIT_PRIORITY, HabitEntry.PRIORITY_HIGH);
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_insert_dummy_data:
                insertPet();
                displayDatabaseInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}