package com.example.lab1_networking;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;


public class DemoAsyncTask extends AsyncTask<Void, Integer, String> {
    private TextView tvData;
    private DemoAsynInterface asynInterface;

    public DemoAsyncTask(DemoAsynInterface asynInterface) {
        this.asynInterface = asynInterface;
    }


    @Override
    protected String doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                publishProgress(i);
                Log.d("TAG", "doInBackground: " + i);
            }
        } catch (Exception e) {

        }
        return "Đã hoàn tất";
    }

    @Override
    protected void onPostExecute(String s) { // chạy xong doInBackground sẽ vào đây (callback)
        super.onPostExecute(s);
        if (asynInterface != null) {
            asynInterface.OnpostExute(s);
        }

    }

    @Override
    protected void onProgressUpdate(Integer... values) { // cập nhật tiến độ
        super.onProgressUpdate(values);
        if (asynInterface != null) {
            asynInterface.OnProgressChange(values[0]);
        }
    }

    public interface DemoAsynInterface {
        void OnProgressChange(int value);

        void OnpostExute(String s);
    }
}
