package pl.com.fireflies.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class SettingsActivity extends AppCompatActivity {
    private Intent intent;
    private ListView settings_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();

    }

    protected void initViews() {
    }
}