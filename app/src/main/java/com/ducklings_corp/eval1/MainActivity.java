package com.ducklings_corp.eval1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Vector<String> entriesVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entriesVector = new Vector<>();
    }

    public void processData(View view) {
        EditText inputText;
        CheckBox superCheckBox;
        String text;
        String logOutputText;

        inputText = findViewById(R.id.textInput);
        superCheckBox = findViewById(R.id.superCheckBox);
        text = inputText.getText().toString();

        inputText.setText("");

        if(text.length()==0) {
            Log.d("Output","El usuario no ingresó nada");
            showErrorNoText();
            return;
        }
        if(text.compareTo("Fin")==0) {
            processData();
            return;
        }

        entriesVector.add(text);

        logOutputText = String.format("Texto: %s | Largo: %s | Checkbox: %s",
                text,
                text.length(),
                superCheckBox.isChecked()
                );
        Log.d("Output",logOutputText);
    }

    private void processData() {
        int entries;
        int wordAndroid,wordIos;
        int longestString;
        String processingEntry;

        entries = entriesVector.size();
        wordAndroid = 0;
        wordIos = 0;
        longestString = 0;

        for (int i=0;i<entries;i++) {
            processingEntry = entriesVector.get(i);
            if(processingEntry.length()>longestString) {
                longestString = processingEntry.length();
            }
            if(processingEntry.toLowerCase().contains("android")) {
                wordAndroid += 1;
            }
            if(processingEntry.toLowerCase().contains("ios")) {
                wordIos += 1;
            }
        }
        finishProgram(entries,wordAndroid,wordIos,longestString);
    }
    private void finishProgram(int entries,int wordAndroid, int wordIos, int longestString) {
        Bundle bundle;
        Intent nextActivity;

        Log.d("Output",String.format("entries = %s | wordAndroid = %s | wordIos = %s | longestString = %s",
                entries,wordAndroid,wordIos,longestString));

        bundle = new Bundle();
        nextActivity = new Intent(this,EndActivity.class);

        bundle.putInt("entries",entries);
        bundle.putInt("wordAndroid",wordAndroid);
        bundle.putInt("wordIos",wordIos);
        bundle.putInt("longestString",longestString);


        nextActivity.putExtras(bundle);
        startActivity(nextActivity);
    }

    public void showErrorNoText() {
        Toast toast;

        toast = Toast.makeText(this,"Ingrese un texto, por favor",Toast.LENGTH_SHORT);
        toast.show();
    }
}
