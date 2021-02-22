package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView= findViewById(R.id.listView);

        //Data

        ArrayList<String> landmarkNames = new ArrayList<>(); //Şehir Simgelerinin tutulduğu Array
        landmarkNames.add("Anıtkabir");
        landmarkNames.add("Galata Kulesi");
        landmarkNames.add("Çifte Minare");
        landmarkNames.add("Sümela Manastırı");
        landmarkNames.add("Sazova Parkı");
        landmarkNames.add("Saat Kulesi");
        landmarkNames.add("Şehitler Abidesi");
        landmarkNames.add("Pamukkale Travertenleri");

        ArrayList<String> countryNames = new ArrayList<>(); //Şehir isimlerinin tutulduğu Array
        countryNames.add("Ankara");
        countryNames.add("İstanbul");
        countryNames.add("Erzurum");
        countryNames.add("Trabzon");
        countryNames.add("Eskişehir");
        countryNames.add("İzmir");
        countryNames.add("Çanakkale");
        countryNames.add("Pamukkale");

        Bitmap anitkabir = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.anitkabir);
        Bitmap galata = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.galata);
        Bitmap cifte = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.cifte);
        Bitmap sumela = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sumela);
        Bitmap sazova = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sazova);
        Bitmap saat = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.saat);
        Bitmap abide = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.abide);
        Bitmap pamukkale = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pamukkale);

        ArrayList<Bitmap> landmarkImages = new ArrayList<>(); //Resimlerin tutulduğu Array

        landmarkImages.add(anitkabir);
        landmarkImages.add(galata);
        landmarkImages.add(cifte);
        landmarkImages.add(sumela);
        landmarkImages.add(sazova);
        landmarkImages.add(saat);
        landmarkImages.add(abide);
        landmarkImages.add(pamukkale);


        //ListView Process

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //System.out.println(landmarkNames.get(position)); trial1
                //System.out.println(countryNames.get(position));  trial2

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(position));  // MainActivity de ki verilari DetailActivity'e gönderildiği kod satırı (Şehirlerin Simgeleri için)
                intent.putExtra("country",countryNames.get(position)); // MainActivity de ki verilari DetailActivity'e gönderildiği kod satırı (Şehirler için)

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));

                startActivity(intent);


            }
        });



    }
}