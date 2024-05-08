package task1.presentation

import org.koin.dsl.module

val task1Presentation =
    module {
        single { Task1VM(get()) }
    }
