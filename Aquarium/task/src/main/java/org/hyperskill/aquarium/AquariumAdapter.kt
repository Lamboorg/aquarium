package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class AquariumAdapter(
    private val imageAnimals: List<String>,
    private val nameAnimals: List<String>,
    private val descriptionAnimals: List<String>
) : RecyclerView.Adapter<AquariumAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_view)
        val tvName: TextView = view.findViewById(R.id.tv_name)
        val tvDescription: TextView = view.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_item, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder (holder: AnimalViewHolder, position: Int) {
        Picasso.Builder(holder.itemView.context).build()
            .load(imageAnimals[position])
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(holder.imageView)
        holder.tvName.text = nameAnimals[position]
        holder.tvDescription.text = descriptionAnimals[position]
    }

    override fun getItemCount(): Int = nameAnimals.size

}