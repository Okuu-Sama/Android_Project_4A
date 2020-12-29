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
    
    val characterLiveData: MutableLiveData<List<Granblue_Character>> = MutableLiveData();

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


        //TODO processing
        //Will process live data with the caracter clicked
        //will have  a characterstatus.kt where if character is clicked and data could be retrieve then charactersuccess send to activity
        //Activity then can load next activity with the received charracter data
    }
}