package com.example.videogamesdatabase.home
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.videogamesdatabase.databinding.GridViewItemBinding
import com.example.videogamesdatabase.network.GameProperty

class GridAdapter(): ListAdapter<GameProperty, GridAdapter.GamePropertyViewHolder>(DiffCallBack) {
    class GamePropertyViewHolder(private var binding: GridViewItemBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(gameProperty: GameProperty){
                    binding.property = gameProperty
                    binding.executePendingBindings()
                }
            }

    companion object DiffCallBack : DiffUtil.ItemCallback<GameProperty>(){
        override fun areItemsTheSame(oldItem: GameProperty, newItem: GameProperty): Boolean{
            return oldItem === newItem
        }
        override fun areContentsTheSame(
            oldItem: GameProperty,
            newItem: GameProperty
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GamePropertyViewHolder {
        return GamePropertyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: GamePropertyViewHolder,
        position: Int
    ) {
        val gameProperty = getItem(position)
        holder.bind(gameProperty)
    }
}
