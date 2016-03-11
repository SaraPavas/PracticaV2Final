package com.example.sarapavas.punto4;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ThemedSpinnerAdapter;
import android.widget.CheckBox;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int currentYear;
    private int currentMonth;
    private int currentDay;
    int mDia, mMes, mYear;
    static final int DATE_DIALOG_ID = 0;
    private Button btAceptar;
    private Button btDate;
    private TextView dateDisplay;
    private TextView tError;
    private EditText eLoggin;
    private EditText ePassword;
    private EditText eRepPassword;
    private EditText eEmail;
    private Spinner spCiudades;
    private TextView tResultado;
    private String hobbies="";
    private RadioGroup genero;
    CheckBox chbNadar, chbCaminar,chbLeer,chbCine;
    String loggin ,password,email,ciudad,fecha,sexo;
    private String[] hobbies_a = new String[]{"","","",""};
    String spinner_ciudad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] ciudad = new String[]{"LugarDeNacimiento","Medellin","Bogota","Cali","Barranquilla", "Pasto"};
        genero = (RadioGroup)findViewById(R.id.genero);
        dateDisplay = (TextView) findViewById(R.id.dateDisplay);
        tError = (TextView) findViewById(R.id.tError);
        eLoggin = (EditText)findViewById(R.id.eLoggin);
        ePassword = (EditText)findViewById(R.id.ePassword);
        eRepPassword = (EditText)findViewById(R.id.eRepPassword);
        eEmail = (EditText)findViewById(R.id.eEmail);
        btAceptar = (Button) findViewById(R.id.btAceptar);
        btDate = (Button) findViewById(R.id.btDate);
        tResultado = (TextView)findViewById(R.id.tResultado);
        chbCaminar = (CheckBox)findViewById(R.id.chbCaminar);
        chbNadar = (CheckBox)findViewById(R.id.chbNadar);
        chbLeer = (CheckBox)findViewById(R.id.chbLeer);
        chbCine = (CheckBox)findViewById(R.id.chbCine);

        //Fecha de nacimiento
        final Calendar c = Calendar.getInstance();
        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);

        btDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        //Lugar de Nacimiento
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, ciudad);
        spCiudades = (Spinner)findViewById(R.id.spCiudades);
        spCiudades.setAdapter(adapter);

        spCiudades.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                        spinner_ciudad = parent.getItemAtPosition(position).toString();
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        spinner_ciudad = "";
                    }
                });


        //ACEPTAR
        btAceptar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                boolean control;
                control=Revisar();
                if(control){
                    asignar();
                    showDatos();
                    iniciar();
                }
            }
        });

    }

    //Métodos
    public void iniciar(){

        tError.setHint("");
        eLoggin.getText().clear();
        ePassword.getText().clear();
        eRepPassword.getText().clear();
        eEmail.getText().clear();
        chbNadar.setChecked(false);
        chbCaminar.setChecked(false);
        chbLeer.setChecked(false);
        chbCine.setChecked(false);
        for (int i =0; i<4; i++){
            hobbies_a[i]="";
        }
        loggin = "";password = "";email ="";ciudad="";fecha="";hobbies="";sexo="";
        genero.clearCheck();
    }

    public void showDatos(){
        for (int i =0; i<4; i++){
            if(!TextUtils.isEmpty(hobbies_a[i]))
                hobbies = hobbies +","+ hobbies_a[i];
        }
        tResultado.setText("Loggin: "+loggin+"\n"+"e-mail: "+email+"Password: "+password+"\nFecha de Nacimiento: "+dateDisplay.getText()+"\nLugar de nacimiento: "+spinner_ciudad+
                "\nGenero: "+sexo+"\nHobbies: "+hobbies);
    }

    public void asignar(){
        loggin = eLoggin.getText().toString();
        password = ePassword.getText().toString();
        email = eEmail.getText().toString();
    }

    public boolean Revisar(){

        String sLoggin = eLoggin.getText().toString();
        String sPassword = ePassword.getText().toString();
        String sRepPassword = eRepPassword.getText().toString();
        String sEmail = eEmail.getText().toString();
        if(TextUtils.isEmpty(sLoggin) || TextUtils.isEmpty(sPassword) || TextUtils.isEmpty(sRepPassword)
                || TextUtils.isEmpty(sPassword) || TextUtils.isEmpty(sEmail)) {
            tError.setHint("Hay espacios en blanco");
            return false;
        }if(!sPassword.equals(sRepPassword)){
            tError.setHint("Las contraseñas no coinciden");
            return false;
        }if(!isEmailValid(sEmail)) {
            tError.setHint("Ingrese una dirección válida");
            return false;
        }if(mYear >= currentYear){
            if (mMes>=(currentMonth)) {
                if (mDia >= currentDay) {
                    tError.setHint("Ingrese una fecha correcta");
                    return false;
                }
            }
        }if(TextUtils.isEmpty(hobbies_a[0]) && TextUtils.isEmpty(hobbies_a[1]) && TextUtils.isEmpty(hobbies_a[2])
              && TextUtils.isEmpty(hobbies_a[3]) ){
            tError.setHint("No ha ingresado hobbies");
            return false;
        }if(TextUtils.isEmpty(sexo)){
            tError.setHint("No ha ingresado sexo");
            return false;
        }if(TextUtils.isEmpty(spinner_ciudad) ||spinner_ciudad.equals("LugarDeNacimiento") ){
            tError.setHint("No ha ingresado ciudad de nacimiento");
            return false;
        }

        return true;
    }

    public static boolean isEmailValid(String sEmail) {

        String validador = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        Pattern pattern = Pattern.compile(validador, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sEmail);
        return matcher.matches();
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, reservationDate, currentYear,
                        currentMonth, currentDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener reservationDate = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int month, int day) {
            mDia = day;
            mMes = month;
            mYear = year;
            dateDisplay.setText((mMes+1) + " / " + (mDia)+ " / " + mYear);
        }

    };

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbFem:
                if (checked) {
                    sexo = "Femenino";
                }
                break;
            case R.id.rbMasc:
                if (checked) {
                    sexo = "Masculino";
                }
                break;

        }
    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.chbNadar:
                if (checked)
                    hobbies_a[0]="Nadar\t";
                else
                    hobbies_a[0]="";
                break;
            case R.id.chbCaminar:
                if (checked)
                    hobbies_a[1] = "Caminar\t";
                else
                    hobbies_a[1]="";
                break;
            case R.id.chbCine:
                if (checked)
                    hobbies_a[2] = "Ir a cine\t";
                else
                    hobbies_a[2]="";
                break;
            case R.id.chbLeer:
                if (checked)
                    hobbies_a[3] = "Leer,\t";
                else
                    hobbies_a[3]="";
                break;
        }
    }
}
