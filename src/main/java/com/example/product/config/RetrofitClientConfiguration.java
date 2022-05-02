package com.example.product.config;

import com.example.product.Service.CardsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitClientConfiguration {
    private final Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Bean
    CardsService service() {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:8040")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(CardsService.class);
    }


}