package task1.presentation.data

import task1.data.api.data.GitRepository
import task1.data.api.data.RequestState

sealed class Task1Event {
    object GetData : Task1Event()

    data class Task1Data(val data: RequestState<List<GitRepository>>)
}
