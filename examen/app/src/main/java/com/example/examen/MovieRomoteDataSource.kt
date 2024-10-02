package com.example.examen

class GithubRemoteDataSource(
    val retrofiService: RetrofitBuilder
) {
    suspend fun getAvatarInfo(githubLogin: String): MovieResponseDto {
        return retrofiService.apiService.getInfoMovie(githubLogin)
    }
}
