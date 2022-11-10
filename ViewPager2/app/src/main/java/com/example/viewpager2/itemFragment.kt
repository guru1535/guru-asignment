package com.example.viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboardingscreenextra.Model.Item
import com.example.viewpager2.databinding.FragmentItemBinding

class itemFragment(var pos: Int,var string: String,var string1: String) : Fragment() {

    lateinit var binding: FragmentItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(inflater, container, false)
        init()
        return binding.root

    }

    fun init() {
       binding.ivThumbnail.setImageResource(pos)
       binding.tvDesc.text=string1
       binding.tvTitle.text =string
    }


}