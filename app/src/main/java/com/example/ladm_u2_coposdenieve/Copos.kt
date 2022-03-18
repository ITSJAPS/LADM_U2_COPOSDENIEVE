package com.example.ladm_u2_coposdenieve

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import kotlin.random.Random

class Copos(l:Lienzo){
    val l = l
    var x = 0f
    var y = 0f
    var movX = 0f
    var movY = 0f
    val imagen= BitmapFactory.decodeResource(l.resources,R.drawable.pop)
    val plano= BitmapFactory.decodeResource(l.resources,R.drawable.plano)
    var posPlano=0f



    //Constructor

    val moverAPlano = object : CountDownTimer(20000,80){
        override fun onTick(p0: Long) {
            posPlano+=10
            if(posPlano>=1080){
                posPlano=-50f
               l.con++
                if(l.con==2) l.con = 2
                if(l.con==3) l.con = 0


            }
            l.invalidate()
        }

        override fun onFinish() {
            start()
        }
    }

    init {
        x = rand(1000)
        y = rand(1000)
        movX = rand(6)+2
        movY = rand(6)+2

        moverAPlano.start()

    }

    private fun rand(hasta:Int):Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun mover() {
        x
        y += movY

        /*var maxX =x+100
        var minX =x-100
        if (x < 40 ) {
            movX +maxX
        }
        if( x > l.width-40) {
            movX -minX
        }
         */
        if (y > l.height - 40) {
            y = 0f

        }
    }
        fun pintar(c: Canvas) {
            var p = Paint()

            //c.drawCircle(x,y,25f,p)
            c.drawBitmap(plano, posPlano, 100f, p)
            c.drawBitmap(imagen, x, y, p)


        }



}