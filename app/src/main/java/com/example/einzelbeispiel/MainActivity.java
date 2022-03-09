package com.example.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
public void calculate(View view){
    EditText editText = (EditText) findViewById(R.id.MatrikelnummerInput);
    String matrikelnummer=editText.getText().toString();
    TextView resultView= (TextView) findViewById(R.id.calculationResult);
    Calculator client=new Calculator(matrikelnummer,resultView);
    new Thread(client).start();
}
    public void sendToServer(View view) {
        EditText editText = (EditText) findViewById(R.id.MatrikelnummerInput);
        String matrikelnummer=editText.getText().toString();
        TextView resultView= (TextView) findViewById(R.id.ResultView);
        Client client=new Client(matrikelnummer,resultView);
        new Thread(client).start();


    }


}