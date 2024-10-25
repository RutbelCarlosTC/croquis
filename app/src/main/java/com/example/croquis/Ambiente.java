package com.example.croquis;

import android.os.Parcel;
import android.os.Parcelable;

public class Ambiente implements Parcelable {
    private String nombre;
    private String descripcion;
    private float x1, y1, x2, y2;

    // Constructor
    public Ambiente(String nombre, String descripcion, float x1, float y1, float x2, float y2) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getX1() {
        return x1;
    }

    public float getY1() {
        return y1;
    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }

    // Métodos Parcelable
    protected Ambiente(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        x1 = in.readFloat();
        y1 = in.readFloat();
        x2 = in.readFloat();
        y2 = in.readFloat();
    }

    public static final Creator<Ambiente> CREATOR = new Creator<Ambiente>() {
        @Override
        public Ambiente createFromParcel(Parcel in) {
            return new Ambiente(in);
        }

        @Override
        public Ambiente[] newArray(int size) {
            return new Ambiente[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeFloat(x1);
        dest.writeFloat(y1);
        dest.writeFloat(x2);
        dest.writeFloat(y2);
    }
}
