package com.xinghai.kotlin.catio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xinghai.kotlin.catio.databinding.FragmentMyCatBinding

class MyCatFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMyCatBinding.inflate(inflater, container, false)
        return binding.root
    }

}