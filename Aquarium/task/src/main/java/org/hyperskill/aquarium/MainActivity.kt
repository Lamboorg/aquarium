package org.hyperskill.aquarium

import org.hyperskill.aquarium.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAnimals: List<String>
    private lateinit var nameAnimals: List<String>
    private lateinit var descriptionAnimals: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageAnimals = intent.extras?.getSerializable("imageAnimals")
                as? List<String> ?: listOf(
            "https://ucarecdn.com/42045846-b968-4a88-81ec-df73bec4fcb7/",
            "https://ucarecdn.com/5aa10eb3-fc49-4304-9057-adf1d29a9b4c/",
            "https://ucarecdn.com/c5fd39b9-7690-4616-b7dc-d3f8da883146/")
        nameAnimals = intent.extras?.getSerializable("nameAnimals")
                as? List<String> ?: listOf(
            getString(R.string.koi_carp_name),
            getString(R.string.spiny_dogfish_name),
            getString(R.string.kaluga_name))

        descriptionAnimals = intent.extras?.getSerializable("descriptionAnimals")
                as? List<String> ?: listOf(
            getString(R.string.koi_carp_description),
            getString(R.string.spiny_dogfish_description),
            getString(R.string.kaluga_description))


        val adapter = AquariumAdapter(imageAnimals, nameAnimals, descriptionAnimals)
        binding.viewpager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager2) { tab, position ->
            tab.text = nameAnimals[position]
        }.attach()
    }
}