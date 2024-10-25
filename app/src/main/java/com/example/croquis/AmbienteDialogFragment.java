package com.example.croquis;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AmbienteDialogFragment extends DialogFragment {

    public static AmbienteDialogFragment newInstance(Ambiente ambiente) {
        AmbienteDialogFragment fragment = new AmbienteDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable("ambiente", ambiente); // Pasar el ambiente seleccionado
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Obtener el ambiente desde los argumentos
        Ambiente ambiente = getArguments().getParcelable("ambiente");

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(ambiente.getNombre())
                .setMessage(ambiente.getDescripcion())
                .setPositiveButton("Cerrar", (dialog, which) -> dialog.dismiss());

        return builder.create();
    }
}