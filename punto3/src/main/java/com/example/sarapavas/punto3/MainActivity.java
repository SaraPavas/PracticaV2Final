package com.example.sarapavas.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    EditText elado;
    EditText eradio;
    EditText ebase;
    EditText ealtura;
    TextView tresultado;
    TextView terror;
    private RadioGroup Rgroup;
    boolean control = false;
    int opcion=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elado = (EditText) findViewById(R.id.elado);
        eradio = (EditText) findViewById(R.id.eradio);
        ebase = (EditText) findViewById(R.id.ebase);
        ealtura = (EditText) findViewById(R.id.ealtura);
        tresultado = (TextView) findViewById(R.id.tresultado);
        terror = (TextView) findViewById(R.id.terror);
        Rgroup = (RadioGroup)findViewById(R.id.Rgroup);
        Button bcalcular = (Button) findViewById(R.id.bcalcular);
        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sradio;
                String slado;
                String sbase;
                String saltura;
                double radio, resultado;
                double lado, base, altura;

                switch (opcion){
                    case 1:
                        slado = elado.getText().toString();
                        if(TextUtils.isEmpty(slado)){
                            terror.setText("Espacios sin completar");
                            break;}
                        if(!TextUtils.isEmpty(slado)){
                            lado = Double.parseDouble(elado.getText().toString());
                            resultado = Math.pow(lado, 2);
                            tresultado.setText("Resultado es: "+Double.toString(+resultado));}
                        break;
                    case 2:
                        sradio = eradio.getText().toString();
                        if(TextUtils.isEmpty(sradio)){
                            terror.setText("Espacios sin completar");
                            break;}
                        if(!TextUtils.isEmpty(sradio)){
                            radio = Double.parseDouble(eradio.getText().toString());
                            resultado = Math.PI*Math.pow(radio,2);
                            tresultado.setText("Resultado es: "+Double.toString(+resultado));}
                        break;
                    case 3:
                        sbase = ebase.getText().toString();
                        saltura = ealtura.getText().toString();
                        if(TextUtils.isEmpty(sbase) || TextUtils.isEmpty(saltura)){
                            terror.setText("Espacios sin completar");
                            break;}
                        if(!TextUtils.isEmpty(sbase) || !TextUtils.isEmpty(saltura)){
                            base = Double.parseDouble(ebase.getText().toString());
                            altura = Double.parseDouble(ealtura.getText().toString());
                            resultado = base*altura;
                            tresultado.setText("Resultado es: "+Double.toString(+resultado));}
                        break;
                    case 4:
                        sbase = ebase.getText().toString();
                        saltura = ealtura.getText().toString();
                        if(TextUtils.isEmpty(sbase) || TextUtils.isEmpty(saltura)){
                            terror.setText("Espacios sin completar");
                            break;}
                        if(!TextUtils.isEmpty(sbase) || !TextUtils.isEmpty(saltura)){
                            base = Double.parseDouble(ebase.getText().toString());
                            altura = Double.parseDouble(ealtura.getText().toString());
                            resultado = 0.5*base*altura;
                            tresultado.setText("Resultado es: "+Double.toString(+resultado));}
                        break;
                    case 5:
                        terror.setText("No ha elegido una opción");

                }
                Rgroup.clearCheck();



            }
        });
    }






    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()) {
            case R.id.rbcuadro:
                if (checked) {
                    elado.setEnabled(true);
                    eradio.setEnabled(false);
                    ealtura.setEnabled(false);
                    ebase.setEnabled(false);
                    eradio.getText().clear();
                    ebase.getText().clear();
                    ealtura.getText().clear();
                    terror.setText("");
                    tresultado.setText("");
                    opcion = 1;
                }
                break;
            case R.id.rbcirculo:
                if (checked) {
                    eradio.setEnabled(true);
                    elado.setEnabled(false);
                    ealtura.setEnabled(false);
                    ebase.setEnabled(false);
                    elado.getText().clear();
                    ebase.getText().clear();
                    ealtura.getText().clear();
                    terror.setText("");
                    tresultado.setText("");
                    opcion = 2;
                }
                break;
            case R.id.rbrectangulo:
                if (checked) {
                    eradio.setEnabled(false);
                    elado.setEnabled(false);
                    ebase.setEnabled(true);
                    ealtura.setEnabled(true);
                    ebase.getText().clear();
                    ealtura.getText().clear();
                    eradio.getText().clear();
                    elado.getText().clear();
                    terror.setText("");
                    tresultado.setText("");
                    opcion = 3;
                }
                break;
            case R.id.rbtriangulo:
                if (checked) {
                    eradio.setEnabled(false);
                    elado.setEnabled(false);
                    ebase.setEnabled(true);
                    ealtura.setEnabled(true);
                    ebase.getText().clear();
                    ealtura.getText().clear();
                    eradio.getText().clear();
                    elado.getText().clear();
                    terror.setText("");
                    tresultado.setText("");
                    opcion = 4;
                }
                break;
        }
    }


}
