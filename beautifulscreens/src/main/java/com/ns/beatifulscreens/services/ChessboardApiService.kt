import com.ns.beautifulscreens.model.ChessboardState
import retrofit2.http.GET

interface ChessboardApiService {
    @GET("game")
    suspend fun getChessboardState(): ChessboardState
}