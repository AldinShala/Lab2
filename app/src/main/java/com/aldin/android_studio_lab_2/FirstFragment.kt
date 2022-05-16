package com.aldin.android_studio_lab_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.*
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer


class FirstFragment : Fragment() {

    private val userViewModel : UserViewModel<String> by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnFragmentB: Button = view.findViewById(R.id.btnFragmentB)
        val updatedData: TextView = view.findViewById(R.id.updatedData)

        userViewModel.data.observe(requireActivity()) {  value ->
            updatedData.text = value
        }


        btnFragmentB.setOnClickListener {
            val manager: FragmentManager = requireActivity().supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, SecondFragment(), "SecondFragment")
            transaction.addToBackStack("SecondFragment")
            transaction.commit()
        }

    }
}