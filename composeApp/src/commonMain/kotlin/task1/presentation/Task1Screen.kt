package task1.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import kmmtestprogect.composeapp.generated.resources.Res
import kmmtestprogect.composeapp.generated.resources.task1
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import task1.data.api.data.GitRepository
import task1.data.api.data.RequestState
import task1.presentation.data.Task1Event

object Task1Screen : Tab {
    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.task1)
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        val viewModel = getScreenModel<Task1VM>()
        val task1Data by viewModel.task1Data.collectAsState()
        println("taskData = $task1Data")

        Scaffold(modifier = Modifier.padding(bottom = 50.dp)) {
            when (task1Data.data) {
                is RequestState.Init -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { viewModel.changeState(Task1Event.GetData) }) {
                            Text("Click me!")
                        }
                    }
                }
                is RequestState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                is RequestState.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(task1Data.data.getErrorMessage())
                    }
                }
                is RequestState.Success -> {
                    LazyColumn {
                        items(task1Data.data.getSuccessData()) {
                            ListItemViwe(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListItemViwe(item: GitRepository) {
    Card(modifier = Modifier.padding(10.dp)) {
        Row(modifier = Modifier.padding(10.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(item.id.toString())
            Text(item.name)
        }
    }
}
