package com.example.ladm_u2_coposdenieve

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo(ventana:MainActivity):View(ventana) {

    val ventana = ventana


    var estado = arrayOf(Color.BLUE,Color.BLACK,Color.rgb(227,144,22))
    val titulo = arrayOf("Mañana","Noche","Tarde")
    val cantidad= arrayOf(45,100,200)
    var con=0


    val copos0= Array<Copos>(1,{ Copos(this) })
    val copos1= Array<Copos>(50,{ Copos(this) })
    val copos2= Array<Copos>(200,{ Copos(this) })


    val corutina = GlobalScope.launch {
        while (true){
            ventana.runOnUiThread {
                invalidate()
            }
            delay(100L)
        }
    }


    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        var p = Paint()
        ventana.setTitle("Ahumada,CHIHUAHUA ${titulo[con]}")

        if (con<3) {
            c.drawColor(estado[con])
            //  c.drawText(titulo[con], 600f, 300f, p)
        }


        p.style=Paint.Style.FILL_AND_STROKE
        p.strokeWidth=20f
        p.color=Color.DKGRAY
        c.drawRect(50f,600f,450f,1700f,p)
        p.color=Color.rgb(48,39,64)
        c.drawRect(0f,1700f,1500f,2040f,p)

        //lampara
        c.drawLine(550f,850f,500f,1700f,p)



        p.color=Color.YELLOW
        c.drawLine(100f,1800f,300f,1800f,p)
        c.drawLine(400f,1800f,700f,1800f,p)
        c.drawLine(800f,1800f,1000f,1800f,p)




        //cuadros
        p.style=Paint.Style.FILL
        c.drawOval(550f,850f,850f,1050f,p) //luz
        //c.drawRect(550f,850f,700f,950f,p)
        c.drawRect(100f,650f,225f,750f,p)
        p.color=Color.LTGRAY
        c.drawRect(100f,850f,225f,950f,p)
        c.drawRect(100f,1050f,225f,1150f,p)
        c.drawRect(100f,1250f,225f,1350f,p)

        p.color=Color.rgb(22,73,227)
        c.drawRect(200f,1400f,350f,1700f,p)

        //arbol
        p.color=Color.rgb(151,42,8)
        c.drawRect(850f,1500f,925f,1700f,p)
        p.color=Color.GREEN
        c.drawOval(725f,1300f,1050f,1500f,p)
        c.drawOval(800f,1200f,1000f,1325f,p)

        //moto
        p.color=Color.rgb(22,73,227)
        c.drawOval(650f,1650f,750f,1750f,p)
        c.drawOval(900f,1650f,1000f,1750f,p)
        p.color=Color.YELLOW
        c.drawOval(575f,1500f,700f,1625f,p)
        p.color=Color.rgb(100,36,214)
        c.drawLine(700f,1500f,700f,1650f,p)
        c.drawLine(900f,1550f,950f,1650f,p)
        c.drawLine(700f,1550f,900f,1550f,p)

        p.color=Color.GREEN


        if (con==0){
            for (cop in copos0){
                cop.pintar(c)
            }
        }
        if (con==2){
            for (cop in copos1){
                cop.mover()
                cop.pintar(c)
            }
        }
        if (con==1){
            for (cop in copos2){
                cop.mover()
                cop.pintar(c)
            }
        }



        p.textSize=100f
     //   c.drawText("Copos=${cantidad[con]}",50f,100f,p)
    }

}