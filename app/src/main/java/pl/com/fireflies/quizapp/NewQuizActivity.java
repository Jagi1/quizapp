package pl.com.fireflies.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class NewQuizActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Toolbar toolbar;
    private ImageButton avatar, settings;
    private Button addQuizButton;
    private EditText namequiz, categoryquiz, questionquiz1, okodp1, otherodp1, questionquiz2, okodp2, otherodp2,
            questionquiz3, okodp3, otherodp3, questionquiz4, okodp4, otherodp4, questionquiz5, okodp5, otherodp5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataHolder.getInstance().dark_theme) {
            setTheme(R.style.DarkAppTheme);
        } else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_new_quiz);
        initViews();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settings_gear:
                intent = new Intent(NewQuizActivity.this, SettingsActivity.class);
                NewQuizActivity.this.startActivity(intent);
                break;

            case R.id.avatar:
                intent = new Intent(NewQuizActivity.this, AccountSettingsActivity.class);
                NewQuizActivity.this.startActivity(intent);
                break;
            case R.id.add_quiz:
                addQuiz();
                break;
        }
    }

    public void addQuiz() {
        DatabaseReference pathName = DataHolder.firebaseDatabase.child("quizy").child(categoryquiz.getText().toString()).child(namequiz.getText().toString());

        pathName.child(questionquiz1.getText().toString()).child("okodp").setValue(okodp1.getText().toString());
        pathName.child(questionquiz1.getText().toString()).child("otherodp").setValue(otherodp1.getText().toString());

        pathName.child(questionquiz2.getText().toString()).child("okodp").setValue(okodp2.getText().toString());
        pathName.child(questionquiz2.getText().toString()).child("otherodp").setValue(otherodp2.getText().toString());

        pathName.child(questionquiz3.getText().toString()).child("okodp").setValue(okodp3.getText().toString());
        pathName.child(questionquiz3.getText().toString()).child("otherodp").setValue(otherodp3.getText().toString());

        pathName.child(questionquiz4.getText().toString()).child("okodp").setValue(okodp4.getText().toString());
        pathName.child(questionquiz4.getText().toString()).child("otherodp").setValue(otherodp4.getText().toString());

        pathName.child(questionquiz5.getText().toString()).child("okodp").setValue(okodp5.getText().toString());
        pathName.child(questionquiz5.getText().toString()).child("otherodp").setValue(otherodp5.getText().toString());
        Toast.makeText(getApplicationContext(),"Pomyslnie dodano Quiz!", Toast.LENGTH_LONG).show();
        namequiz.getText().clear();
        categoryquiz.getText().clear();
        questionquiz1.getText().clear();
        okodp1.getText().clear();
        otherodp1.getText().clear();
        questionquiz2.getText().clear();
        okodp2.getText().clear();
        otherodp2.getText().clear();
        questionquiz3.getText().clear();
        okodp3.getText().clear();
        otherodp3.getText().clear();
        questionquiz4.getText().clear();
        okodp4.getText().clear();
        otherodp4.getText().clear();
        questionquiz5.getText().clear();
        okodp5.getText().clear();
        otherodp5.getText().clear();
    }
    protected void initViews() {
        toolbar = (Toolbar) findViewById(R.id.user_bar);
        avatar = (ImageButton) findViewById(R.id.avatar);
        settings = (ImageButton) findViewById(R.id.settings_gear);
        addQuizButton = (Button) findViewById(R.id.add_quiz);
        avatar.setImageBitmap(DataHolder.getInstance().avatarBitmap);
        avatar.setOnClickListener(this);
        settings.setOnClickListener(this);
        addQuizButton.setOnClickListener(this);

        namequiz = (EditText) findViewById(R.id.nameQuiz);
        categoryquiz = (EditText) findViewById(R.id.categoryQuiz);
        questionquiz1 = (EditText) findViewById(R.id.questionQuiz1);
        okodp1 = (EditText) findViewById(R.id.okodp1);
        otherodp1 = (EditText) findViewById(R.id.otherodp1);
        questionquiz2 = (EditText) findViewById(R.id.questionQuiz2);
        okodp2 = (EditText) findViewById(R.id.okodp2);
        otherodp2 = (EditText) findViewById(R.id.otherodp2);
        questionquiz3 = (EditText) findViewById(R.id.questionQuiz3);
        okodp3 = (EditText) findViewById(R.id.okodp3);
        otherodp3 = (EditText) findViewById(R.id.otherodp3);
        questionquiz4 = (EditText) findViewById(R.id.questionQuiz4);
        okodp4 = (EditText) findViewById(R.id.okodp4);
        otherodp4 = (EditText) findViewById(R.id.otherodp4);
        questionquiz5 = (EditText) findViewById(R.id.questionQuiz5);
        okodp5 = (EditText) findViewById(R.id.okodp5);
        otherodp5 = (EditText) findViewById(R.id.otherodp5);
    }


}
