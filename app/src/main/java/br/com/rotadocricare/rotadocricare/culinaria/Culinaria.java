package br.com.rotadocricare.rotadocricare.culinaria;

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

public class Culinaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culinaria);


        ListView listView;
        final String mTitle[] = {"Moqueca", "Beijú", "Paelha", "Casquinha de Siri", "Chimango"};
        String mDescription[] = {"Saiba mais sobre a moqueca da cidade", "Saiba mais sobre o beijú da cidade", "Saiba mais sobre a paelha da cidade", "Saiba mais sobre a casquinha de siri da cidade", "Saiba mais sobre o chimango da cidade"};
        int images[] = {R.drawable.img1_1, R.drawable.img1_2, R.drawable.img1_3, R.drawable.img1_4, R.drawable.img1_5};

        listView = findViewById(R.id.listView);

        Culinaria.MyAdapter adapter = new Culinaria.MyAdapter(this, mTitle, mDescription, images);

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
