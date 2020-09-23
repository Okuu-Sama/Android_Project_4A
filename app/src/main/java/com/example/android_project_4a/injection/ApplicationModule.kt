package com.example.android_project_4a.injection

import com.example.android_project_4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}