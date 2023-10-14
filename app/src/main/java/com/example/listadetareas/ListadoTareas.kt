package com.example.listadetareas

import Adaptadores.MiAdaptador
import Api.ServiceBuilder
import Api.TareaAPI
import Modelo.Tarea
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadetareas.databinding.ActivityListadoTareasBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class ListadoTareas : AppCompatActivity() {
    lateinit var binding: ActivityListadoTareasBinding
    var datosRepresentar : ArrayList<Tarea> = ArrayList()
    lateinit var customAdapter : MiAdaptador


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_listado_tareas)
        binding = ActivityListadoTareasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        binding.listaTareasView.layoutManager = linearLayoutManager

        getTareas()
    }

    fun getTareas() {
        val request = ServiceBuilder.buildService(TareaAPI::class.java)
        val call = request.getTareass()

        call.enqueue(object : Callback<MutableList<Tarea>> {
            override fun onResponse(
                call: Call<MutableList<Tarea>>,
                response: Response<MutableList<Tarea>>
            ) {
                Log.e("Sergio", response.code().toString())
                for (post in response.body()!!) {
                    datosRepresentar.add(
                        Tarea(
                            post.id!!,
                            post.autor.toString(),
                            post.fecha.toString(),
                            post.hora.toString(),
                            post.descripcion.toString(),
                            post.estado
                        )
                    )
                }
                if (response.isSuccessful) {
                    binding.listaTareasView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@ListadoTareas)
                        adapter = MiAdaptador(this@ListadoTareas, datosRepresentar)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<Tarea>>, t: Throwable) {
                Log.e("Sergio", t.message.toString())
                Toast.makeText(this@ListadoTareas, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }



}