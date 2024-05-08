package task1.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import task1.data.Task1Repository
import task1.data.api.data.RequestState
import task1.presentation.data.Task1Event

class Task1VM(
    private val task1Repository: Task1Repository,
) : ScreenModel {
    private val _task1Data = MutableStateFlow(Task1Event.Task1Data(data = RequestState.Init))
    val task1Data = _task1Data.asStateFlow()

    fun changeState(task1Event: Task1Event) {
        when (task1Event) {
            is Task1Event.GetData -> {
                getGutRepository()
            }
        }
    }

    private fun getGutRepository() {
        screenModelScope.launch(Dispatchers.IO) {
            _task1Data.value = Task1Event.Task1Data(data = RequestState.Loading)
            task1Repository.getGutRepository().collectLatest {
                _task1Data.value = Task1Event.Task1Data(data = it)
            }
        }
    }
}
