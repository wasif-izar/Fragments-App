package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentBlueBinding


class BlueFragment : Fragment() {
  private lateinit var binding : FragmentBlueBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blue, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_blue,container,false)
        val args = BlueFragmentArgs.fromBundle(requireArguments())
        binding.bluefragTvContent.text = "${args.currentMessage}\n${args.passedMessage}"
        //without safe args
//        binding.bluefragBtSubmit.setOnClickListener { findNavController().navigate(R.id.action_blueFragment_to_redFragment) }
        //with safe args
        binding.bluefragBtSubmit.setOnClickListener { findNavController().navigate(BlueFragmentDirections.actionBlueFragmentToRedFragment(binding.bluefragEtContent.text.toString(),binding.bluefragTvContent.text.toString())) }
        return binding.root
    }

}