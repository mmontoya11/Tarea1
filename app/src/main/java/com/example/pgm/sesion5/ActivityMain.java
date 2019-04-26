package com.example.pgm.sesion5;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class ActivityMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Limpiar = findViewById(R.id.limpiarButton);
        Spinner spinner = findViewById(R.id.Spinner1);


       AutoCompleteTextView AutoComplete = findViewById(R.id.auto_complete_text);
        ArrayAdapter<CharSequence> adapterLibro = ArrayAdapter.createFromResource(this,
                R.array.Arry_libros, android.R.layout.simple_dropdown_item_1line);
        AutoComplete.setAdapter(adapterLibro);


        Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new MyDialog();
                fragment.show(getSupportFragmentManager(), "fire");
                Limipiar();

            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_main_save:
                EditText nombre= (EditText)findViewById(R.id.Activity_main_NAME);
                EditText tel= (EditText)findViewById(R.id.Activity_main_PHONE);
                Spinner escolaridad= (Spinner) findViewById(R.id.Spinner1);
                RadioGroup generos = (RadioGroup) findViewById(R.id.Genero_radio_grup);
                RadioButton genero = (RadioButton) findViewById(generos.getCheckedRadioButtonId());
                AutoCompleteTextView libro = (AutoCompleteTextView) findViewById(R.id.auto_complete_text);
                CheckBox deporte = (CheckBox) findViewById(R.id.checkdeporte);



                Alumno alumno = new Alumno(nombre.getText().toString(),tel.getText().toString(), escolaridad.getSelectedItem().toString(), genero.getText().toString(), libro.getText().toString(), deporte.isChecked());
                Limipiar();
                Toast.makeText(this, alumno.toString(), LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Limipiar(){
        EditText nombre= (EditText)findViewById(R.id.Activity_main_NAME);
        EditText tel= (EditText)findViewById(R.id.Activity_main_PHONE);
        Spinner escolaridad= (Spinner) findViewById(R.id.Spinner1);
        RadioGroup generos = (RadioGroup) findViewById(R.id.Genero_radio_grup);
        AutoCompleteTextView libro = (AutoCompleteTextView) findViewById(R.id.auto_complete_text);
        CheckBox deporte = (CheckBox) findViewById(R.id.checkdeporte);

        nombre.setText("");
        tel.setText("");
        libro.setText("");
        escolaridad.setSelection(0);
        if(deporte.isChecked())
            deporte.setChecked(false);

    }
}
