package com.example.einzelbeispiel;

import android.widget.TextView;

import java.net.*;
import java.io.*;

import java.util.LinkedList;

public class Client extends Thread {
    private Socket socket            = null;
    BufferedReader in=null;
    private DataOutputStream out     = null;
    String result=null;
    String matrikelnummer="";
    TextView view=null;
    public Client(String matrikelnummer, TextView view){
        this.matrikelnummer=matrikelnummer;
        this.view=view;
    }

public void run(){
    try {

        socket = new Socket("se2-isys.aau.at", 53212);
        System.out.println(socket.isConnected());
        out = new DataOutputStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.writeBytes(matrikelnummer + '\n');
        result=in.readLine();
        System.out.println(result);

    }
    catch (IOException e){
        System.out.println(e);
        System.out.println("fehler im öffnen");
    }
    try
    { out.close();
        in.close();

        socket.close();
    }
    catch(IOException i)
    {
        System.out.println(i);
        System.out.println("fehler beim schließen");
    }
    view.setText(result);
}



}
