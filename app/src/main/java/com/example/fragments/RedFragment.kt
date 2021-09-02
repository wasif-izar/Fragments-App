package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentRedBinding


class RedFragment : Fragment() {
    private lateinit var binding : FragmentRedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_red, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_red,container,false)
        val args = RedFragmentArgs.fromBundle(requireArguments())
        binding.redfragTvContent.text = "${args.currentMessage}\n${args.passedMessage}"
        //with out safe args
//        binding.redfragBtSubmit.setOnClickListener { findNavController().navigate(R.id.action_redFragment_to_greenFragment) }
        //with safe args
        binding.redfragBtSubmit.setOnClickListener { findNavController().
        navigate(RedFragmentDirections.
        actionRedFragmentToGreenFragment(
            binding.redfragEtContent.text.toString(),binding.redfragTvContent.text.toString())) }//passing safe args
        return binding.root
    }
}