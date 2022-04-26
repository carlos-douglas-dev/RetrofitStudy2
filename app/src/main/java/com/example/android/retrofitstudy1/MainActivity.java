package com.example.android.retrofitstudy1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.retrofitstudy1.api.MyApi;
import com.example.android.retrofitstudy1.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
     {

        TextView textView;

        //url to fetch the data from
            String dataurl="https://jsonplaceholder.typicode.com/";

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView=(TextView)findViewById(R.id.textjsondata);
            textView.setText("");

            //CREATE A RETROFIT OBJECT :STEP 1
            Retrofit retrofit=new Retrofit.Builder().baseUrl(dataurl).
                    addConverterFactory(GsonConverterFactory.create()).build();

            //CONVERTING JSON DATA TO MODEL CLASS OBJECT: STEP2
            //convert json data to MyApi type
            MyApi myApi=retrofit.create(MyApi.class);

            //CREATE A CALL OF MODEL CLASS: STEP 3
            Call<List<Model>> call=myApi.getModels();

            //PROCESSING THE DATA AND RECEIVE THE RESPONSE
            call.enqueue(new Callback<List<Model>>()
            {
                @Override
                public void onResponse(Call<List<Model>> call, Response<List<Model>> response)
                {
                    List<Model>data=response.body();

                    for (int i=0;i<data.size();i++)
                    {
                        textView.append(" SL no "+data.get(i).getId()+" \n Title:"+data.get(i).getTitle()+"\n\n\n");
                    }
                }

                @Override
                public void onFailure(Call<List<Model>> call, Throwable t) {

                }
            });
        }
     }