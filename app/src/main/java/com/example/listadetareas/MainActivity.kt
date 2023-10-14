package com.example.listadetareas
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listadetareas.databinding.ActivityListadoTareasBinding
import com.example.listadetareas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtEntrar.setOnClickListener {
            var intent = Intent(this, ListadoTareas::class.java)
            startActivity(intent)
        }

    }
}