package task1.data

import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import task1.data.api.KtorTask1RemoteDataSource
import task1.data.api.data.GitRepository
import task1.data.api.data.RequestState

class Task1RepositoryImpl(
    private val remoteDataSource: KtorTask1RemoteDataSource,
) : Task1Repository {
    override suspend fun getGutRepository(): Flow<RequestState<List<GitRepository>>> =
        flow {
            var response: RequestState<List<GitRepository>> = RequestState.Loading
            val serverResponse = remoteDataSource.getGutRepository()
            val data = serverResponse.body<List<GitRepository>>()
            if (serverResponse.status.value == 200) {
                response =
                    RequestState.Success(
                        data = data,
                    )
            } else {
                RequestState.Error(message = serverResponse.toString())
            }
            emit(response)
        }.flowOn(Dispatchers.IO)
}
