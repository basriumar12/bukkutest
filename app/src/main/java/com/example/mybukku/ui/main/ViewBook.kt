package com.example.mybukku.ui.main

import com.example.mybukku.model.ItemsItem
import com.example.mybukku.model.ResponseBuku

interface ViewBook {

    fun showLoad()
    fun hideLoad ()
    fun message (message : String)
    fun getData(allData : List<ItemsItem>)
}