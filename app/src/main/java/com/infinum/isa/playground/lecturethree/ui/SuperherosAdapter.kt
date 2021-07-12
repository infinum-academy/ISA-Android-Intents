package com.infinum.isa.playground.lecturethree.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infinum.isa.playground.databinding.ViewSuperheroItemBinding
import com.infinum.isa.playground.lecturethree.model.Superhero

// TODO: Adapter with items and on click callback as arguments
class SuperherosAdapter(
    private var items: List<Superhero>,
    private val onClickCallback: (String) -> Unit
) : RecyclerView.Adapter<SuperherosAdapter.SuperheroViewHolder>() {

    /**
     * Called when RecyclerView needs a new ViewHolder to represent an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val binding = ViewSuperheroItemBinding.inflate(LayoutInflater.from(parent.context))
        val holder = SuperheroViewHolder(binding)

        return holder
    }

    /**
     * Called by the RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /**
     * Returns the total number of items that can be shown.
     */
    override fun getItemCount(): Int {
        return items.size
    }


    // TODO: Public fun setItems (with superhero list)

    // TODO: Public fun addItem (with superhero item)

    /**
     * Custom-made ViewHolder, used to match the data to the concrete view.
     */
    // TODO: View holder with binding as argument
    inner class SuperheroViewHolder(private val binding: ViewSuperheroItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Superhero) {
            binding.superheroName.text = item.name

            binding.superheroImage.setImageResource(item.imageResourceId)

            binding.root.setOnClickListener {
                onClickCallback(item.name)
            }
        }
    }
}
