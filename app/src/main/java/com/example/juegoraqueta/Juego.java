package com.example.juegoraqueta;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

public class Juego extends View {
    float cx = 540 , cy = 300;
    float posx = 400;
    int radio = 30;
    int time = 0;
    int dirx = 1;
    int diry = 1;
    int velocidad = 10;



    public Juego(Context context) {


        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {

        Paint b =  new Paint();
        b.setColor(Color.parseColor("#FF03DAC5"));
        b.setStrokeWidth(20);

        Rect player = new Rect(Math.round(posx), 1850, Math.round(posx) + 300, 1900);
        canvas.drawRect(player, b);

        canvas.drawCircle(cx, cy, radio, b);

        time = time + 1;

        movimientoBola();
        colision();
        golpe(player);
        invalidate();














        super.onDraw(canvas);




    }

    private void movimientoBola(){
        cx += dirx*velocidad;
        cy += diry*velocidad;
    }

    private void colision(){
        if (cx > 1050){dirx = -1;}
        if (cx < 0){dirx = 1;}
        if (cy > 2000){diry = -1;} //TODO implementar si baja de la barra quitar vida
        if (cy < 250){diry = 1;}

    }

    private void golpe(Rect player){

        Rect pelota = new Rect(Math.round(cx) - 15, Math.round(cy)+15, Math.round(cx)+15, Math.round(cy)-15);

        if(player.intersect(pelota)){
            diry = -1;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN: posx = event.getX();

        }




        return super.onTouchEvent(event);
    }
}
