package com.arifudesu.latihanfc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arifudesu.latihanfc.R.id.favorites
import com.arifudesu.latihanfc.R.id.teams
import com.arifudesu.latihanfc.fragment.FavoriteTeamsFragment
import com.arifudesu.latihanfc.fragment.TeamsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_navigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                teams -> {
                    loadTeamsFragment(savedInstanceState)
                }
                favorites -> {
                    loadFavoritesFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = teams

    }


    private fun loadTeamsFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, FavoriteTeamsFragment(), FavoriteTeamsFragment::class.java.simpleName)
        }
    }
}
