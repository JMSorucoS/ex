package com.example.examen

class MovieRemoteDataSource(
    val retrofiService: RetrofitBuilder
) {
    fun getMovieInfo(): MovieResponseDto {
        return retrofiService.apiService.getInfoMovie("")
    }
}
