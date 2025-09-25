package com.example.proyecto16_recetario;

//imports de la clase
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//imports para el ejercicio
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

/*Clase listaRecetas:
* Acá muestro en un scroll view el listado de recetas
* con las imagenes y los botones de filtrado que se basan
* en setear la visibilidad de los layouts de recetas.*/
public class listaRecetas extends AppCompatActivity {

    //declaración de variables de clase
    private LinearLayout layoutReceta1, layoutReceta2, layoutReceta3, layoutReceta4, layoutReceta5;
    private Button btnPlatosFuertes, btnBebidas, btnReposteria;
    //variables booleanas para el filtrado
    private boolean platoFuerte = false;
    private boolean bebida = false;
    private boolean reposteria = false;

    private ArrayList<Recetas> recetasLista;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_recetas);

        layoutReceta1 = findViewById(R.id.layoutReceta1);
        layoutReceta2 = findViewById(R.id.layoutReceta2);
        layoutReceta3 = findViewById(R.id.layoutReceta3);
        layoutReceta4 = findViewById(R.id.layoutReceta4);
        layoutReceta5 = findViewById(R.id.layoutReceta5);

        //para crear las recetas
        recetasLista = new ArrayList<>();

        //aca se van agregando los detalles de las recetas
        // ----- ARROZ CON COCO -----
        ArrayList<String[]> ingredientesArroz = new ArrayList<>();
        ingredientesArroz.add(new String[]{"Arroz", "2kg"});
        ingredientesArroz.add(new String[]{"Cocos (extraer leche)", "2"});
        ingredientesArroz.add(new String[]{"Agua", "1 Litro"});
        ingredientesArroz.add(new String[]{"Sal", "7g"});
        ArrayList<String> pasosArroz = new ArrayList<>();
        pasosArroz.add("Lave bien el arroz y escúrrale el agua.");
        pasosArroz.add("En una olla coloque la leche de 2 cocos, una vez que ya ha hervido, agregue el arroz y la sal.");
        pasosArroz.add("Deje cocinar hasta que el arroz esté reventado y suelto.");
        recetasLista.add(new Recetas("Arroz con Coco", "platoFuerte", R.drawable.arrozconcocoplatofuerte, ingredientesArroz, pasosArroz));
        //frameDetalle.setBackground(Drawable.createFromPath("@drawable/fondoframeplatosfuertes"));

        // ----- CARNE EN SALSA CARIBEÑA -----
        ArrayList<String[]> ingredientesCarne = new ArrayList<>();
        ingredientesCarne.add(new String[]{"Costilla", "1 kilo"});
        ingredientesCarne.add(new String[]{"Aceite", "1 cda"});
        ingredientesCarne.add(new String[]{"Sal", "5 g"});
        ingredientesCarne.add(new String[]{"Azúcar", "½ cucharadita"});
        ingredientesCarne.add(new String[]{"Ajo picado", "2 dientes"});
        ingredientesCarne.add(new String[]{"Cebolla", "25 g"});
        ingredientesCarne.add(new String[]{"Tomate", "20 g"});
        ingredientesCarne.add(new String[]{"Coco", "1"});
        ingredientesCarne.add(new String[]{"Curry", "½"});
        ingredientesCarne.add(new String[]{"Apio cortado finamente", "½ rama"});
        ArrayList<String> pasosCarne = new ArrayList<>();
        pasosCarne.add("Lave la carne con abundante agua.");
        pasosCarne.add("En un recipiente agregue una cda de vinagre, una cda de sal, un ajo picado y curry. Agregue la carne y comience a marinar.");
        pasosCarne.add("Deje reposar la carne marinada durante 1 hora.");
        pasosCarne.add("En un sartén caliente, agregue 1 cda de aceite y 1 cda de azúcar. Cuando esté caramelizado, coloque la carne y déjela dorar.");
        pasosCarne.add("Después de dorar la carne, agregue ½ taza de agua y tápela.");
        pasosCarne.add("Cuando el agua se haya secado, agregue tomate, cebolla y apio picado más la leche de un coco y deje cocinar 10 minutos más.");
        recetasLista.add(new Recetas("Carne en Salsa Caribeña", "platoFuerte", R.drawable.carneensalsacaribenaplatofuerte, ingredientesCarne, pasosCarne));

        // ----- AREPA DE BANANO -----
        ArrayList<String[]> ingredientesArepa = new ArrayList<>();
        ingredientesArepa.add(new String[]{"Bananos maduros", "3"});
        ingredientesArepa.add(new String[]{"Harina", "1 taza"});
        ingredientesArepa.add(new String[]{"Huevo", "1"});
        ingredientesArepa.add(new String[]{"Canela en polvo", "1 g"});
        ingredientesArepa.add(new String[]{"Nuez moscada", "1 g"});
        ingredientesArepa.add(new String[]{" Sal", "2 g"});
        ingredientesArepa.add(new String[]{"Azúcar", "15 g"});
        ArrayList<String> pasosArepa = new ArrayList<>();
        pasosArepa.add("Pele los bananos. Colóquelos en una taza grande y con un tenedor comience a majarlos hasta que se vean como puré.");
        pasosArepa.add("Mezcle 15g de azúcar, 2g sal, 1g de canela y 1g de nuez moscada. Luego mézclelo hasta formar una pasta. Luego agrégiele el puré de banano y 1 taza de harina");
        pasosArepa.add("Agregue ½ taza de agua y mezcle nuevamente, hasta que quede semilíquido.");
        pasosArepa.add("En un sartén caliente ponga 2 cdas de aceite. Con una cuchara o cucharón,pase la mezcla al sartén, dándole forma de pancakes pequeños o medianos.");
        pasosArepa.add("Una vez que las ha freído, déjelas reposando sobre servilletas para cocina, para quitar el exceso de aceite.");
        recetasLista.add(new Recetas("Arepa de Banano", "postre", R.drawable.arepasdebananoreposteria, ingredientesArepa, pasosArepa));

        // ----- BUDÍN DE YUCA -----
        ArrayList<String[]> ingredientesBudin = new ArrayList<>();
        ingredientesBudin.add(new String[]{"Yuca", "1 kilo"});
        ingredientesBudin.add(new String[]{"Dulce molido", "2 tazas"});
        ingredientesBudin.add(new String[]{"Azúcar", "1½ taza"});
        ingredientesBudin.add(new String[]{"Agua", "2 litros"});
        ingredientesBudin.add(new String[]{"Canela", "½ cucharadita"});
        ingredientesBudin.add(new String[]{"Nuez moscada", "½ cucharadita"});
        ingredientesBudin.add(new String[]{"Sal", "¼ cucharadita"});
        ArrayList<String> pasosBudin = new ArrayList<>();
        pasosBudin.add("Pele y lave la yuca. En un recipiente comience a rallarla.");
        pasosBudin.add("Agréguele 2 tazas de dulce molido, 1/2 taza de azúcar, 1/4 de cucharadita de sal y 1/2 cucharadita de canela.");
        pasosBudin.add("Agregue 2 litros de agua y bien. Coloque la mezcla en un molde.");
        pasosBudin.add("Hornee por 50 minutos.");
        recetasLista.add(new Recetas("Budín de Yuca", "postre", R.drawable.budindeyucareposteria, ingredientesBudin, pasosBudin));

        // ----- HIEL -----
        ArrayList<String[]> ingredientesHiel = new ArrayList<>();
        ingredientesHiel.add(new String[]{"Dulce", "1 tapa"});
        ingredientesHiel.add(new String[]{"Limones criollos", "12"});
        ingredientesHiel.add(new String[]{"Jengibre", "4"});
        ingredientesHiel.add(new String[]{"Agua", "4 litros"});
        ingredientesHiel.add(new String[]{"Limones mandarina", "12"});
        ingredientesHiel.add(new String[]{"Azúcar", "1 taza"});
        ArrayList<String> pasosHiel = new ArrayList<>();
        pasosHiel.add("En una olla grande coloque 2 litros de agua, añadale 1 tapa de dulce y 1/4 de jengibre rallado.");
        pasosHiel.add("Exprima 12 limones criollos y los 12 limones mandarinas, agregue 1 taza de azúcar y 2 litros de agua. Luego mézclelo y añada hielo.");
        recetasLista.add(new Recetas("Hiel", "bebida", R.drawable.hielbebida, ingredientesHiel, pasosHiel));

        // Asignar clicks a layouts
        layoutReceta1.setOnClickListener(v -> abrirDetalle(recetasLista.get(4)));
        layoutReceta2.setOnClickListener(v -> abrirDetalle(recetasLista.get(0)));
        layoutReceta3.setOnClickListener(v -> abrirDetalle(recetasLista.get(3)));
        layoutReceta4.setOnClickListener(v -> abrirDetalle(recetasLista.get(1)));
        layoutReceta5.setOnClickListener(v -> abrirDetalle(recetasLista.get(2)));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void abrirDetalle(Recetas receta) {
        Intent intent = new Intent(this, detalleReceta.class);
        intent.putExtra("recetaSeleccionada", receta);
        startActivity(intent);
        finish();
    }

    //Con esta funcion se ocultan los layouts que no son platos fuertes
    public void filtradoPlatoFuerte(View view) {
        //se ocultan los layouts que no son platos fuertes
        //pd para el luis del futuro: 1 y 3 son platos fuertes
        //y cambiar background tint
        if (!platoFuerte){
            layoutReceta1.setVisibility(View.GONE);
            layoutReceta2.setVisibility(View.VISIBLE);
            layoutReceta3.setVisibility(View.GONE);
            layoutReceta4.setVisibility(View.VISIBLE);
            layoutReceta5.setVisibility(View.GONE);
            platoFuerte = true;
            bebida = false;
            reposteria = false;
        } else {
            layoutReceta1.setVisibility(View.VISIBLE);
            layoutReceta2.setVisibility(View.VISIBLE);
            layoutReceta3.setVisibility(View.VISIBLE);
            layoutReceta4.setVisibility(View.VISIBLE);
            layoutReceta5.setVisibility(View.VISIBLE);
        }
    }

    public void filtradoBebidas(View view) {
        //se ocultan los layouts que no son bebidas
        //1 es bebida
       if (!bebida){
           layoutReceta1.setVisibility(View.VISIBLE);
           layoutReceta2.setVisibility(View.GONE);
           layoutReceta3.setVisibility(View.GONE);
           layoutReceta4.setVisibility(View.GONE);
           layoutReceta5.setVisibility(View.GONE);
           bebida = true;
           platoFuerte = false;
           reposteria = false;
       } else {
           layoutReceta1.setVisibility(View.VISIBLE);
           layoutReceta2.setVisibility(View.VISIBLE);
           layoutReceta3.setVisibility(View.VISIBLE);
           layoutReceta4.setVisibility(View.VISIBLE);
           layoutReceta5.setVisibility(View.VISIBLE);
           bebida = false;
       }
    }

    public void filtradoReposteria(View view) {
        //se ocultan los layouts que no son repostería
        //3 es repostería
        if (!reposteria){
            layoutReceta1.setVisibility(View.GONE);
            layoutReceta2.setVisibility(View.GONE);
            layoutReceta3.setVisibility(View.VISIBLE);
            layoutReceta4.setVisibility(View.GONE);
            layoutReceta5.setVisibility(View.VISIBLE);
            reposteria = true;
            platoFuerte = false;
            bebida = false;
        } else {
            layoutReceta1.setVisibility(View.VISIBLE);
            layoutReceta2.setVisibility(View.VISIBLE);
            layoutReceta3.setVisibility(View.VISIBLE);
            layoutReceta4.setVisibility(View.VISIBLE);
            layoutReceta5.setVisibility(View.VISIBLE);
        }

    }
}