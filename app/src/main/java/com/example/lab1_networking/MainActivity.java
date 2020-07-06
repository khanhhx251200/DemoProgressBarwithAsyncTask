package com.example.lab1_networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnRun;
    private TextView tvProgress;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        tvProgress = findViewById(R.id.tv_progress);
        btnRun = findViewById(R.id.btn_run);

        progressBar.setProgress(0);

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemoAsyncTask demoAsyncTask = new DemoAsyncTask(new DemoAsyncTask.DemoAsynInterface() {
                    @Override
                    public void OnProgressChange(final int value) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(Integer.parseInt(value + ""));
                            }
                        });

                    }

                    @Override
                    public void OnpostExute(String s) {
                        tvProgress.setText(s);
                    }
                });
                demoAsyncTask.execute();

            }
        });

    }
}
