package com.example.gmail

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar= findViewById<Toolbar>(R.id.myToolBar);
        val emailArray = arrayOf(
            "johndoe@example.com",
            "lisasmith@gmail.com",
            "davidbrown@yahoo.com",
            "sarahjones@hotmail.com",
            "mikeroberts@example.com",
            "emilywilson@gmail.com",
            "alexturner@yahoo.com",
            "jessicamiller@example.com",
            "ryansmith@hotmail.com",
            "amandajohnson@gmail.com"
        )
        setSupportActionBar(toolbar);
        val items = arrayListOf<ItemModel>()

        repeat(23) {
            val index =it + 1
            val time= 23-index
            items.add(ItemModel(
                emailArray[(0..9).random()],
                "$index something to console log here ",
                "$index some content write here",
                "$time:00 PM",
                resources.getIdentifier("thumb$index", "drawable", packageName),
                1,0
            ))
        }

        findViewById<ListView>(R.id.list_view).adapter = ItemAdapter(items)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu)
        return true
    }

}