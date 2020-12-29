package com.example.android_project_4a.presentation.list

import android.content.Intent
import android.view.LayoutInflater
import com.example.android_project_4a.R
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project_4a.domain.entity.Granblue_Character
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates

class ListAdapter(
    //private var listener: OnItemClickListener
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var characterList: List<Granblue_Character> by Delegates.observable(emptyList()){ _,_,_ -> notifyDataSetChanged()}

    interface OnItemClickListener
    {
        fun onItemClick(item: Granblue_Character?)
    }

    fun updataData(newList: List<Granblue_Character>)
    {
        characterList = newList
    }


    class ViewHolder(
        v: View
    ) : RecyclerView.ViewHolder(v),
            View.OnClickListener
    {
        private var layout: View = v
        private var txtHeader: TextView? = null
        private var txtFooter: TextView? = null
        private var characterIcon: ImageView? = null

        init
        {
            layout.setOnClickListener(this)
            txtHeader = v.findViewById(R.id.firstLine)
            txtFooter = v.findViewById(R.id.secondLine)
            characterIcon = v.findViewById(R.id.icon)
        }

        override fun onClick(v: View?) {
            //val context = itemView.context
            //val characterIntent = Intent(this, PhotoActivity::class.java)
            //characterIntent.putExtra(PHOTO_KEY, photo)
            //context.startActivity(characterIntent)
            //TODO("Not yet implemented")
        }

        fun bindCharacter(character: Granblue_Character)
        {
            val iconPath = character.getIconPath()
            val path = "https://gbf.wiki/images/$iconPath"
            Picasso.get().load(path).resize(260,180).into(characterIcon)
            txtHeader?.text = character.getName()
            txtFooter?.text = character.getElement()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder
    {
        val inflater =LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.row_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int)
    {
        val currentCharacter = characterList[position]
        holder.bindCharacter(currentCharacter)
    }

    override fun getItemCount(): Int
    {
        return characterList.size
    }


}