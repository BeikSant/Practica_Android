package com.example.beikersantorum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.beikersantorum.controlador.swvolley.ServicioWebVolley;
import com.example.beikersantorum.modelos.Alumno;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;

public class ActivityVolleyAlumno extends AppCompatActivity {

    EditText cajaId, cajaNombre, cajaDireccion;
    Button botonGuardar, botonBuscarTodos;
    TextView datos;
    RecyclerView recyclerViewAlumno;

    ServicioWebVolley servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_alumno);
        cargarComponentes();
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Le diste click al boton");
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(Integer.parseInt(cajaId.getText().toString()));
                alumno.setNombre(cajaNombre.getText().toString());
                alumno.setDireccion(cajaDireccion.getText().toString());
                System.out.println(alumno.getIdAlumno());
                System.out.println(alumno.getNombre());
                System.out.println(alumno.getDireccion());
                try {
                    boolean estado = servicio.insertar(alumno);
                    if (estado){
                        Toast.makeText(ActivityVolleyAlumno.this, "Alumno Registrado", Toast.LENGTH_SHORT).show();
                        System.out.println("Registrado");
                    }else{
                        Toast.makeText(ActivityVolleyAlumno.this, "Alumno No Registrado", Toast.LENGTH_SHORT).show();
                        System.out.println("No Registrado");
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void cargarComponentes(){
        cajaId = findViewById(R.id.txtIdAlumnoVolley);
        cajaNombre = findViewById(R.id.txtNombreAlumnoVolley);
        cajaDireccion = findViewById(R.id.txtDireccionAlumnoVolley);
        datos = findViewById(R.id.lblDatosAlumnoVolley);
        botonGuardar = findViewById(R.id.btnGuardarVolley);
        botonBuscarTodos = findViewById(R.id.btnBuscarTodosVolley);
        System.out.println("Se cargan componentes");

    }
}