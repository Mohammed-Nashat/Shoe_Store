package com.example.shoestore.screens.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {
    lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction,container,false)

        binding.btShoeList.setOnClickListener{
            onNavigatToShoeLIst()
        }

        return binding.root
    }

    private fun onNavigatToShoeLIst() {
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoesFragment())
    }

}