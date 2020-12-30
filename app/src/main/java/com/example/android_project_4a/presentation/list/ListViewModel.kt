package com.example.android_project_4a.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project_4a.domain.entity.Granblue_Character
import com.example.android_project_4a.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel()
{
    
    val characterLiveData: MutableLiveData<List<Granblue_Character>> = MutableLiveData()

    //We try to load our list of character from the API rest call
    //If the loading is success we notify the activity with a successful loading status
    //otherwise there was an error when loading the list
    fun onLoadingCharacter()
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            val result = getCharacterListUseCase.invoke()
            val loadingStatus = if(result != null)
            {
                LoadingSuccess(result)
            }
            else
            {
                LoadingError
            }

            //If the loading is indeed successful we access and update the live data with the list inside the successful status
            withContext(Dispatchers.Main)
            {
                if (loadingStatus is LoadingSuccess)
                {
                    characterLiveData.value = loadingStatus.characterList
                }else
                {
                    characterLiveData.value = null
                }
            }
        }
    }
}