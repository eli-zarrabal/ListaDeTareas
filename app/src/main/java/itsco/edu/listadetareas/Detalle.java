package itsco.edu.listadetareas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    private TextView txttitulo;
    private TextView txtdesc;
    private TextView txtfecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txttitulo=(TextView)findViewById(R.id.txttitulo);
        txtdesc=(TextView)findViewById(R.id.txtdesc);
        txtfecha=(TextView)findViewById(R.id.txtfecha);

        Intent intent=getIntent();

        String titulo=intent.getStringExtra("TITULO");
        String desc=intent.getStringExtra("DESCRIPCION");
        String fecha=intent.getStringExtra("FECHA");

        txttitulo.setText(titulo);
        txtdesc.setText(desc);
        txtfecha.setText(fecha);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
