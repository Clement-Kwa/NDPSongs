package sg.edu.rp.c346.id20002694.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EditSong extends AppCompatActivity {

    EditText etTitle, etSingers, etYear, etID;
    RadioGroup radioGrp;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        etTitle  = findViewById(R.id.etTitle);
        etSingers= findViewById(R.id.etSingers);
        etYear= findViewById(R.id.etYear);
        etID= findViewById(R.id.etID);
        radioGrp = findViewById(R.id.radioGrp);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete= findViewById(R.id.btnDelete);
        btnCancel= findViewById(R.id.btnCancel);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                dbh.deleteSong(data.getId());
                finish();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditSong.this);
                
                int stars = 0;
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                if(radioGrp.getCheckedRadioButtonId() == R.id.rb1){
                    stars=1;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb2){
                    stars=2;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb3){
                    stars=3;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb4){
                    stars=4;
                }
                else if(radioGrp.getCheckedRadioButtonId() == R.id.rb5){
                    stars=5;
                }

                data.setSongContent(etContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
                finish();
            }
        });



    }
}