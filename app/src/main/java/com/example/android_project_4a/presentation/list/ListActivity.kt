package com.example.android_project_4a.presentation.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project_4a.R
import com.example.android_project_4a.domain.entity.Granblue_Character
import com.example.android_project_4a.presentation.detail.DetailActivity
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.list_activity.*
import org.koin.android.ext.android.inject


class ListActivity : AppCompatActivity() {

    //We initialize the view model using Koin injection
    private val listViewModel: ListViewModel by inject()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var myAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager

        //We create our adapter so that when clicking on a character we will load the details of this character on the next activity
        myAdapter = ListAdapter(object : ListAdapter.OnItemClickListener {
            override fun onItemClick(item: Granblue_Character?) {
                val characterIntent = Intent(baseContext, DetailActivity::class.java)
                characterIntent.putExtra("characterKey", GsonBuilder().setLenient().create().toJson(item))
                characterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(characterIntent)
            }
        })
        recycler_view.adapter = myAdapter

        initViewModel()
    }

    //We ask the view model to look for the data of the API call
    //We update the data in our list of character accordingly
    private fun initViewModel()
    {
        listViewModel.characterLiveData.observe(this, Observer
        { newCharacterList ->
            myAdapter.updataData(newCharacterList)
        })

        listViewModel.onLoadingCharacter()
    }

}