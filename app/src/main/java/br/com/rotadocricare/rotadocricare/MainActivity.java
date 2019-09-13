package br.com.rotadocricare.rotadocricare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import br.com.rotadocricare.rotadocricare.turismo.Turismo;

public class MainActivity extends AppCompatActivity {

    ImageView turismo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turismo = findViewById(R.id.turismo);

        turismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Turismo.class));
            }
        });
    }
}
