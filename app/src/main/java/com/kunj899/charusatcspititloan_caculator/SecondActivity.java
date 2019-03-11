package com.kunj899.charusatcspititloan_caculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //init(10,MainActivity.principle,MainActivity.interest,MainActivity.balence)
        TableLayout tblayout = (TableLayout) findViewById(R.id.table_main);

        TableRow tbrow0 = new TableRow(this);
        TextView cal1 = new TextView(this);
        cal1.setText("Months");
        cal1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        cal1.setPadding(30, 30, 30, 30);
        cal1.setTextColor(Color.WHITE);
        cal1.setGravity(Gravity.CENTER);
        tbrow0.addView(cal1);

        TextView cal2 = new TextView(this);
        cal2.setText("Principal");
        cal2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        cal2.setPadding(30, 30, 30, 30);
        cal2.setTextColor(Color.WHITE);
        cal2.setGravity(Gravity.CENTER);
        tbrow0.addView(cal2);

        TextView cal3 = new TextView(this);
        cal3.setText("Interest");
        cal3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        cal3.setPadding(30, 30, 30, 30);
        cal3.setTextColor(Color.WHITE);
        cal3.setGravity(Gravity.CENTER);
        tbrow0.addView(cal3);

        TextView cal4 = new TextView(this);
        cal4.setText("Balance");
        cal4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        cal4.setPadding(30, 30, 30, 30);
        cal4.setTextColor(Color.WHITE);
        cal4.setGravity(Gravity.CENTER);
        tbrow0.addView(cal4);

        tblayout.addView(tbrow0);

        for(int i = 0; i < MainActivity.month_total; i++)
        {


            TableRow tbrow = new TableRow(this);
            TextView cal11 = new TextView(this);
            cal11.setText(""+(i+1)+"\n");
            cal11.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            cal11.setPadding(5, 5, 5, 5);
            cal11.setTextColor(Color.WHITE);
            cal11.setGravity(Gravity.CENTER);
            tbrow.addView(cal11);

            TextView cal22 = new TextView(this);
            cal22.setText(String.format("%.2f",MainActivity.principle[i])+"\n");
            cal22.setTextSize(12);
            cal22.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            cal22.setPadding(5, 5, 5, 5);
            cal22.setTextColor(Color.WHITE);
            cal22.setGravity(Gravity.CENTER);
            tbrow.addView(cal22);

            TextView cal33 = new TextView(this);
            cal33.setText(String.format("%.2f",MainActivity.interest[i])+"\n");
            cal33.setTextSize(12);
            cal33.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            cal33.setPadding(5, 5, 5, 5);
            cal33.setTextColor(Color.WHITE);
            cal33.setGravity(Gravity.CENTER);
            tbrow.addView(cal33);

            TextView cal44 = new TextView(this);
            cal44.setText(String.format("%.2f",MainActivity.balence[i])+"\n");
            cal44.setTextSize(12);
            cal44.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
            cal44.setPadding(5, 5, 5, 5);
            cal44.setTextColor(Color.WHITE);
            cal44.setGravity(Gravity.CENTER);
            tbrow.addView(cal44);

            tblayout.addView(tbrow);

        }
    }

}
