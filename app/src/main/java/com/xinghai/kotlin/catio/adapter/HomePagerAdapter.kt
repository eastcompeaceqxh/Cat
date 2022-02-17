package com.xinghai.kotlin.catio.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xinghai.kotlin.catio.CatListFragment
import com.xinghai.kotlin.catio.MyCatFragment

const val INDEX_MY_CAT: Int = 0
const val INDEX_CAT_LIST: Int = 1

class HomePagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val pagerFragmentCreator : Map<Int, () -> Fragment> = mapOf(
        INDEX_MY_CAT to {MyCatFragment()} ,
        INDEX_CAT_LIST to {CatListFragment()}
    )

    override fun getItemCount(): Int {
        return pagerFragmentCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return pagerFragmentCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}