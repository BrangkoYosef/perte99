package com.example.pemmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pemmobile.Adapter.Adapter_Barang;
import com.example.pemmobile.Model.m_barang;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;

public class Barang extends AppCompatActivity {
    RecyclerView lvBarang;
    ArrayList<m_barang> data;
    Adapter_Barang adp;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        lvBarang = findViewById(R.id.lvBarang);

        dataBarang();

    }

    public void dataBarang(){

        data = new ArrayList<>();
        db.collection("barang")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d(TAG, document.getId() + "00" + document.getData());
                          data.add(new m_barang (
                                  document.getId().toString,
                                  Objects.requireNonNull(document.get)
                                  document.getData().get("nama barang").toString(),
                                  R.drawable.ic_bike,
                                  document.getData().get("harga").toString(),
                                  document.getData().get("satuan")toString()
                          )
                           }
                        } else {
                            //Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    //

            }
        }
//        ArrayList<String> dataB = new ArrayList<>();
//        dataB.add("Monitor");
//        dataB.add("Mouse");
//        dataB.add("Processor");
//        dataB.add("Printer");
//
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
////                android.R.layout.simple_list_item_1, android.R.id.text1, dataB);
////
//        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, dataB);
//
//        lvBarang.setAdapter(adp);
//        data = new ArrayList<>();
//        data.add(new m_barang("barang 2", R.drawable.ic_profil));
 //       adp = new Adapter_Barang(this, data);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        lvBarang.setLayoutManager(llm);
 //       lvBarang.setAdapter(adp);


