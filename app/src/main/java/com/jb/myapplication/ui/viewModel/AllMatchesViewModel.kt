package com.jb.myapplication.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jb.myapplication.data.network.model.DefineLabsResponse
import com.jb.myapplication.data.repository.LocalRepository
import com.jb.myapplication.data.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllMatchesViewModel @Inject constructor(private val networkRepository: NetworkRepository, private val localRepo: LocalRepository) :ViewModel(){

    var getDataFromServer : MutableLiveData<List<DefineLabsResponse.Response.Venue>>  = MutableLiveData()


    fun invokeApi(){
        viewModelScope.launch(Dispatchers.IO) {
            networkRepository.getDataFromServer().body().let {

                it?.response?.venues?.forEach{
                    localRepo.saveResponse(it)
                }
            }


            localRepo.getAllSavedData().let {
                if (it.size > 0){
                    getDataFromServer.postValue(it)
                }
            }
        }

    }

    fun enableMatch(value :Int,id :String){
        viewModelScope.launch(Dispatchers.IO) {
            value
            id
            localRepo.updateMatch(value,id)
        }
    }
    fun disableMatch(value :Int,id:String){
        value
        id
        viewModelScope.launch(Dispatchers.IO) {
            localRepo.updateMatch(value,id)
        }
    }

}