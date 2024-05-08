package task1.data

import org.koin.dsl.module
import task1.data.api.KtorTask1RemoteDataSource

val task1dataModule =
    module {
        factory { KtorTask1RemoteDataSource(get()) }
        single<Task1Repository> { Task1RepositoryImpl(get()) }
    }
