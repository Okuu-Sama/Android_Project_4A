package com.example.android_project_4a.injection

import android.content.Context
import androidx.room.Room
import com.example.android_project_4a.data.local.AppDatabase
import com.example.android_project_4a.data.local.DatabaseDao
import com.example.android_project_4a.data.remote.GranblueApi
import com.example.android_project_4a.data.repository.GranblueRepository
import com.example.android_project_4a.data.repository.UserRepository
import com.example.android_project_4a.domain.entity.Granblue_Character
import com.example.android_project_4a.domain.usecase.CreateUserUseCase
import com.example.android_project_4a.domain.usecase.GetCharacterListUseCase
import com.example.android_project_4a.domain.usecase.GetUserUseCase
import com.example.android_project_4a.domain.usecase.VerifyUserUseCase
import com.example.android_project_4a.presentation.list.ListViewModel
import com.example.android_project_4a.presentation.main.MainViewModel
import com.example.android_project_4a.presentation.signup.SignupViewModel
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://raw.githubusercontent.com/Okuu-Sama/Project_Mobile_Prog/master/"

val presentationModule = module {
    factory { MainViewModel(get()) }
    factory { SignupViewModel(get(), get()) }
    factory { ListViewModel(get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get())}
    factory { VerifyUserUseCase(get()) }
    factory { GetCharacterListUseCase(get()) }
}

val dataModule = module {
    single {UserRepository(get())}
    single {createDataBase(androidContext())}
    single {fetchAPI<GranblueApi>(BASE_URL)}
    single {GranblueRepository(gbfApi = get())}
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}

inline fun <reified T>fetchAPI(gbfApiUrl: String) : T
{
    val myType = object : TypeToken<List<Granblue_Character>>() {}.type
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(gbfApiUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()

    return retrofit.create(T::class.java)
}