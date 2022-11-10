package com.example.mysecondfragmentproject

import android.content.Context
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mysecondfragmentproject.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */





class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        communicator = context as Communicator

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnNext.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var message = binding.btnNext.text.toString().trim()


            communicator.sendValue(name, message)
        }
    }

    interface Communicator {

        fun sendValue(name : String ,  message : String )
    }




}