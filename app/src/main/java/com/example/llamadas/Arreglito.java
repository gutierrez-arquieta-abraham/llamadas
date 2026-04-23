package com.example.llamadas;

import java.util.ArrayList;

public class Arreglito {
    ArrayList<Clasesita> allamditas = new ArrayList<Clasesita>();
    public void agregar (Clasesita objetito){
        allamditas.add(objetito);
    }

    public ArrayList<Clasesita> regresar() {
        return allamditas;
    }

}
