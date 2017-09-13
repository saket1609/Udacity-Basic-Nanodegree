package com.example.android.habittracker;

        import android.content.ContentValues;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.TextUtils;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

        import com.example.android.habittracker.data.HabitContract;
        import com.example.android.habittracker.data.HabitDbHelper;

/**
 * Created by SAKET KUMAR SINGH on 22-08-2017.
 */

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mRepetitionEditText;
    private Spinner mPriority;
    private int mDefaultPriority = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mNameEditText = (EditText) findViewById(R.id.edit_text_name);
        mRepetitionEditText = (EditText) findViewById(R.id.edit_text_repetition);
        mPriority = (Spinner) findViewById(R.id.spinner_priority);
        setupSpinner();
    }

    private void setupSpinner() {
        ArrayAdapter PrioritySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_priority_options, android.R.layout.simple_spinner_item);
        PrioritySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mPriority.setAdapter(PrioritySpinnerAdapter);
        mPriority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.priority_high))) {
                        mDefaultPriority = HabitContract.HabitEntry.PRIORITY_HIGH;
                    } else if (selection.equals(getString(R.string.priority_low))) {
                        mDefaultPriority = HabitContract.HabitEntry.PRIORITY_LOW;
                    } else {
                        mDefaultPriority = HabitContract.HabitEntry.PRIORITY_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mDefaultPriority = 0;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertPet();
                finish();
                return true;
            case R.id.action_delete:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertPet() {
        String nameString = mNameEditText.getText().toString().trim();
        String repetitionString = mRepetitionEditText.getText().toString().trim();
        int weight = Integer.parseInt(repetitionString);
        HabitDbHelper mDbHelper = new HabitDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME, nameString);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_REPETITION, weight);
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_PRIORITY, mDefaultPriority);
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        if (newRowId == -1) {

            Toast.makeText(this, "Error with saving habits", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Habit saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }
}