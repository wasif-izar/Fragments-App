package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentGreenBinding

class GreenFragment : Fragment() {
   private lateinit var binding : FragmentGreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_green, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_green,container,false)
        val args = GreenFragmentArgs.fromBundle(requireArguments())
        binding.greenfragTvContent.text = "${args.currentMessage}\n${args.passedMessage}"
        //without safe args
//        binding.greenfragBtSubmit.setOnClickListener { findNavController().navigate(R.id.action_greenFragment_to_blueFragment) }
        //with safe args
        binding.greenfragBtSubmit.setOnClickListener { findNavController().navigate(GreenFragmentDirections.actionGreenFragmentToBlueFragment(binding.greenfragEtContent.text.toString(),binding.greenfragTvContent.text.toString())) }
        return binding.root
    }
}