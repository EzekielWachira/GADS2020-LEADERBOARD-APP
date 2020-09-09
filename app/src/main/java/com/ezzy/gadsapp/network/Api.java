package com.ezzy.gadsapp.network;

import retrofit2.Retrofit;

public class Api{

    public static Retrofit retrofit;
    public static final String FORM_BASE_URL = "https://docs.google.com/forms/d/e/";

    public static Retrofit retrofitInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(FORM_BASE_URL)
                    .build();
        }

        return retrofit;
    }


//    @Override
//    public Retrofit retrofitInstance(String baseUrl) {
//        baseUrl = FORM_BASE_URL;
//        if (retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .build();
//        }
//
//        return retrofit;
//    }

}
