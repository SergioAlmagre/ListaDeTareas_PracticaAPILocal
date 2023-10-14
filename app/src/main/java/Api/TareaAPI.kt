package Api

import Modelo.Tarea
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface TareaAPI {


    @GET("/tarea/todas")
    fun getTareass(): Call<MutableList<Tarea>>

    @GET("/tarea/pospuestas")
    fun getTareasPospuestass(): Call<MutableList<Tarea>>

    @GET("/tarea/completadas")
    fun getTareasCompletadass(): Call<MutableList<Tarea>>

    @GET("/tarea/urgentes")
    fun getTareasUrgentess(): Call<MutableList<Tarea>>

    @GET("/tarea/todas/{id}")
    fun getUnaTarea(@Path("id") id:String): Call<Tarea>


//    @Headers("Content-Type:application/json")
//    @POST("registrar")
//    fun addTarea(@Body info: Tarea) : Call<ResponseBody>
//
//    @Headers("Content-Type:application/json")
//    @POST("login")
//    fun loginUsuario(@Body info: Tarea) : Call<Tarea>
//
//    @DELETE("borrar/{dni}")
//    fun borrarTarea(@Path("dni") dni:String) : Call<ResponseBody>
//
//    @Headers("Content-Type:application/json")
//    @PUT("modificar/{dni}")
//    fun modTarea(@Body info: Tarea, @Path("dni") dni:String) : Call<ResponseBody>
}