package com.example.weather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class First extends AppCompatActivity {


    public static final int CODE=1226;
    private final String KEY="453dc17d6324203544848004e4067212";
    Button search;
    TextView txtTemp,txtDesc,txtDate,txtWind,txtPressure,txtHumid,txtSet,txtRise,txtLoc,txtCity,txtMax,txtMin;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
         init();
         getData("Hyderabad");
         listeners();
    }
    void init(){
        search =findViewById(R.id.search);
        txtTemp=findViewById(R.id.txt_temp);
        img=findViewById(R.id.image);
        txtDesc=findViewById(R.id.txt_desc);
        txtDate=findViewById(R.id.txt_date);
        txtPressure=findViewById(R.id.txt_pressure);
        txtHumid=findViewById(R.id.txt_humid);
        txtWind=findViewById(R.id.txt_wind);
        txtSet=findViewById(R.id.txt_set);
        txtRise=findViewById(R.id.txt_sun);
        txtLoc=findViewById(R.id.txt_location);
        txtCity=findViewById(R.id.txt_city);
        txtMax=findViewById(R.id.txt_max);
        txtMin=findViewById(R.id.txt_min);
    }
    void getData(String city){
        RetrofitClient retrofitClient =RetrofitClient.getmInstance();
        String url="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+KEY;
        Call<Test> test=retrofitClient.getApi().getData(url);
        test.enqueue(new Callback<Test>() {
            @Override
            public void onResponse(Call<Test> call, Response<Test> response) {

                Log.e("Code",""+response.isSuccessful()+response.code());
                if (response.body()!=null&&response.code()==200&&response.isSuccessful()){
                    String image="https://openweathermap.org/img/w/"+response.body().weather[0].icon+".png";
                    Glide.with(First.this).load(image).into(img);
                    setValues(response.body());
                   }
                if (response.code()==404){
                    Toast.makeText(First.this, "City Not Found :(", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Test> call, Throwable t) {
                Log.e("error1",t.getMessage());

            }
        });

    }
    void setValues(Test body){
        txtTemp.setText(Math.round(body.getMain().temp-273.15)+" °C");
        txtMax.setText("Max Temperature: "+Math.round(body.getMain().getTemp_max()-273.15)+" °C");
        txtMin.setText("Min Temperature: "+Math.round(body.getMain().getTemp_min()-273.15)+" °C");
        txtDesc.setText(body.weather[0].description);
        txtDate.setText(DateFormat.getDateInstance(DateFormat.FULL).format(Calendar.getInstance().getTime()));
        txtLoc.setText("Long | Lat\n"+body.getCoord().getLon()+"|"+body.getCoord().getLat());
        txtRise.setText(dateConverter(body.getSys().getSunrise()).split(" ")[1].substring(0,5)+"\nSunrise");
        txtSet.setText(dateConverter(body.getSys().getSunset()).split(" ")[1].substring(0,5)+"\nSunset");
        txtWind.setText("Speed\n  "+body.getWind().getSpeed());
        txtPressure.setText(""+body.getMain().getPressure()+"\nPressure");
        txtHumid.setText(""+body.getMain().humidity+"\nHumidity");
        txtCity.setText(body.getName()+", \n"+body.getSys().getCountry());

    }

    void listeners(){
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i=new Intent(First.this,SearchActivity.class);
                startActivityForResult(i,CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==CODE&&resultCode==RESULT_OK){
                getData(data.getStringExtra("CITY"));
        }
    }

    String dateConverter(long unixTime){
        final DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        final String formattedDtm = Instant.ofEpochSecond(unixTime)
                .atZone(ZoneId.of("Asia/Kolkata"))
                .format(formatter);
        return formattedDtm;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}