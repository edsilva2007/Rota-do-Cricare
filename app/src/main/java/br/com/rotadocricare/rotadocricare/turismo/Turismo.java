package br.com.rotadocricare.rotadocricare.turismo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.com.rotadocricare.rotadocricare.R;
import br.com.rotadocricare.rotadocricare.geografia.Geografia;

public class Turismo extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Igreja Velha", "Porto", "Guriri", "Barra Nova", "Urussuquara", "Biquinha"};
    String mDescription[] = {"Patrimonio Historico da Cidade", "Construções antigas", "Praia da cidade ", "Distrito do Municipio", "Praia da cidade", "Fonte de agua"};
    int images[] = {R.drawable.igreja, R.drawable.porto, R.drawable.guriri, R.drawable.barranova, R.drawable.urussuquara, R.drawable.biquinha};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turismo);

        listView = findViewById(R.id.listView);

        Turismo.MyAdapter adapter = new Turismo.MyAdapter(this, this.mTitle, this.mDescription, this.images);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                String opcao = mTitle[position];
                Toast.makeText(getApplicationContext(), "Opção Selecionada : " + opcao, Toast.LENGTH_LONG).show();
            }
        });


    }

    class MyAdapter extends ArrayAdapter<String> {
        Activity activity;
        String rTitle[];
        String rDescription[];
        int rImgs[];


        MyAdapter(Activity a, String title[], String description[], int imgs[]) {
            super(a, R.layout.row, R.id.textView1, title);
            this.activity = a;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = this.activity.getLayoutInflater();
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            return super.getView(position, convertView, parent);
        }
    }
}
