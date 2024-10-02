package com.example.examen

import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService {
    @GET("results/list")
    fun getInfoMovie(@Path("discover/movie?sort_by=popularity.desc&api_key=fa3e844ce31744388e07fa47c7c5d8c3") movieTitle:String ):
            MovieResponseDto
}