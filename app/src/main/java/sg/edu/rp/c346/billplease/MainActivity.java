package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton btnGst ;
    ToggleButton sc;
    Button calc;
    Button reset;
    EditText etAmt;  //Input amount
    EditText result; //output amount
    EditText people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGst = findViewById(R.id.gst);
        sc = findViewById(R.id.sc);
        calc = findViewById(R.id.btnCalc);
        etAmt = findViewById(R.id.etAmt);
        result = findViewById(R.id.result);
        people = findViewById(R.id.people);
        reset = findViewById(R.id.btnReset);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amt = 0;
                amt = Double.parseDouble(etAmt.getText().toString());
                double peoplee;
                peoplee = Double.parseDouble(people.getText().toString());

                if (sc.isChecked() == true && btnGst.isChecked() == true)
                {
                    amt = amt/100*110;
                    amt = amt/100*107;
                }
                else {
                    if (sc.isChecked() == true && btnGst.isChecked() == false) {
                        amt = amt / 100 * 110;
                    } else if (sc.isChecked() == false && btnGst.isChecked() == true) {
                        amt = amt / 100 * 107;
                    }
                    else{//false gst
                        amt = amt;
                    }
                }

                //amt = amt/peoplee;
                //String total;
                //total = String.format("%.2f",Double.toString(amt));
                //total = Double.toString(String,format("%.2f", amt)  );
                //int nopeoplw = people.getText();
                result.setText(String.format("%.2f", amt/peoplee));
                //result.setText(String.format("%.2f", amt));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                etAmt.setText("");
                result.setText("");
                people.setText("");
            }
        });
    }
}
