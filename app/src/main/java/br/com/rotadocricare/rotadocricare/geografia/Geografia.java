package br.com.rotadocricare.rotadocricare.geografia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.rotadocricare.rotadocricare.R;
import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Geografia extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Clima", "Relevo", "Hdrografia", "Meio ambiente", "Demografia"};
    String mDescription[] = {"Saiba mais sobre o clima da cidade", "Saiba mais sobre o relevo da cidade", "Saiba mais sobre a hidrografia da cidade", "Saida mais sobre o meio ambiente da cidade", "Saiba mais sobre a demografia da cidade"};
    int images[] = {R.drawable.clima, R.drawable.relevo, R.drawable.hidrografia, R.drawable.hidrografia, R.drawable.meio_ambiente, R.drawable.demografia};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geografia);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, this.mTitle, this.mDescription, this.images);

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
