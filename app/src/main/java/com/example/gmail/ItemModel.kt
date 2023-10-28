package com.example.gmail

class ItemModel(
    val header:String,
    val title: String,
    val content:String,
    val date:String, val avatar: Int,
    var isImportant: Int,
    var isStar:Int) {
}