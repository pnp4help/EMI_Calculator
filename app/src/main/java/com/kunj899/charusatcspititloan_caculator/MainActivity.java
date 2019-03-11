package com.kunj899.charusatcspititloan_caculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout parent;
    Button loan1_details,loan2_details;
    public static double [] principle;
    public static double [] interest;
    public static double [] balence;
    public static double [] principle1;
    public static double [] interest1;
    public static double [] balence1;

    public static double em1;
    public static double em2;
    public static double in1;
    public static double in2;
    public static double py1;
    public static double py2;

    double total_interest;
    double total_payment;
    double total_interest1;
    double total_payment1;


    public static int month_total;
    public static int month_total1;

    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    EditText e6;
    Button calculate;
    Button reset;

    TextView emi;
    TextView emi1;
    TextView emi2;
    TextView emi_diff;

    TextView iin;
    TextView iin1;
    TextView iin2;
    TextView iin_diff;

    TextView ppy;
    TextView ppy1;
    TextView ppy2;
    TextView ppy_diff;


    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        parent = (LinearLayout) findViewById(R.id.myLinearLayout);

        emi = (TextView)findViewById(R.id.emi);
        emi1 = (TextView)findViewById(R.id.emi1);
        emi_diff = (TextView)findViewById(R.id.emidiff);
        emi2 = (TextView)findViewById(R.id.emi2);

        iin = (TextView)findViewById(R.id.inte);
        iin1 = (TextView)findViewById(R.id.inte1);
        iin_diff = (TextView)findViewById(R.id.intediff);
        iin2 = (TextView)findViewById(R.id.inte2);

        ppy = (TextView)findViewById(R.id.pay);
        ppy1 = (TextView)findViewById(R.id.pay1);
        ppy_diff = (TextView)findViewById(R.id.paydiff);
        ppy2 = (TextView)findViewById(R.id.pay2);


        e1 = (EditText)findViewById(R.id.a1);
        e2 = (EditText)findViewById(R.id.a2);
        e3 = (EditText)findViewById(R.id.i1);
        e4 = (EditText)findViewById(R.id.i2);
        e5 = (EditText)findViewById(R.id.t1);
        e6 = (EditText)findViewById(R.id.t2);


        calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(!e1.getText().toString().equals("") && !e2.getText().toString().equals("") && !e3.getText().toString().equals("") && !e4.getText().toString().equals("") && !e5.getText().toString().equals("") && !e6.getText().toString().equals(""))
                {

                    parent.removeAllViews();
                    loan1_details = new Button(MainActivity.this);
                    loan1_details.setId(1);
                    loan1_details.setTag(1);
                    parent.addView(loan1_details);
                    loan1_details.setText("Loan 1 Details");
                    loan1_details.setOnClickListener(MainActivity.this);

                    loan2_details = new Button(MainActivity.this);
                    loan2_details.setId(2);
                    loan2_details.setTag(2);
                    parent.addView(loan2_details);
                    loan2_details.setText("Loan 2 Details");
                    loan2_details.setOnClickListener(MainActivity.this);

                    double P = Double.parseDouble(e1.getText().toString());
                    double r = Double.parseDouble(e3.getText().toString());
                    double T = Double.parseDouble(e5.getText().toString());

                    double P1 = Double.parseDouble(e2.getText().toString());
                    double r1 = Double.parseDouble(e4.getText().toString());
                    double T1 = Double.parseDouble(e6.getText().toString());


                    double R = r/(12.0*100.0);
                    double R1 = r1/(12.0*100.0);

                    // calculate E
                    double x1 = Math.pow((1+R),T);
                    double x2 = x1-1;
                    double E = (P*R*x1)/x2;
                    double x11 = Math.pow((1+R1),T1);
                    double x22 = x11-1;
                    double E1 = (P1*R1*x11)/x22;


                    double A = (P*(1+(R)));
                    double I = A - P;
                    double V = E - I;
                    double B = P - V;
                    double A1 = (P1*(1+(R1)));
                    double I1 = A1 - P1;
                    double V1 = E1 - I1;
                    double B1 = P1 - V1;


                    month_total = (int) T;
                    month_total1 = (int) T1;

                    principle = new double[month_total];
                    interest = new double[month_total];
                    balence = new double[month_total];
                    principle1 = new double[month_total1];
                    interest1 = new double[month_total1];
                    balence1 = new double[month_total1];


                    principle[0] = V;
                    interest[0] = I;
                    balence[0] = B;
                    principle1[0] = V1;
                    interest1[0] = I1;
                    balence1[0] = B1;


                    total_interest = 0;
                    total_payment = 0;
                    total_interest1 = 0;
                    total_payment1 = 0;

                    total_interest = total_interest + interest[0];
                    total_payment = total_payment + P;
                    total_interest1 = total_interest1 + interest1[0];
                    total_payment1 = total_payment1 + P1;


                    for(int i=2;i<=T;i++)
                    {
                        double temp = B;
                        A = (temp*(1+R));
                        I = A - temp;
                        V = E - I;
                        B = temp - V;

                        if(B < 0)
                        {
                            B = 0;
                        }

                        total_interest = total_interest + I;

                        principle[i-1] = V;
                        interest[i-1] = I;
                        balence[i-1] = B;
                    }
                    for(int i=2;i<=T1;i++)
                    {
                        double temp1 = B1;
                        A1 = (temp1*(1+R1));
                        I1 = A1 - temp1;
                        V1 = E1 - I1;
                        B1 = temp1 - V1;

                        if(B1 < 0)
                        {
                            B1 = 0;
                        }

                        total_interest1 = total_interest1 + I1;

                        principle1[i-1] = V1;
                        interest1[i-1] = I1;
                        balence1[i-1] = B1;
                    }

                    total_payment = total_payment + total_interest;
                    total_payment1 = total_payment1 + total_interest1;


                    in1 = total_interest;
                    in2 = total_interest1;

                    py1 = total_payment;
                    py2 = total_payment1;

                    em1 = E;
                    em2 = E1;

                    emi.setText("EMI");
                    emi1.setText(""+String.format("%.2f",em1));
                    emi2.setText(""+String.format("%.2f",em2));
                    emi_diff.setText(""+String.format("%.2f",Math.abs(E-E1)));

                    iin.setText("Interest");
                    iin1.setText(""+String.format("%.2f",in1));
                    iin2.setText(""+String.format("%.2f",in2));
                    iin_diff.setText(""+String.format("%.2f",Math.abs(in1-in2)));

                    ppy.setText("Payment");
                    ppy1.setText(""+String.format("%.2f",py1));
                    ppy2.setText(""+String.format("%.2f",py2));
                    ppy_diff.setText(""+String.format("%.2f",Math.abs(py1-py2)));

                }
                else
                {
                    Toast.makeText(getBaseContext(), "Please set all the values", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                emi.setText("");
                emi1.setText("");
                emi2.setText("");
                emi_diff.setText("");
                iin.setText("");
                iin1.setText("");
                iin2.setText("");
                iin_diff.setText("");
                ppy.setText("");
                ppy1.setText("");
                ppy2.setText("");
                ppy_diff.setText("");
                parent.removeAllViews();
        }
        });
    }

    @Override
    public void onClick(View v) {
        String str = v.getTag().toString();
        if(str.equals("1"))
        {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }
        if(str.equals("2"))
        {
            startActivity(new Intent(MainActivity.this, ThirdActivity.class));
        }
    }
}
