package com.example.viewpager2fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpager2fragment.databinding.FragmentItemBinding

class ItemFragment(var image :Int , var title: String , var desc : String) : Fragment() {

    private lateinit var binding: FragmentItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentItemBinding.inflate(inflater , container , false)

        vData()
        return binding.root

    }


    private fun vData() {

        binding.ivThumbnail.setImageResource(image)
        binding.tvTitle.text = title
        binding.tvDesc.text = desc
    }

}