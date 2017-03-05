package itsco.edu.listadetareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btnok,btnCancel;

    private EditText txttitulo,txtdesc,txtfecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnok=(Button) findViewById(R.id.btnok);
        btnCancel=(Button)findViewById(R.id.btncancel);
        txtdesc =(EditText) findViewById(R.id.txtdesc);
        txttitulo=(EditText)findViewById(R.id.txttitulo);
        txtfecha=(EditText)findViewById(R.id.txtfecha);

        btnok.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==btnok.getId()){
            Tarea t= new Tarea();

            t.setFecha(txtfecha.getText().toString());
            t.setTitulo(txttitulo.getText().toString());
            t.setDescripcion(txtdesc.getText().toString());

            Intent data=getIntent();
            data.putExtra("TITULO",txttitulo.getText().toString());
            setResult(RESULT_OK,data);
            data.putExtra("DESCRIPCION",txtdesc.getText().toString());
            setResult(RESULT_OK,data);
            data.putExtra("FECHA",txtfecha.getText().toString());
            setResult(RESULT_OK,data);

            finish();
        }
        if (v.getId()==btnCancel.getId()){
    setResult(RESULT_CANCELED);
}

    }
}
