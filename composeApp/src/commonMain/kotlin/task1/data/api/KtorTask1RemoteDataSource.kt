package task1.data.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.path

class KtorTask1RemoteDataSource(
    private val httpClient: HttpClient,
) {
    suspend fun getGutRepository(): HttpResponse {
        return httpClient.get {
            url { path("users/demox2642/repos") }
        }
    }
}
