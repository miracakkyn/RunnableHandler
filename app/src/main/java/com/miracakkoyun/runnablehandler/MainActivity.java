package com.miracakkoyun.runnablehandler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textViewTwo;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView=findViewById(R.id.textView);
        number=0;
        button=findViewById(R.id.button);
        textViewTwo=findViewById(R.id.textVieww);

    }
    public void start(View view){
            handler=new Handler();
            runnable=new Runnable() {
                @Override
                public void run() {
                    textView.setText("Time "+number);
                    number++;
                    textView.setText("Time: "+number);
                    handler.postDelayed(runnable,1000);
                }
            };
            handler.post(runnable);
            button.setEnabled(false);


    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        textViewTwo.setText("Önceki Tur:"+number);
        number=0;
    }



}