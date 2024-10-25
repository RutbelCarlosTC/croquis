package com.example.croquis;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PlanoViewModel extends ViewModel {

    private MutableLiveData<List<Ambiente>> ambientes;

    public LiveData<List<Ambiente>> getAmbientes() {
        if (ambientes == null) {
            ambientes = new MutableLiveData<>();
            cargarDatosDesdeArchivo();
        }
        return ambientes;
    }

    private void cargarDatosDesdeArchivo() {
        // Simulación de la carga de datos desde un archivo
        List<Ambiente> listaAmbientes = new ArrayList<>();
        // Aquí es donde leerías los datos reales de un archivo, por ejemplo, un archivo JSON
        listaAmbientes.add(new Ambiente("Room 1", "Descripción del Room 1", 100, 100, 400, 400));
        listaAmbientes.add(new Ambiente("Room 2", "Descripción del Room 2", 450, 100, 750, 400));

        ambientes.setValue(listaAmbientes); // Actualizar LiveData
    }
}
