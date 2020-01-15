package com.logimetrix.daterange;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView date;
    private Calendar cal1;
    private Calendar cal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        cal1 = Calendar.getInstance();
        cal2 = Calendar.getInstance();

        date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(
                                year + "/" + (month + 1) + "/" + dayOfMonth);
                    }
                },year, month, dayOfMonth);
                dialog.show();
                dialog.getDatePicker().setMaxDate(cal1.getTimeInMillis());
                dialog.getDatePicker().setMinDate(System.currentTimeMillis());
                dialog.getDatePicker().setMinDate(cal2.getTimeInMillis());
            }
        });cal1.add(Calendar.YEAR, 0);
        cal1.add(Calendar.MONTH, 0);
        cal1.add(Calendar.DAY_OF_MONTH, 1);
        cal2.add(Calendar.YEAR, 0);
        cal2.add(Calendar.MONTH, 0);
        cal2.add(Calendar.DAY_OF_MONTH, -1);
    }

}
