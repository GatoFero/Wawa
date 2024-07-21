package com.example.wawa;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.wawa.modelo.utiles.Translator;

public class MapThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map_theme);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTextThemes();
    }
    public void setTextThemes() {
        int[] themeIds = {
                R.id.theme1, R.id.theme2, R.id.theme3, R.id.theme4,
                R.id.theme5, R.id.theme6, R.id.theme7, R.id.theme8
        };

        int[] descriptionIds = {
                R.id.description1, R.id.description2, R.id.description3, R.id.description4,
                R.id.description5, R.id.description6, R.id.description7, R.id.description8
        };

        for (int i = 0; i < 8; i++) {
            Translator.setTranslator(this, findViewById(themeIds[i]), findViewById(descriptionIds[i]), i);
        }
    }
}