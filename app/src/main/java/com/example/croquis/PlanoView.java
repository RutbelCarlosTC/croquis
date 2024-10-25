package com.example.croquis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class PlanoView extends View {

    private List<Ambiente> ambientes = new ArrayList<>();
    private Paint paint = new Paint();

    public PlanoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLACK); // Color de los bordes
        paint.setStyle(Paint.Style.STROKE); // Borde de los ambientes
        paint.setStrokeWidth(5); // Grosor del borde
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Ambiente ambiente : ambientes) {
            // Dibujar cada ambiente como un rectángulo
            canvas.drawRect(
                    ambiente.getX1(), ambiente.getY1(),
                    ambiente.getX2(), ambiente.getY2(),
                    paint
            );
        }
    }

    public void setAmbientes(List<Ambiente> ambientes) {
        this.ambientes.clear();
        this.ambientes.addAll(ambientes);
        invalidate(); // Redibujar el plano
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (Ambiente ambiente : ambientes) {
                if (event.getX() >= ambiente.getX1() && event.getX() <= ambiente.getX2() &&
                        event.getY() >= ambiente.getY1() && event.getY() <= ambiente.getY2()) {
                    // Mostrar ventana emergente con información del ambiente
                    showAmbienteInfo(ambiente);
                    return true;
                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void showAmbienteInfo(Ambiente ambiente) {
        // Crear y mostrar el diálogo con información del ambiente
        FragmentActivity activity = (FragmentActivity) getContext();
        AmbienteDialogFragment dialog = AmbienteDialogFragment.newInstance(ambiente);
        dialog.show(activity.getSupportFragmentManager(), "ambiente_info");
    }
}

