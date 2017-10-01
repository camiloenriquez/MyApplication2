package com.example.camil.mypplicationfigura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv1,tv2,tv5;
    private RadioButton r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv5=(TextView)findViewById(R.id.tv5);

        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);

    }


    private void mostrarCirculo(boolean b)
    {
        r1.setVisibility(b ? View.VISIBLE : View.VISIBLE);
        r2.setVisibility(b ? View.VISIBLE : View.VISIBLE);
        r3.setVisibility(b ? View.GONE : View.VISIBLE);
        tv1.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        tv5.setVisibility(View.VISIBLE);

    }

    private void mostrarTriangulo(boolean b)
    {
        r1.setVisibility(b ? View.VISIBLE : View.GONE);
        r2.setVisibility(b ? View.VISIBLE : View.VISIBLE);
        r3.setVisibility(b ? View.VISIBLE : View.GONE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.GONE);
    }
    private void mostrarRectangulo(boolean b)
    {
        r1.setVisibility(b ? View.VISIBLE : View.GONE);
        r2.setVisibility(b ? View.VISIBLE : View.VISIBLE);
        r3.setVisibility(b ? View.VISIBLE : View.GONE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.GONE);
    }




    //Este método se ejecutará cuando se presione el botón
    public void operar(View view) {

        if (r2.isChecked() == true) {
            String valor1 = tv1.getText().toString();
            String valor2 = tv2.getText().toString();
            int nro1 = Integer.parseInt(valor1);
            int nro2 = Integer.parseInt(valor2);
            if(nro1==0||nro2==0) {
                Toast notificacion = Toast.makeText(this, "tiene que ser un numero mayor a 0", Toast.LENGTH_LONG);
                notificacion.show();
            }
            else {
                int triangulo = (nro1 * nro2) / 2;
                String resultado = String.valueOf(triangulo);

                Toast notificacion = Toast.makeText(this, "el area del resulado  del triangulo es " + resultado, Toast.LENGTH_LONG);
                notificacion.show();
            }

        } else if (r3.isChecked() == true) {

            String valor1 = tv1.getText().toString();
            String valor2 = tv2.getText().toString();
            int nro1 = Integer.parseInt(valor1);
            int nro2 = Integer.parseInt(valor2);
            if(nro1==0||nro2==0) {
                Toast notificacion = Toast.makeText(this, "tiene que ser un numero mayor a 0", Toast.LENGTH_LONG);
                notificacion.show();
            }
            else
            {
                int rectangulo = nro1 * nro2;
                String resultado = String.valueOf(rectangulo);

                Toast notificacion = Toast.makeText(this, "el area del resulado  del rectangulo es " + resultado, Toast.LENGTH_LONG);
                notificacion.show();
            }
        } else if (r1.isChecked() == true) {
            String valor5 = tv5.getText().toString();
            int nro5 = Integer.parseInt(valor5);
            if(nro5==0)
            {
                Toast notificacion = Toast.makeText(this, "tiene que ser un numero mayor a cero ", Toast.LENGTH_LONG);
                notificacion.show();
            }
            else {
                double circulo = (Math.PI * (nro5 * nro5));
                String resultado = String.valueOf(circulo);

                Toast notificacion = Toast.makeText(this, "el radio del resulado  del circulo es " + resultado, Toast.LENGTH_LONG);
                notificacion.show();
            }
        }
         else if (r2.isChecked() == false || r3.isChecked() == false || r1.isChecked() == false) {
             Toast notificacion = Toast.makeText(this, "no se ha seleccionado nada, debe seleccionar una opción", Toast.LENGTH_LONG);
             notificacion.show();
         }

    }


    // colocar un tricach para validaciones
    // ejercico que solo aparescan las cajas de texto  cuando se requieran.



    public void acercade(View view) {
        Intent i = new Intent(this, acercaDe.class );
        startActivity(i);    }

    public void onRadioButtonCliked(View view) {

        boolean marcado = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.r1:
                if (marcado) {
                    mostrarCirculo(false);
                }
                break;
            case R.id.r3:
                if (marcado) {
                    mostrarRectangulo(true);
                }

                break;

            case R.id.r2:
                if (marcado) {
                    mostrarTriangulo(true);
                } break;

        }
    }
}

