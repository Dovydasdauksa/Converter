package lt.vtmc.ems.zwaclaw.mycrazyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;

    private Button convertButton;
    private Button resetButton;

    private TextView kilometreResult;
    private TextView centemetreResult;
    private TextView mileResult;
    private TextView yardResult;
    private TextView footResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = (EditText) findViewById(R.id.inputNumber);

        convertButton = (Button) findViewById(R.id.convertButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        kilometreResult = (TextView) findViewById(R.id.kilometreResult);
        centemetreResult = (TextView) findViewById(R.id.centimetreResult);
        mileResult = (TextView) findViewById(R.id.mileResult);
        yardResult = (TextView) findViewById(R.id.yardResult);
        footResult = (TextView) findViewById(R.id.footResult);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("##.##");
                double result = Double.parseDouble(inputNumber.getText().toString());
                kilometreResult.setText(String.valueOf(df.format(result / 100000)));
                centemetreResult.setText(String.valueOf(df.format(result)));
                mileResult.setText(String.valueOf(df.format(result / 160934.4)));
                yardResult.setText(String.valueOf(df.format(result / 91.44)));
                footResult.setText(String.valueOf(df.format(result / 30.48)));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kilometreResult.setText("00.00");
                centemetreResult.setText("00.00");
                mileResult.setText("00.00");
                yardResult.setText("00.00");
                footResult.setText("00.00");
            }
        });
    }
}
