package com.example.paises
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.paises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val countries = arrayOf(
        "Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Ecuador",
        "Guyana", "Paraguay", "Perú", "Surinam", "Uruguay", "Venezuela"
    )

    private val populations = arrayOf(
        "45,376,763", "11,513,100", "210,147,125", "19,458,310", "49,070,000", "17,643,054",
        "782,225", "7,152,703", "32,971,846", "591,919", "3,470,866", "28,515,829"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedCountry = countries[position]
            val population = populations[position]
            binding.tvPopulation.text = "Habitantes de $selectedCountry: $population"
        }

        setSupportActionBar(binding.toolbar)
        binding.btnExit.setOnClickListener { finish() }
    }
}
