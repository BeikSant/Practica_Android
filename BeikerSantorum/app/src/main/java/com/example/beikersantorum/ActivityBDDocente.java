package com.example.beikersantorum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.beikersantorum.adapter.DocenteAdapter;
import com.example.beikersantorum.helper.HelperBDDocente;
import com.example.beikersantorum.modelos.Docente;

import java.util.ArrayList;
import java.util.List;

public class ActivityBDDocente extends AppCompatActivity implements View.OnClickListener {

    EditText cajaCedula, cajaApellidos, cajaNombres;
    Button botonGuardar, botonModificar, botonEliminar, botonEliminarTodos, botonBuscar, botonBuscarTodos;
    TextView datos;
    RecyclerView recyclerView;
    List<Docente> lista;
    HelperBDDocente helper;
    DocenteAdapter docenteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_d_docente);
        cargarComponentes();
        helper = new HelperBDDocente(this, "bdal", null, 1);
        lista = new ArrayList<Docente>();
        lista = helper.getAllDocentes();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        docenteAdapter = new DocenteAdapter(lista);
    }

    private void cargarComponentes(){
        cajaCedula = findViewById(R.id.txtCedulaDBHelper);
        cajaApellidos = findViewById(R.id.txtApellidosDBHelper);
        cajaNombres = findViewById(R.id.txtNombresDBHelper);
        botonGuardar = findViewById(R.id.btnGuardarDBHelper);
        botonModificar = findViewById(R.id.btnModificarDBHelper);
        botonEliminar = findViewById(R.id.btnEliminarCedulaDBHelper);
        botonEliminarTodos = findViewById(R.id.btnEliminarTodosDBHelper);
        botonBuscar = findViewById(R.id.btnBuscarDBHelper);
        botonBuscarTodos = findViewById(R.id.btnBuscarTodosDBHelper);

        datos = findViewById(R.id.lblDatosDBHelper);

        recyclerView = findViewById(R.id.recyclerDocente);

        botonGuardar.setOnClickListener(this);
        botonModificar.setOnClickListener(this);
        botonEliminar.setOnClickListener(this);
        botonEliminarTodos.setOnClickListener(this);
        botonBuscar.setOnClickListener(this);
        botonBuscarTodos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Docente docente = new Docente(cajaCedula.getText().toString(),cajaApellidos.getText().toString(),cajaNombres.getText().toString());
        switch (v.getId()){
            case R.id.btnGuardarDBHelper:

                helper.insertar(docente);
                break;
            case R.id.btnBuscarTodosDBHelper:
                datos.setText(helper.leerTodos());
                break;
        }
    }
}