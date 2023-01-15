package com.example.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentDetailBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.view_models.ViewModel

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: ViewModel
    lateinit var shoe: Shoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)


        shoe = Shoe("",0.01,"","")
        binding.shoe = shoe


        binding.btCancel.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoesFragment())
        }


        binding.btSave.setOnClickListener {
            saveDetails()
        }


        viewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)

        viewModel.onSaveClicked.observe(viewLifecycleOwner, Observer { saveClicked ->
            if (saveClicked) {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoesFragment())
                viewModel.savedDone()

            }
        })


        return binding.root
    }

    private fun saveDetails() {

        if (shoe.name.isEmpty() || shoe.company.isEmpty()|| shoe.description.isEmpty()) {
                Toast.makeText(context, "Pleas Set All Fields", Toast.LENGTH_SHORT).show()
                return
            }

        if (shoe.size.equals(0.0) || shoe.equals(0.01)){
            Toast.makeText(context, "Pleas Set Number For Size", Toast.LENGTH_SHORT).show()
            return
        }

        viewModel.addShoe(shoe.name, shoe.company, shoe.size, shoe.description)

    }




}