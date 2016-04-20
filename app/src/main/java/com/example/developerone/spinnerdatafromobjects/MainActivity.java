package com.example.developerone.spinnerdatafromobjects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button_UseSelectedItem;
    Spinner mySpinner;
    TextView myTextView;
    ArrayList<CountryInfo> myCountries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCountries = populateList();
        setContentView(R.layout.activity_main);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);
        button_UseSelectedItem = (Button) findViewById(R.id.buttonUseItem);
        myTextView = (TextView) findViewById(R.id.myTextView);

        ArrayAdapter<CountryInfo> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, myCountries);
        mySpinner.setAdapter(myAdapter);

        button_UseSelectedItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                CountryInfo myCountry;
                if (!(mySpinner.getSelectedItem() == null)) {
                    myCountry = (CountryInfo) mySpinner.getSelectedItem();
                    myTextView.setText(String.format("Country: " + myCountry.getCountryName() + "\t Population: " + myCountry.getCountryPopulation()));
                }
            }
        });
    }

    private ArrayList<CountryInfo> populateList() {
        ArrayList<CountryInfo> myCountries = new ArrayList<>();
        myCountries.add(new CountryInfo("USA", 308745538));
        myCountries.add(new CountryInfo("Sweden", 9482855));
        myCountries.add(new CountryInfo("Canada", 34018000));
        return myCountries;
    }
}

