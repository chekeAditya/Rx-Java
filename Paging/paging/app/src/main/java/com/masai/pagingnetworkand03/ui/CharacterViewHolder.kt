package com.masai.pagingnetworkand03.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.pagingnetworkand03.model.CharacterDTO
import kotlinx.android.synthetic.main.item_layout.view.*

class CharacterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(resultsDTO: CharacterDTO) {
        view.apply {
            tv_name.text = resultsDTO.name
            Glide
                .with(ivCharacter)
                .load(resultsDTO.image)
                .into(ivCharacter)

        }
    }
}