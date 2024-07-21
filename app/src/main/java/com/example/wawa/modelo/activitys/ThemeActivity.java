package com.example.wawa.modelo.activitys;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.wawa.R;
import com.example.wawa.modelo.temas.Page;
import com.example.wawa.modelo.temas.Theme;

import java.util.ArrayList;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_theme);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConstraintLayout layout = findViewById(R.id.container);
        Page introductionWhatIsMath = new Page();
        Theme themeMath = new Theme(this,layout,introductionWhatIsMath);
        introductionWhatIsMath.setTheme(themeMath);
        themeMath.chargePage(0);
    }
}