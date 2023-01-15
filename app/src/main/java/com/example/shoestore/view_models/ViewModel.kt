package com.example.shoestore.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.models.Shoe

class ViewModel: ViewModel() {


  private val _listOfShoe =MutableLiveData<List<Shoe>>()
  val listOfShoe: LiveData<List<Shoe>>
    get() = _listOfShoe

  val list = mutableListOf<Shoe>()

  private val _onSaveClicked = MutableLiveData<Boolean>()
  val onSaveClicked: LiveData<Boolean>
    get() = _onSaveClicked




  fun savedDone(){
    _onSaveClicked.value = false

  }


//  fun getDetail(name: String, company: String, des: String, size: String) {
//
//    list.add(Shoe(name,size.toDouble(),company,des))
//    _listOfShoe.value = list
//
//  }


  fun addShoe(name: String, company: String, size: Double, description: String) {
    list.add(Shoe(name,size,company,description))
    _listOfShoe.value = list
    _onSaveClicked.value = true

  }


}