package com.example.bottomnavigationextra.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomnavigationextra.Adapter.ItemAdapter
import com.example.bottomnavigationextra.Model.Item
import com.example.bottomnavigationextra.R
import com.example.bottomnavigationextra.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var binding: FragmentHomeBinding
    var itemList = mutableListOf<Item>()
    lateinit var mAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater , container , false)


        prepareData()

        mAdapter = ItemAdapter(requireActivity() , itemList)

        var manager = LinearLayoutManager(requireActivity())
        binding.recyclerView.layoutManager = manager

        binding.recyclerView.adapter = mAdapter

        return binding.root

    }

    private fun prepareData() {
        itemList.add(Item(1  , "King No 1" , 3.5f , R.drawable.line_1))
        itemList.add(Item(2  , "King No 2" , 3.0f , R.drawable.line_2))
        itemList.add(Item(3  , "King No 3" , 4.5f , R.drawable.line_3))
        itemList.add(Item(4  , "King No 4" , 4.0f , R.drawable.line_4))
    }


}