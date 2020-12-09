package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SearchActivity extends AppCompatActivity {

    Button btnSearch;
    ImageButton btnBack;
    ImageView imgSearch;
    EditText edtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        listeners();
    }
    void init(){
        String url="https://media1.tenor.com/images/b5297729f086583c54a5710bcd1f3a01/tenor.gif?itemid=11937517";
        btnSearch=findViewById(R.id.btn_search);
        btnBack=findViewById(R.id.btn_back);
        edtSearch=findViewById(R.id.edt_search);
        imgSearch=findViewById(R.id.img_search);
      Glide.with(this).asGif().load(url).into(imgSearch);
    }
    void listeners(){

        btnSearch.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!edtSearch.getText().toString().equals("")){
                String city=edtSearch.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("CITY",city);
                setResult(RESULT_OK,intent);
                finish();}
                else
                {
                    edtSearch.setError("Enter City Name");
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}