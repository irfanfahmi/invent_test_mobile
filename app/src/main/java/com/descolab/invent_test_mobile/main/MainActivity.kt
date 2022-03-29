package com.descolab.invent_test_mobile.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import com.descolab.invent_test_mobile.App
import com.descolab.invent_test_mobile.R
import com.descolab.invent_test_mobile.category.CategoryFrag
import com.descolab.invent_test_mobile.helper.Utils
import com.descolab.invent_test_mobile.home.HomeFragment
import com.descolab.invent_test_mobile.profile.ProfileFrag
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic lateinit var instance: MainActivity
        @JvmStatic var popup = 0
    }

    init {
        instance = this
    }

    private var menu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frame_container, HomeFragment(), null)
        transaction.commit()


        App.get().sharedPreferences1000

        setSupportActionBar(toolbarid)
        // Now get the support action bar
        val actionBar = supportActionBar

        // Set toolbar title/app title
        actionBar!!.title = ""


        navigation.enableShiftingMode(false)
        navigation.enableItemShiftingMode(false)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.frame_container)
        navigation.onNavigationItemSelectedListener = null
        currentFragment?.let { setBottomMenu(it) }
        navigation.onNavigationItemSelectedListener = mOnNavigationItemSelectedListener
    }

    override fun onResume() {
        super.onResume()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.frame_container)
        navigation.onNavigationItemSelectedListener = null
        currentFragment?.let { setBottomMenu(it) }
        navigation.onNavigationItemSelectedListener = mOnNavigationItemSelectedListener
    }


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    if (supportFragmentManager.findFragmentById(R.id.frame_container) !is HomeFragment) {
                        supportFragmentManager.findFragmentById(R.id.frame_container)?.let {
                            Utils.addFragment(
                                it,
                                HomeFragment(), null
                            )
                        }
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_category -> {
                    if (supportFragmentManager.findFragmentById(R.id.frame_container) !is CategoryFrag) {
                        supportFragmentManager.findFragmentById(R.id.frame_container)?.let {

                            Utils.addFragment(
                                it,
                                CategoryFrag(), null
                            )
                        }
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profil -> {
                    if (supportFragmentManager.findFragmentById(R.id.frame_container) !is ProfileFrag) {
                        supportFragmentManager.findFragmentById(R.id.frame_container)?.let {

                            Utils.addFragment(
                                it,
                                ProfileFrag(), null
                            )

                        }
                    }
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    fun setBottomMenu(fragment: Fragment) {
        navigation.visibility = View.VISIBLE
        if (fragment is HomeFragment) {
            navigation.currentItem = 0
        } else if (fragment is CategoryFrag) {
            navigation.currentItem = 1
        } else if (fragment is ProfileFrag) {
            navigation.currentItem = 2
        } else {
            navigation.visibility = View.GONE
        }
    }
}