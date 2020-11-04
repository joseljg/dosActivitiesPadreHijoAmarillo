package es.joseljg.dosactivitiespadrehijoamarillo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MENSAJE1 = "es.joseljg.MainActivity.mensaje1";
    private static final int PETICION1 = 1;
    EditText edt_mensaje1 = null;
    TextView txt_recibido1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_mensaje1 = (EditText) findViewById(R.id.edt_mensaje1);
        txt_recibido1 = (TextView) findViewById(R.id.txt_recibido1);
    }

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