package com.example.examen

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
class Movie(
    @Json(name="original_title")
    val title: String,
    @Json(name="poster_path")
    val path: String
)

@JsonClass(generateAdapter = true)
class MovieResponseDto(
    val results: List<Movie>
){

}
