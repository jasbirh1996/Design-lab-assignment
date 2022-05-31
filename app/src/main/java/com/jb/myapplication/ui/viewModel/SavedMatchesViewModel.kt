package com.jb.myapplication.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jb.myapplication.data.network.model.DefineLabsResponse
import com.jb.myapplication.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedMatchesViewModel @Inject constructor(private val localRepo : LocalRepository): ViewModel() {

    var getSavedMatchesData : MutableLiveData<List<DefineLabsResponse.Response.Venue>> = MutableLiveData()

    fun invoke(){
        viewModelScope.launch(Dispatchers.IO) {
            localRepo.getSelectedMatches().let {
                getSavedMatchesData.postValue(it)
            }
        }
    }
    fun enableMatch(value :Int,id: String){
        viewModelScope.launch(Dispatchers.IO) {
            localRepo.updateMatch(value,id)
        }
    }
    fun disableMatch(value :Int,id : String){
        viewModelScope.launch(Dispatchers.IO) {
            localRepo.updateMatch(value,id)
        }
    }
}