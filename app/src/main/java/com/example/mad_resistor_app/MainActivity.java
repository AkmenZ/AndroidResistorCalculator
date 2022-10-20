package com.example.mad_resistor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    ImageView band1;
    ImageView band2;
    ImageView band3;
    ImageView tolerance;

    TextView indicatorBand1;
    TextView indicatorBand2;
    TextView indicatorBand3;
    TextView indicatorTolerance;

    Long band1Value = -1L;
    Long band2Value = -1L;
    Long band3Value = -1L;
    Integer toleranceValue = -1;

    TextView result;

    Button calc;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        band1 = findViewById(R.id.band1);
        band2 = findViewById(R.id.band2);
        band3 = findViewById(R.id.band3);
        tolerance = findViewById(R.id.tolerance);

        indicatorBand1 = findViewById(R.id.colorBand1);
        indicatorBand2 = findViewById(R.id.colorBand2);
        indicatorBand3 = findViewById(R.id.colorBand3);
        indicatorTolerance = findViewById(R.id.colorTolerance);

        result = findViewById(R.id.txtResult);
        calc = findViewById(R.id.btnCalc);
        reset =findViewById(R.id.btnReset);

        //spinner 1 and band 1
        Spinner spinner = findViewById(R.id.band_spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.colors,
                android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();

                if(text.contentEquals("-"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.white));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.white));
                    indicatorBand1.setText("Select Color");
                    band1Value = -1L;
                }
                else if(text.contentEquals("Black"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.black));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.black));
                    indicatorBand1.setText("");
                    band1Value = 0L;
                }
                else if(text.contentEquals("Brown"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.brown));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.brown));
                    indicatorBand1.setText("");
                    band1Value = 10L;
                }
                else if(text.contentEquals("Red"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.red));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.red));
                    indicatorBand1.setText("");
                    band1Value = 20L;
                }
                else if(text.contentEquals("Orange"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.orange));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.orange));
                    indicatorBand1.setText("");
                    band1Value = 30L;
                }
                else if(text.contentEquals("Yellow"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.yellow));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.yellow));
                    indicatorBand1.setText("");
                    band1Value = 40L;
                }
                else if(text.contentEquals("Green"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.green));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.green));
                    indicatorBand1.setText("");
                    band1Value = 50L;
                }
                else if(text.contentEquals("Blue"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.blue));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.blue));
                    indicatorBand1.setText("");
                    band1Value = 60L;
                }
                else if(text.contentEquals("Violet"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.violet));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.violet));
                    indicatorBand1.setText("");
                    band1Value = 70L;
                }
                else if(text.contentEquals("Gray"))
                {
                    band1.setColorFilter(getResources().getColor(R.color.gray));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.gray));
                    indicatorBand1.setText("");
                    band1Value = 80L;
                }
                else//its white
                {
                    band1.setColorFilter(getResources().getColor(R.color.white));
                    indicatorBand1.setBackgroundColor(getResources().getColor(R.color.white));
                    indicatorBand1.setText("");
                    band1Value = 90L;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //spinner 2 and band 2
        Spinner spinner2 = findViewById(R.id.bands2_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.colors,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();

                if(text.contentEquals("-"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.white));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.white));
                    indicatorBand2.setText("Select Color");
                    band2Value = -1L;
                }
                else if(text.contentEquals("Black"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.black));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.black));
                    indicatorBand2.setText("");
                    band2Value = 0L;
                }
                else if(text.contentEquals("Brown"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.brown));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.brown));
                    indicatorBand2.setText("");
                    band2Value = 1L;
                }
                else if(text.contentEquals("Red"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.red));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.red));
                    indicatorBand2.setText("");
                    band2Value = 2L;
                }
                else if(text.contentEquals("Orange"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.orange));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.orange));
                    indicatorBand2.setText("");
                    band2Value = 3L;
                }
                else if(text.contentEquals("Yellow"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.yellow));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.yellow));
                    indicatorBand2.setText("");
                    band2Value = 4L;
                }
                else if(text.contentEquals("Green"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.green));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.green));
                    indicatorBand2.setText("");
                    band2Value = 5L;
                }
                else if(text.contentEquals("Blue"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.blue));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.blue));
                    indicatorBand2.setText("");
                    band2Value = 6L;
                }
                else if(text.contentEquals("Violet"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.violet));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.violet));
                    indicatorBand2.setText("");
                    band2Value = 7L;
                }
                else if(text.contentEquals("Gray"))
                {
                    band2.setColorFilter(getResources().getColor(R.color.gray));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.gray));
                    indicatorBand2.setText("");
                    band2Value = 8L;
                }
                else//its white
                {
                    band2.setColorFilter(getResources().getColor(R.color.white));
                    indicatorBand2.setBackgroundColor(getResources().getColor(R.color.white));
                    indicatorBand2.setText("");
                    band2Value = 9L;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //spinner 3 and band 3
        Spinner spinner3 = findViewById(R.id.bands3_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.colors,
                android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                if(text.contentEquals("-"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.white));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.white));
                    indicatorBand3.setText("Select Color");
                    band3Value = -1L;
                }
                else if(text.contentEquals("Black"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.black));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.black));
                    indicatorBand3.setText("");
                    band3Value = 1L;
                }
                else if(text.contentEquals("Brown"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.brown));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.brown));
                    indicatorBand3.setText("");
                    band3Value = 10L;
                }
                else if(text.contentEquals("Red"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.red));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.red));
                    indicatorBand3.setText("");
                    band3Value = 100L;
                }
                else if(text.contentEquals("Orange"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.orange));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.orange));
                    indicatorBand3.setText("");
                    band3Value = 1000L;
                }
                else if(text.contentEquals("Yellow"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.yellow));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.yellow));
                    indicatorBand3.setText("");
                    band3Value = 10000L;
                }
                else if(text.contentEquals("Green"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.green));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.green));
                    indicatorBand3.setText("");
                    band3Value = 100000L;
                }
                else if(text.contentEquals("Blue"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.blue));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.blue));
                    indicatorBand3.setText("");
                    band3Value = 1000000L;
                }
                else if(text.contentEquals("Violet"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.violet));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.violet));
                    indicatorBand3.setText("");
                    band3Value = 10000000L;
                }
                else if(text.contentEquals("Gray"))
                {
                    band3.setColorFilter(getResources().getColor(R.color.gray));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.gray));
                    indicatorBand3.setText("");
                    band3Value = 100000000L;
                }
                else//its white
                {
                    band3.setColorFilter(getResources().getColor(R.color.white));
                    indicatorBand3.setBackgroundColor(getResources().getColor(R.color.white));
                    indicatorBand3.setText("");
                    band3Value = 1000000000L;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //spinner 4 and tolerance
        Spinner spinner4 = findViewById(R.id.tolerance_spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.tolerances,
                android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();

                if(text.contentEquals("-"))
                {
                    tolerance.setColorFilter(getResources().getColor(R.color.white));
                    indicatorTolerance.setBackgroundColor(getResources().getColor(R.color.white));
                    indicatorTolerance.setText("Select Color");
                    toleranceValue = -1;
                }
                else if(text.contentEquals("Silver"))
                {
                    tolerance.setColorFilter(getResources().getColor(R.color.silver));
                    indicatorTolerance.setBackgroundColor(getResources().getColor(R.color.silver));
                    indicatorTolerance.setText("");
                    toleranceValue = 10;
                }
                else//its gold
                {
                    tolerance.setColorFilter(getResources().getColor(R.color.gold));
                    indicatorTolerance.setBackgroundColor(getResources().getColor(R.color.gold));
                    indicatorTolerance.setText("");
                    toleranceValue = 5;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (band1Value != -1 && band2Value != -1 && band3Value != -1 && toleranceValue != -1)
                {
                    //format double to not show decimal  value if it's 0
                    Double val = Double.valueOf((band1Value + band2Value) * band3Value);
                    DecimalFormat format = new DecimalFormat("#.##");

                    //Convert and display
                    if(val >= 1000000000)//Gigaohms
                    {
                        val = val / 1000000000L;
                        result.setText(format.format(val)+"G Ω " + toleranceValue.toString()+"%");
                    }
                    else if(val >= 1000000)//Megaohms
                    {
                        val = val / 1000000;
                        result.setText(format.format(val)+"M Ω " + toleranceValue.toString()+"%");
                    }
                    else if(val >= 1000)//Kiloohms
                    {
                        val = val / 1000;
                        result.setText(format.format(val)+"K Ω " + toleranceValue.toString()+"%");
                    }
                    else//Ohms
                    {
                        result.setText(format.format(val)+" Ω " + toleranceValue.toString()+"%");
                    }

                }
                else
                {
                    result.setText("Error");
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Enter All Values!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                band1.setColorFilter(getResources().getColor(R.color.white));
                indicatorBand1.setBackgroundColor(getResources().getColor(R.color.white));
                indicatorBand1.setText("Select Color");
                band1Value = -1L;
                int spinner1Position = adapter1.getPosition("-");
                spinner.setSelection(spinner1Position);

                band2.setColorFilter(getResources().getColor(R.color.white));
                indicatorBand2.setBackgroundColor(getResources().getColor(R.color.white));
                indicatorBand2.setText("Select Color");
                band2Value = -1L;
                int spinner2Position = adapter2.getPosition("-");
                spinner2.setSelection(spinner2Position);

                band3.setColorFilter(getResources().getColor(R.color.white));
                indicatorBand3.setBackgroundColor(getResources().getColor(R.color.white));
                indicatorBand3.setText("Select Color");
                band3Value = -1L;
                int spinner3Position = adapter3.getPosition("-");
                spinner3.setSelection(spinner3Position);

                tolerance.setColorFilter(getResources().getColor(R.color.white));
                indicatorTolerance.setBackgroundColor(getResources().getColor(R.color.white));
                indicatorTolerance.setText("Select Color");
                toleranceValue = -1;
                int spinner4Position = adapter4.getPosition("-");
                spinner4.setSelection(spinner4Position);

                result.setText("");
            }
        });
    }

    //implements AdapterView.OnItemSelectedListener
}