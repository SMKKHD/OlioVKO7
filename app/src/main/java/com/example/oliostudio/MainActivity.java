package com.example.oliostudio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    String input;
    TextView text;
    EditText inputstring;
    Context context;
    Scanner scan;
    EditText inputstring1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.testFunction();
        text = (TextView) findViewById(R.id.textView);
        inputstring = (EditText) findViewById(R.id.editTextTextPersonName);
        inputstring1 = (EditText) findViewById(R.id.SomeText);
        //text.setText(inputstring.getText());
        context = MainActivity.this;
        text.setText("Moi Maailma!");
        //scan = new Scanner(inputstring.getText().toString());
    }
    public void testFunction(View v){
        //System.out.println("Hello world!");
        text.setText("Hello world!");


    }
    public void buttonButton(View v){
        text.setText(inputstring.getText());
        System.out.println(inputstring.getText());
        //inputstring.setText(inputstring.toString());
    }

    public String realityCheck(View v){
        //text.setText(inputstring.getText());
        return inputstring.getText().toString();
    }

    public String realityCheck2(View v){
        return inputstring1.getText().toString();
    }

    public void readFile(View v){
        String f = "";
        try{
            InputStream ips = context.openFileInput(inputstring.getText().toString());//TODO tähän käyttäjän syöttö
            inputstring.setText("");
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            String s  = "";

            ArrayList <String> Screenille = new ArrayList();
            while((s = br.readLine()) != null){
               // text.setText(s); //TODO printtaa aina vain yhden rivin
                f += s + "\n";
            }
            text.setText(f);
            ips.close();
        } catch (IOException e) {
            Log.e("IOExecption", "Virhe Syötteessä");
        }
        finally {
            System.out.println("Luettu");
        }
        // catch (FileNotFoundException e) {
       //     Log.e("FileNotFound", "Ei tiedostoa.");
       // }
    }

    public void writeFile(View v){
        try{
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(inputstring.getText().toString(), Context.MODE_PRIVATE));
            inputstring.setText("");
            String s = "";
            ows.write(inputstring1.getText().toString());
            System.out.println("Nyt kirjoitettiin");
            ows.close();
            text.setText("Seuraavaksi syötä tiedosto, mistä haluat tulostaa tiedot");
            inputstring.setText("");
            inputstring1.setText("");

        } catch (IOException e) {
            Log.e("IOExecption", "Virhe Syötteessä");
        } finally{
            System.out.println("Kirjoitettu");
        }
        //catch (FileNotFoundException e) {
          //  Log.e("FileNotFound", "Ei tiedostoa.");
        //}

    }
}
