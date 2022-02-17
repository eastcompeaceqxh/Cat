package com.xinghai.kotlin.catio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.xinghai.kotlin.catio.adapter.HomePagerAdapter
import com.xinghai.kotlin.catio.adapter.INDEX_CAT_LIST
import com.xinghai.kotlin.catio.adapter.INDEX_MY_CAT
import com.xinghai.kotlin.catio.databinding.FragmentHomeBinding
import java.lang.IndexOutOfBoundsException

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = HomePagerAdapter(this)

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = getTabText(position)
            tab.setIcon(getTabIcon(position))
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
    }


    private fun getTabText(position: Int) : String {
        return when(position) {
            INDEX_MY_CAT -> getString(R.string.tab_my_cat)
            INDEX_CAT_LIST -> getString(R.string.tab_cat_list)
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabIcon(position: Int) : Int {
        return when(position) {
            INDEX_MY_CAT -> R.drawable.garden_tab_selector
            INDEX_CAT_LIST -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }
}