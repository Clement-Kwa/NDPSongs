package sg.edu.rp.c346.id20002694.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity {

    Button btnShow;
    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        btnShow = findViewById(R.id.btnShow);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Song>();

        DBHelper dbh = new DBHelper(SongList.this);
        al.addAll(dbh.getAllSongs());


        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
        dbh.close();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(SongList.this, EditSong.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SongList.this);
                al.clear();
                String rating  = "5";
                al.addAll(dbh.getAllSongs(rating));
                aa.notifyDataSetChanged();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(SongList.this);
        al.clear();

        al.addAll(dbh.getAllSongs());

        aa.notifyDataSetChanged();
        dbh.close();
    }
}