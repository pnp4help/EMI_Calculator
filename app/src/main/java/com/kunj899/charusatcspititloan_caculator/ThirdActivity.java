package com.kunj899.charusatcspititloan_caculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //init(10,MainActivity.principle,MainActivity.interest,MainActivity.balence)
        TableLayout tblayout = (TableLayout) findViewById(R.id.table_main);

        TableRow tbrow0 = new TableRow(this);
        TextView col1 = new TextView(this);
        col1.setText("Months");
        col1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        col1.setPadding(30, 30, 30, 30);
        col1.setTextColor(Color.WHITE);
        col1.setGravity(Gravity.CENTER);
        tbrow0.addView(col1);

        TextView col2 = new TextView(this);
        col2.setText("Principal");
        col2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        col2.setPadding(30, 30, 30, 30);
        col2.setTextColor(Color.WHITE);
        col2.setGravity(Gravity.CENTER);
        tbrow0.addView(col2);

        TextView col3 = new TextView(this);
        col3.setText("Interest");
        col3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        col3.setPadding(30, 30, 30, 30);
        col3.setTextColor(Color.WHITE);
        col3.setGravity(Gravity.CENTER);
        tbrow0.addView(col3);

        TextView col4 = new TextView(this);
        col4.setText("Balance");
        col4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        col4.setPadding(30, 30, 30, 30);
        col4.setTextColor(Color.WHITE);
        col4.setGravity(Gravity.CENTER);
        tbrow0.addView(col4);

        tblayout.addView(tbrow0);

        for(int i = 0; i < MainActivity.month_total1; i++)
        {

            TableRow tbrow = new TableRow(this);
            TextView col11 = new TextView(this);
            col11.setText(""+(i+1));
            col11.setTextSize(12);
            col11.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            col11.setPadding(5, 5, 5, 5);
            col11.setTextColor(Color.WHITE);
            col11.setGravity(Gravity.CENTER);
            tbrow.addView(col11);

            TextView col22 = new TextView(this);
            col22.setText(String.format("%.2f",MainActivity.principle1[i])+"\n");
            col22.setTextSize(12);
            col22.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            col22.setPadding(5, 5, 5, 5);
            col22.setTextColor(Color.WHITE);
            col22.setGravity(Gravity.CENTER);
            tbrow.addView(col22);

            TextView col33 = new TextView(this);
            col33.setText(String.format("%.2f",MainActivity.interest1[i])+"\n");
            col33.setTextSize(12);
            col33.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            col33.setPadding(5, 5, 5, 5);
            col33.setTextColor(Color.WHITE);
            col33.setGravity(Gravity.CENTER);
            tbrow.addView(col33);

            TextView col44 = new TextView(this);
            col44.setText(String.format("%.2f",MainActivity.balence1[i])+"\n");
            col44.setTextSize(12);
            col44.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            col44.setPadding(5, 5, 5, 5);
            col44.setTextColor(Color.WHITE);
            col44.setGravity(Gravity.CENTER);
            tbrow.addView(col44);
            tblayout.addView(tbrow);
        }
    }

}
