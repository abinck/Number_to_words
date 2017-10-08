package com.example.geonbastian.numbertoword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.lang.String;


public class MainActivity extends AppCompatActivity {

    EditText Number;
    EditText secondNumber;
    TextView Result;
    Button Con;
    double Num;
    String one[] = {" ", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", "Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

    String ten[] = {" ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
    String output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number = (EditText) findViewById(R.id.editText4);
        Result = (TextView) findViewById(R.id.editText6);
        Con = (Button) findViewById(R.id.button3);

        try {

            Con.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Num = Double.parseDouble(Number.getText().toString());
                    int n = (int) Num;

                   // int h = 0;

                    if(n>999)
                    {
                        int h=0,t=0;
                        t=n/1000;
                        h=n%1000;
                        n = h % 100;
                        if(h/100==0)
                        {
                            output = one[t]+" Thousand "+ ten[n / 10] + one[n % 10];
                        }
                        else
                            output = one[t]+" Thousand "+one[h/100] + " Hundred " + ten[n / 10] + one[n % 10];
                        Result.setText(output);



                    }

                    else if (n > 99) {
                        int h = 0;
                        h = n / 100;
                        n = n % 100;
                        output = one[h] + " Hundred " + ten[n / 10] + one[n % 10];
                        Result.setText(output);
                    } else {
                        if (n > 19) {
                            output = ten[n / 10] + one[n % 10];
                            Result.setText(output);
                        } else {
                            output = one[n];
                            Result.setText(output);
                        }
                    }
                }

            });

        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }

}
