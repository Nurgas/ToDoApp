package kg.nurga.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    EditText mEditTitle;
    EditText mEditDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mEditTitle = findViewById(R.id.editTitle);
        mEditDesc = findViewById(R.id.editDesc);



    }

    public void onClickDate(View view) {
        //TODO при нажатии на кнопку открывать календаь
    }

    public void onClickSave(View view) {

        String title = mEditTitle.getText().toString().trim();
        String desc = mEditDesc.getText().toString().trim();

        Task task = new  Task();
        task.setTitle(title);
        task.setDescription(desc);
        task.setCreatedTime(System.currentTimeMillis());

    }
}
