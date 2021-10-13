package com.masai.pagingnetworkand03.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.masai.pagingnetworkand03.R
import com.masai.pagingnetworkand03.model.CharacterDTO

class CharacterAdapter : PagingDataAdapter<CharacterDTO, CharacterViewHolder>(diffUtil) {


    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<CharacterDTO>() {

            override fun areItemsTheSame(oldItem: CharacterDTO, newItem: CharacterDTO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterDTO, newItem: CharacterDTO): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characterDTO = getItem(position)
        characterDTO?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CharacterViewHolder(view)
    }
}
