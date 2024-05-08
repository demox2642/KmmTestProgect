package task1.data

import kotlinx.coroutines.flow.Flow
import task1.data.api.data.GitRepository
import task1.data.api.data.RequestState

interface Task1Repository {
    suspend fun getGutRepository(): Flow<RequestState<List<GitRepository>>>
}
