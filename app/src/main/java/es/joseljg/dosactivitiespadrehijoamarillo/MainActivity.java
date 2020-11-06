package es.joseljg.dosactivitiespadrehijoamarillo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MENSAJE1 = "es.joseljg.MainActivity.mensaje1";
    private static final int PETICION1 = 1;
    private static final String EXTRA_RESPUESTA1 = "es.joseljg.MainActivity.respuesta1" ;
    EditText edt_mensaje1 = null;
    TextView txt_recibido1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_mensaje1 = (EditText) findViewById(R.id.edt_mensaje1);
        txt_recibido1 = (TextView) findViewById(R.id.txt_recibido1);
        Log.i("estados", "estoy en oncreate del MainActivity");
        if(savedInstanceState != null)
        {
            String mensaje = savedInstanceState.getString(EXTRA_RESPUESTA1);
            txt_recibido1.setText(mensaje);
            txt_recibido1.setVisibility(View.VISIBLE);
        }
    }
    //--------------------------------------------------------
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("estados", "estoy en onstart del MainActivity");
    }
    //--------------------------------------------------------


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String mensaje =String.valueOf(txt_recibido1.getText());
        outState.putString(EXTRA_RESPUESTA1,mensaje);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("estados", "estoy en onresume del MainActivity");
    }
    //-------------------------------------------------------
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("estados", "estoy en onpause del MainActivity");
    }
    //-------------------------------------------------------
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("estados", "estoy en onstop del MainActivity");
    }
    //------------------------------------------------------
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("estados", "estoy en ondestroy del MainActivity");
    }
    //------------------------------------------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PETICION1)
        {
           if(resultCode == RESULT_OK)
           {
               String mensaje = data.getStringExtra(SegundoActivity.EXTRA_MENSAJE2);
               txt_recibido1.setText(mensaje);
               txt_recibido1.setVisibility(View.VISIBLE);
               edt_mensaje1.setText("");
           }
        }

    }

    public void enviar(View view) {
        String mensaje1 = String.valueOf(edt_mensaje1.getText());
        Intent intent = new Intent(this, SegundoActivity.class);
        intent.putExtra(EXTRA_MENSAJE1, mensaje1);
        startActivityForResult(intent , PETICION1);
    }

}