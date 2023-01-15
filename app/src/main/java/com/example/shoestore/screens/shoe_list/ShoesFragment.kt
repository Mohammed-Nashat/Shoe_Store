package com.example.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoesBinding
import com.example.shoestore.databinding.ShoeItemBinding
import com.example.shoestore.models.Shoe
import com.example.shoestore.view_models.ViewModel


class ShoesFragment : Fragment() {

    lateinit var binding: FragmentShoesBinding
    lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes, container, false)

        binding.fabDetail.setOnClickListener {
            it?.let { onNavigatToDetail() }
        }

        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        viewModel.listOfShoe.observe(viewLifecycleOwner, Observer {
            it?.let {
                addView(inflater, container, it)

            }
        })

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                     findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToLogin2())
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)}

    private fun onNavigatToDetail() {

        findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToDetailFragment())
    }

    private fun addView(inflater: LayoutInflater, container: ViewGroup?, shoe: List<Shoe>) {


        for (shoe in shoe) {

            val view: ShoeItemBinding =
                DataBindingUtil.inflate(inflater, R.layout.shoe_item, container, false)
            view.apply {
                tvShoeName.text = shoe.name
                tvCompany.text = shoe.company
                tvDescription.text = shoe.description
                tvSize.text = shoe.size.toString()
            }

            binding.linearLayout.addView(view.root)

        }

    }


}