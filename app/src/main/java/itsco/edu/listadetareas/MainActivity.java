package itsco.edu.listadetareas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    public static final int NUEVA_TAREA = 10;

    private Button btnNueva;
    private ListView lista;


    private ArrayList<Tarea> data;
    private ArrayAdapter<Tarea> adapter;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tarea t=new Tarea();
        t=data.get(position);

        Intent intent=new Intent(this, DetalleActivity.class);

        intent.putExtra("TITULO", t.getTitulo());
        intent.putExtra("DESCRPCION", t.getDescripcion());
        intent.putExtra("FECHA", t.getFecha());


        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnNueva = (Button) findViewById(R.id.btn_nueva);
        btnNueva.setOnClickListener(this);

        lista = (ListView) findViewById(R.id.lista_tareas);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1, android.R.id.text1, data);
        lista.setAdapter(adapter);
        lista.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {


        Intent i = new Intent(this, NuevaActivity.class);
        startActivityForResult(i, NUEVA_TAREA);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tarea t=new Tarea();
        t=data.get(position);

        Intent intent=new Intent(this,Detalle.class);
        intent.putExtra("TITULO",t.getTitulo());
        intent.putExtra("DESCRIPCION",t.getDescripcion());
        intent.putExtra("FECHA",t.getFecha());

        startActivity(intent);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {


            if (requestCode == NUEVA_TAREA) {
                Tarea t = new Tarea();


                String titulo = data.getStringExtra("TITULO");
                String descripcion = data.getStringExtra("DESCRIPCION");
                String fecha = data.getStringExtra("FECHA");


                t.setTitulo(titulo);
                t.setDescripcion(descripcion);
                t.setFecha(fecha);

                this.data.add(t);

                //cuando datasource se actualiza
                //el adapter debe notificar  cambios
                //con el metodo notifyDataSetChanged

                adapter.notifyDataSetChanged();
            }

        }
    }
}




