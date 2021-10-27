package com.igp.i_ran

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igp.i_ran.data.Api
import com.igp.i_ran.model.Report
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OperationViewModel : ViewModel() {

    //MutableLiveData y LiveData

    //dialog
    private var _report : MutableLiveData<Report> = MutableLiveData()
    val report : LiveData<Report> = _report

    private var _loader : MutableLiveData<Boolean> = MutableLiveData()
    val loader : LiveData<Boolean> = _loader

    private var _error : MutableLiveData<String> = MutableLiveData()
    val error : LiveData<String> = _error


    fun grabar(code : String, potencia : String,voc : String,isc : String,status : String,tradeMark : String,vcc : String,vocb : String, statusb : String, type: String, on: String, by: String){

        viewModelScope.launch(Dispatchers.Main) {

            try{
                Log.i("try","Estoy en el Try")
                _loader.value = true

                val response= withContext(Dispatchers.IO){
                    val request = Report(code,potencia,voc,isc,status,tradeMark,vcc,vocb,statusb,type,on,by)
                    Api.buid().saveReport(request)
                }
                if (response.isSuccessful){
                    //Respuesta correcta
                    Log.i("success","Hay respuesta por parte del backend")
                    _report.value = response.body()?.battery

                } else{
                    //Error
                    Log.i("else","Hubo un error en el backend")
                    _error.value = response.message()
                }

            } catch (ex:Exception){
                Log.i("catch","Estoy en el catch")

                _error.value = ex.message.toString()

            } finally{
                _loader.value = false
            }
        }
    }

}