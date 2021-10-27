package com.igp.i_ran.data

import com.igp.i_ran.model.Report
import com.igp.i_ran.model.ReportDto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

object Api {

    //URL BASE = https://restserver-curso-lu.herokuapp.com/

    //1. Cofigurar la URL BASE
    private val builder : Retrofit.Builder = Retrofit.Builder()
        .baseUrl("https://restserver-curso-lu.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())

    //2. Configurar los METODOS
    interface ApiInterface {

        //Define el que de las cosas
        @POST("api/usuarios")
        suspend fun saveReport(@Body request : Report) : Response<ReportDto>

    }

    //3. Regresar una instancia de RETROFIT
    fun buid() : ApiInterface{
        return builder.build().create(ApiInterface::class.java)
    }

}