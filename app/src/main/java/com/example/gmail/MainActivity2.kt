package com.example.gmail

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity(){
    private lateinit var toolbar: Toolbar;
    private lateinit var adapter: RVItemAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2
        )
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
        adapter=RVItemAdapter(items)
        findViewById<RecyclerView>(R.id.recycler_view).adapter =adapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu)
        return true
    }



}