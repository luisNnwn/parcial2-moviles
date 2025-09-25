package com.example.proyecto16_recetario;

//imports de la clase
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class detalleReceta extends AppCompatActivity {

    private ImageView ivRecetaDetalle;
    private TextView tvNombreReceta;
    private TableLayout tableIngredientes;
    private LinearLayout layoutPasos;
    private Button btnProvecho;
    private FrameLayout frameDetalle;

    private Recetas recetaSeleccionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        ivRecetaDetalle = findViewById(R.id.ivRecetaDetalle);
        tvNombreReceta = findViewById(R.id.tvNombreReceta);
        tableIngredientes = findViewById(R.id.tableIngredientes);
        layoutPasos = findViewById(R.id.layoutPasos);
        frameDetalle = findViewById(R.id.frameDetalle);
        btnProvecho = findViewById(R.id.btnProvecho);

        //aca se obtiene la receta seleccionada de la lista de recetas
        recetaSeleccionada = (Recetas) getIntent().getSerializableExtra("recetaSeleccionada");

        //verifico que la receta seleccionada no sea null
        if (recetaSeleccionada != null) {
            mostrarReceta();
        }

        btnProvecho.setOnClickListener(v -> validarCheckBoxes());

    }

    private void mostrarReceta() {
        ivRecetaDetalle.setImageResource(recetaSeleccionada.getImagen());
        tvNombreReceta.setText(recetaSeleccionada.getNombre());

        // -----------------------------
        // Ingredientes con TableLayout
        // -----------------------------
        tableIngredientes.removeAllViews();

        // Encabezado de la tabla
        TableRow headerRow = new TableRow(this);
        TextView thNombre = new TextView(this);
        thNombre.setText("Ingrediente");
        thNombre.setTypeface(null, Typeface.BOLD);
        thNombre.setTextColor(Color.WHITE);
        thNombre.setBackgroundColor(Color.parseColor("#FF8C00"));
        thNombre.setPadding(16, 16, 16, 16);
        thNombre.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

        TextView thCantidad = new TextView(this);
        thCantidad.setText("Cantidad");
        thCantidad.setTypeface(null, Typeface.BOLD);
        thCantidad.setTextColor(Color.WHITE);
        thCantidad.setBackgroundColor(Color.parseColor("#FF8C00"));
        thCantidad.setPadding(16, 16, 16, 16);
        thCantidad.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

        headerRow.addView(thNombre);
        headerRow.addView(thCantidad);
        tableIngredientes.addView(headerRow);

        // Filas con ingredientes
        boolean colorAlterno = false;
        for (String[] ing : recetaSeleccionada.getIngredientes()) {
            TableRow row = new TableRow(this);

            int bgColor = colorAlterno ? Color.parseColor("#FFF8DC") : Color.parseColor("#FFFFFF");
            colorAlterno = !colorAlterno; // Alternar colores de fila

            TextView tvIng = new TextView(this);
            tvIng.setText(ing[0]);
            tvIng.setTextColor(Color.BLACK);
            tvIng.setPadding(16, 16, 16, 16);
            tvIng.setBackgroundColor(bgColor);
            tvIng.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

            TextView tvCant = new TextView(this);
            tvCant.setText(ing[1]);
            tvCant.setTextColor(Color.BLACK);
            tvCant.setPadding(16, 16, 16, 16);
            tvCant.setBackgroundColor(bgColor);
            tvCant.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

            row.addView(tvIng);
            row.addView(tvCant);

            tableIngredientes.addView(row);
        }

        // -----------------------------
        // Pasos con CheckBox
        // -----------------------------
        layoutPasos.removeAllViews();
        for (String paso : recetaSeleccionada.getPasos()) {
            CheckBox cb = new CheckBox(this);
            cb.setText(paso);
            cb.setTextColor(Color.DKGRAY);
            cb.setPadding(8, 8, 8, 8);
            layoutPasos.addView(cb);
        }
    }


    private void validarCheckBoxes() {
        for (int i = 0; i < layoutPasos.getChildCount(); i++) {
            CheckBox cb = (CheckBox) layoutPasos.getChildAt(i);
            if (!cb.isChecked()) {
                Toast.makeText(this, "Debes completar todos los pasos", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Intent intent = new Intent(this, buenProvechoDespedida.class);
        startActivity(intent);
        finish();
    }

    public void regresar(View view){
        Intent intent = new Intent(this, listaRecetas.class);
        startActivity(intent);
        finish();
    }
}
