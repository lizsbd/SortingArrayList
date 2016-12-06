package com.example.qnd238.sort;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends AppCompatActivity {
    EditText input;
    Button but;
    ArrayList<Integer> array = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        but = (Button) findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().trim().length() > 0) {
                    array.add(Integer.parseInt(input.getText().toString()));
                }
                Integer[] arrayfinal = array.toArray(new Integer[array.size()]);
                sort(arrayfinal);
                StringBuilder output= new StringBuilder("");

                for(int number : arrayfinal) {


                    output.append(Integer.toString(number)).append("\n");

                }
                Context context = getApplicationContext();
                CharSequence text = " The array in ascending order is \n" + output;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });

    }

    public void sort(Integer[] array){

        int i=0;
        int minOldIn=0;
        int minIn=0;
        int min = array[minOldIn];
        int j=i+1;
        while(i<array.length-1) {
            minIn=i;
            while (j < array.length) {

                if (min > array[j]) {
                    min = array[j];
                    minIn = j;


                }
                j++;
                swap(minOldIn, minIn, array);
            }

            i++;
        }


    }

    public void swap(int minOldIn, int minIn, Integer[] array){
        int t = array[minOldIn];
        array[minOldIn] = array[minIn];
        array[minIn] = t;

    }
}
