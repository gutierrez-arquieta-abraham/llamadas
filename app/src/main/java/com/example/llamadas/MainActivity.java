package com.example.llamadas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Scanner;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button BLocal,BNacional,BInternacional,BPagar;
    EditText editadito1;
    TableLayout vistita;
    TextView totalfinal;
    Arreglito arreglito = new Arreglito();
    ArrayList<Clasesita> aRegreso = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editadito1 = findViewById(R.id.edit1);
        BLocal = findViewById(R.id.BLocal);
        BNacional = findViewById(R.id.BNacional);
        BInternacional = findViewById(R.id.BInternacional);
        BPagar = findViewById(R.id.BPagar);
        vistita = findViewById(R.id.tablaLlamadas);
        totalfinal = findViewById(R.id.totalfinal);
        BLocal.setOnClickListener(this);
        BNacional.setOnClickListener(this);
        BInternacional.setOnClickListener(this);
        BPagar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String cadenita = ((Button)v).getText().toString();
        int condicion = leerentero();
        int total = 0;
        if (condicion!=-1){
            if (cadenita.equals("Local")){
                int duracion = leerentero();
                Clasesita objetito = new Clasesita();
                objetito.setTipo(1);
                objetito.setDuracion(duracion);
                objetito.setCosto(1 * duracion);
                arreglito.agregar(objetito);
                Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
            }
            else {
                if (cadenita.equals("Nacional")){
                    int duracion = leerentero();
                    Clasesita objetito = new Clasesita();
                    objetito.setTipo(2);
                    objetito.setDuracion(duracion);
                    objetito.setCosto(2 * duracion);
                    arreglito.agregar(objetito);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (cadenita.equals("Internacional")){
                        int duracion = leerentero();
                        Clasesita objetito = new Clasesita();
                        objetito.setTipo(3);
                        objetito.setDuracion(duracion);
                        objetito.setCosto(3 * duracion);
                        arreglito.agregar(objetito);
                        Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (cadenita.equals("Pagar")){
                            aRegreso = arreglito.regresar();
                            int cuantos = aRegreso.size();
                            for (int i = 0; i < cuantos; i++) {
                                TableRow fila = new TableRow(this);
                                TextView txtTipo = new TextView(this);
                                TextView txtDuracion = new TextView(this);
                                TextView txtCosto = new TextView(this);

                                txtTipo.setText(String.valueOf(aRegreso.get(i).getTipo()));
                                txtDuracion.setText(String.valueOf(aRegreso.get(i).getDuracion()));
                                txtCosto.setText(String.valueOf(aRegreso.get(i).getCosto()));
                                fila.addView(txtTipo);
                                fila.addView(txtDuracion);
                                fila.addView(txtCosto);
                                vistita.addView(fila);
                                total = total + aRegreso.get(i).getCosto();
                            }
                            totalfinal.setText("Total: " + String.valueOf(total));
                        }
                    }
                }
            }
        }
        else{
            Toast.makeText(this, "Ingresa un numero valido", Toast.LENGTH_SHORT).show();
        }
    }
    public int leerentero() { //este codigo ya se habia ocupado en los proyectos de 3er semestre
        try {
            return Integer.parseInt(editadito1.getText().toString());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}