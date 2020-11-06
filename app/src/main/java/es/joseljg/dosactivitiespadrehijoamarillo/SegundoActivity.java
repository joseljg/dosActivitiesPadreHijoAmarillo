package es.joseljg.dosactivitiespadrehijoamarillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {
    public static final String EXTRA_MENSAJE2 = "es.joseljg.SegundoActivity.mensaje" ;
    EditText edt_mensaje2 = null;
    TextView txt_recibido2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        Intent intent = getIntent();
        String mensaje = intent.getStringExtra(MainActivity.EXTRA_MENSAJE1);
        txt_recibido2 = (TextView) findViewById(R.id.txt_recibido2);
        txt_recibido2.setText(mensaje);
        txt_recibido2.setVisibility(View.VISIBLE);
        edt_mensaje2 = (EditText) findViewById(R.id.edt_mensaje2);
        Log.i("estados", "estoy en oncreate del SegundoActivity");
    }

    //--------------------------------------------------------
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("estados", "estoy en onstart del SegundoActivity");
    }
    //--------------------------------------------------------

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("estados", "estoy en onresume del SegundoActivity");
    }
    //-------------------------------------------------------
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("estados", "estoy en onpause del SegundoActivity");
    }
    //-------------------------------------------------------
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("estados", "estoy en onstop del SegundoActivity");
    }
    //------------------------------------------------------
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("estados", "estoy en ondestroy del SegundoActivity");
    }
    //------------------------------------------------------

    public void enviar(View view) {
      String mensaje = String.valueOf(edt_mensaje2.getText());
      Intent intent = new Intent(this, MainActivity.class);
      intent.putExtra(EXTRA_MENSAJE2, mensaje);
      setResult(RESULT_OK,intent);
      finish();
    }
}