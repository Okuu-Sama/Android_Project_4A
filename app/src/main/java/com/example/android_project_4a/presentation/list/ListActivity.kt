package com.example.android_project_4a.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project_4a.R
import kotlinx.android.synthetic.main.list_activity.*
import org.koin.android.ext.android.inject


class ListActivity() : AppCompatActivity() {

    val listViewModel: ListViewModel by inject()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var myAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager

        myAdapter = ListAdapter()
        recycler_view.adapter = myAdapter

        initViewModel()
    }

    private fun initViewModel()
    {
        listViewModel.characterLiveData.observe(this, Observer
        {
            newCharacterList -> myAdapter.updataData(newCharacterList)
        })

        listViewModel.onLoadingCharacter()
    }

}