package kg.nurga.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Calendar;


public class AddActivity extends AppCompatActivity {

    EditText mEditTitle;
    EditText mEditDesc;
    Calendar calendar;
    Button dataBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mEditTitle = findViewById(R.id.editTitle);
        mEditDesc = findViewById(R.id.editDesc);
        dataBtn = findViewById(R.id.btnData);
    }

    public void onClickDate(View view) {


        String date = "22/3/2014";
        String parts[] = date.split("/");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);


        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        long milliTime = calendar.getTimeInMillis();

        CalendarView calendarView = new CalendarView(this);
        calendarView.setDate(milliTime, true, true);
        Task task = new  Task();
        task.setTitle(date);


    }

    public void onClickSave(View view) {

        String title = mEditTitle.getText().toString().trim();
        String desc = mEditDesc.getText().toString().trim();


        Task task = new  Task();
        task.setTitle(title);
        task.setDescription(desc);
        task.setCreatedTime(System.currentTimeMillis());

        Intent intent = new Intent();
        intent.putExtra("key", task);
        setResult(RESULT_OK, intent);
        finish();

    }
}
