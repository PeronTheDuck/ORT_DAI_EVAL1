package com.ducklings_corp.eval1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EndActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Bundle bundle;
        int entries;
        int wordAndroid,wordIos;
        int longestString;

        bundle = this.getIntent().getExtras();

        entries = bundle.getInt("entries");
        wordAndroid = bundle.getInt("wordAndroid");
        wordIos = bundle.getInt("wordIos");
        longestString = bundle.getInt("longestString");

        displayInfo(entries,wordAndroid,wordIos,longestString);
    }

    private void displayInfo(int entries, int wordAndroid, int wordIos, int longestString) {
        TextView entriesView;
        TextView wordAndroidView, wordIosView;
        TextView longestStringView;

        entriesView = findViewById(R.id.entriesView);
        wordAndroidView = findViewById(R.id.wordAndroidView);
        wordIosView = findViewById(R.id.wordIosView);
        longestStringView = findViewById(R.id.longestStringView);

        entriesView.setText(String.format("Cantidad de entradas: %s",entries));
        wordAndroidView.setText(String.format("Cantidad de 'Android's:  %s",wordAndroid));
        wordIosView.setText(String.format("Cantidad de 'iOS's:  %s",wordIos));
        longestStringView.setText(String.format("Texto mas largo en letras: %s",longestString));
    }
}
