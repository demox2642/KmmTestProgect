import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ktor.ktorModule
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin
import task1.data.task1dataModule
import task1.presentation.Task1Screen
import task1.presentation.task1Presentation
import task2.presentation.Task2Screen
import task3.presentation.Task3Screen

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    initializeKoin()
    MaterialTheme {
        Content()
    }
}

@Composable
fun Content() {
    TabNavigator(
        Task1Screen,
        tabDisposable = {
            TabDisposable(
                navigator = it,
                tabs = listOf(Task1Screen, Task2Screen, Task3Screen),
            )
        },
    ) { tabNavigator ->
        Scaffold(
            content = {
                CurrentTab()
            },
            bottomBar = {
                BottomNavigation {
                    TabNavigationItem(Task1Screen)
                    TabNavigationItem(Task2Screen)
                    TabNavigationItem(Task3Screen)
                }
            },
        )
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) },
    )
}

fun initializeKoin() {
    startKoin {
        modules(listOf(ktorModule, task1dataModule, task1Presentation))
    }
}
