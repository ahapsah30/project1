package com.gtlo.project1;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //1. inisialisasi variabel
        final TextView lblDaftarIstilah = (TextView) findViewById(R.id.lblDaftarIstilah);
        final ListView list = (ListView) findViewById(R.id.listPemrograman);
        final ArrayList pemrograman = new ArrayList();
        final ArrayList penjelasan = new ArrayList();


        //2. menambah data array list
        pemrograman.add("Java");
        pemrograman.add("PHP");
        pemrograman.add("Visual Basic");

        penjelasan.add("Java adalah bahasa pemrograman yang dapat dijalankan di berbagai komputer termasuk telepon genggam. Bahasa ini awalnya dibuat oleh James Gosling saat masih bergabung di Sun Microsystems, yang saat ini merupakan bagian dari Oracle dan dirilis tahun 1995. Wikipedia");
        penjelasan.add("PHP: Hypertext Preprocessor adalah bahasa skrip yang dapat ditanamkan atau disisipkan ke dalam HTML. PHP banyak dipakai untuk memprogram situs web dinamis. PHP dapat digunakan untuk membangun sebuah CMS. Wikipedia");
        penjelasan.add("Microsoft Visual Basic merupakan sebuah bahasa pemrograman yang menawarkan Integrated Development Environment visual untuk membuat program perangkat lunak berbasis sistem operasi Microsoft Windows dengan menggunakan model pemrograman. Wikipedia");
        
        
        //3. mendapatkan jumlah array list
        lblDaftarIstilah.setText("Daftar Istilah ("+pemrograman.size()+")");
        
        //4. membuat adapter sebagai perantara UI (listView) dan data (ArrayList)
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, pemrograman));

        //5. membuat fungsi jika listview di klik
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //6. membuat alert dialog untuk menampilkan penjelasan kamus
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(pemrograman.get(position).toString())
                        .setMessage(penjelasan.get(position).toString())
                        .setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();


            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}