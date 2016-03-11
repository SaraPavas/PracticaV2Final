package com.example.sarapavas.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    EditText enumero1;
    EditText enumero2;
    EditText edittext;
    RadioGroup rgSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enumero1 = (EditText) findViewById(R.id.enumero1);
        enumero2 = (EditText) findViewById(R.id.enumero2);
        rgSelect = (RadioGroup) findViewById(R.id.rgSelect);

    }
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        String snum1;
        String snum2;
        int num1;
        int num2;
        double resultado;

        switch(view.getId()) {
            case R.id.rbsuma:
                if (checked) {

                    snum1 = enumero1.getText().toString();
                    snum2 = enumero2.getText().toString();
                    if (TextUtils.isEmpty(snum1) || TextUtils.isEmpty(snum2)) {
                        Toast.makeText(this, "Espacios sin completar", Toast.LENGTH_LONG).show();
                        break;}
                    if (!TextUtils.isEmpty(snum1) || !TextUtils.isEmpty(snum2)){
                        num1 = Integer.parseInt(enumero1.getText().toString());
                        num2 = Integer.parseInt(enumero2.getText().toString());
                        resultado = num1 + num2;
                        Toast.makeText(this, "El Resultado de la suma es: " + resultado, Toast.LENGTH_LONG).show();}
                }break;
            case R.id.rbresta:
                if (checked){
                    snum1 = enumero1.getText().toString();
                    snum2 = enumero2.getText().toString();
                    if (TextUtils.isEmpty(snum1) || TextUtils.isEmpty(snum2)) {
                        Toast.makeText(this, "Espacios sin completar", Toast.LENGTH_LONG).show();
                        break;}
                    if (!TextUtils.isEmpty(snum1) || !TextUtils.isEmpty(snum2)) {
                        num1 = Integer.parseInt(enumero1.getText().toString());
                        num2 = Integer.parseInt(enumero2.getText().toString());
                        resultado = num1 - num2;
                        Toast.makeText(this, "El Resultado de la resta es: " + resultado, Toast.LENGTH_LONG).show();}
                }break;
            case R.id.rbmulticacion:
                if(checked) {
                    snum1 = enumero1.getText().toString();
                    snum2 = enumero2.getText().toString();
                    if (TextUtils.isEmpty(snum1) || TextUtils.isEmpty(snum2)) {
                        Toast.makeText(this, "Espacios sin completar", Toast.LENGTH_LONG).show();
                        break;}
                    if (!TextUtils.isEmpty(snum1) || !TextUtils.isEmpty(snum2)) {
                        num1 = Integer.parseInt(enumero1.getText().toString());
                        num2 = Integer.parseInt(enumero2.getText().toString());
                        resultado = num1 * num2;
                        Toast.makeText(this, "El Resultado de la multiplicación es: " + resultado, Toast.LENGTH_LONG).show();}
                }break;
            case R.id.rbdivision:
                if(checked) {
                    snum1 = enumero1.getText().toString();
                    snum2 = enumero2.getText().toString();
                    if (TextUtils.isEmpty(snum1) || TextUtils.isEmpty(snum2)) {
                        Toast.makeText(this, "Espacios sin completar", Toast.LENGTH_LONG).show();
                        break;
                    }
                    if (!TextUtils.isEmpty(snum1) || !TextUtils.isEmpty(snum2)) {
                        num1 = Integer.parseInt(enumero1.getText().toString());
                        num2 = Integer.parseInt(enumero2.getText().toString());
                        if (num2 == 0)
                            Toast.makeText(this, "No es posbile dividir por cero", Toast.LENGTH_LONG).show();
                        else {
                            resultado = 1.0f * num1 / num2;
                            Toast.makeText(this, "El Resultado de la división es: " + resultado, Toast.LENGTH_LONG).show();
                        }
                    }
                }break;
        }


    }

}
