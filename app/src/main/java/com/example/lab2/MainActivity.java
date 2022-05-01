package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {

    TextView tvMain;
    EditText txMain;
    Spinner spOptionSelection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvMain = findViewById(R.id.tvMain);
        this.txMain = findViewById(R.id.txMain);
        this.spOptionSelection = findViewById(R.id.spOptionSelection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spOptionSelection.setAdapter(adapter);
    }

    public void onBtnCalculateClick(View view) {
        if (txMain.getText().toString().isEmpty() ) {
            Toast.makeText(this, "Text is empty", Toast.LENGTH_LONG).show();}

        else {

            if (this.spOptionSelection.getSelectedItem().toString().equalsIgnoreCase(getResources().getStringArray(R.array.Choice)[0])){
                int wordsCount = TextUtilsWords.getWordsCount(this.txMain.getText().toString());
                String wordsCountFormatted = String.valueOf(wordsCount);
                this.tvMain.setText(wordsCountFormatted);

            } else {
                int charsCount = TextUtilsChars.getCharsCount(this.txMain.getText().toString());
                String charsCountFormatted = String.valueOf(charsCount);
                this.tvMain.setText(charsCountFormatted);
            }

        }

    }
}