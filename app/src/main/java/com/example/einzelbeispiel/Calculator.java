package com.example.einzelbeispiel;

import android.widget.TextView;

import java.util.Arrays;

public class Calculator extends Thread{
    private String matrikelnummer=null;
    private TextView view=null;
    public Calculator(String matrikelnummer, TextView view){
        this.matrikelnummer=matrikelnummer;
        this.view=view;
    }
    public void run(){
        char[]arr=matrikelnummer.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if(i%2!=0){
                arr[i]=(char)(arr[i]+48);

            }
        }
        String result="";
        for (char a:arr
             ) {
            result=result.concat(String.valueOf(a));
        }
        view.setText(result);
    }

}
