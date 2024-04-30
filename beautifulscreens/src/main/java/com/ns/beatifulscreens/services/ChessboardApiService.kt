import retrofit2.http.GET

interface ChessboardApiService {
    @GET("game")
    suspend fun getChessboardState()
}