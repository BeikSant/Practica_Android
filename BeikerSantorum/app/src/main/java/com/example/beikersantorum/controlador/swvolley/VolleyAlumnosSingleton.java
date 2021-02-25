package com.example.beikersantorum.controlador.swvolley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyAlumnosSingleton {
    private RequestQueue queue;
    private Context context;
    private static VolleyAlumnosSingleton miInstancia;

    public VolleyAlumnosSingleton(Context context){
        this.context = context;
    }

    public RequestQueue getReferenceQueue(){
        if (queue == null){
            queue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return queue;
    }

    public static synchronized VolleyAlumnosSingleton getInstance(Context context){
        if (miInstancia == null){
            miInstancia = new VolleyAlumnosSingleton(context);
        }
        return miInstancia;
    }

    public <T> void addToRequestQueue(Request request){
        queue.add(request);
    }
}
