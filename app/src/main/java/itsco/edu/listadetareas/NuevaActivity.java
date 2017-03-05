package itsco.edu.listadetareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevaActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnOk;
    private Button btnCancelar;


    private EditText txtTitulo;
    private EditText txtDescripcion;
    private EditText txtFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);

        btnCancelar = (Button) findViewById(R.id.btn_cancelar);
        btnOk = (Button) findViewById(R.id.btn_guardar);

        btnOk.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        txtTitulo = (EditText) findViewById(R.id.txt_titulo);
        txtDescripcion = (EditText) findViewById(R.id.txt_descripcion);
        txtFecha = (EditText) findViewById(R.id.txt_fecha);
    }


    @Override
    public void onClick(View view) {


        if (view.getId() == btnOk.getId()) {
            Intent data = getIntent();
            data.putExtra("TITULO", txtTitulo.getText().toString());
            data.putExtra("DESCRIPCION", txtDescripcion.getText().toString());

            data.putExtra("FECHA", txtFecha.getText().toString());

        }


        if (view.getId() == btnCancelar.getId()) {
            setResult(RESULT_CANCELED);

        }
            finish();

        }
    }
