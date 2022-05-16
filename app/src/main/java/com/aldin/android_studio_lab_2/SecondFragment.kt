package com.aldin.android_studio_lab_2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels

class SecondFragment : Fragment() {

    private val userViewModel : UserViewModel<String> by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("SecondFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("SecondFragment", "onCreateView")

        val btnFragmentA: Button = view.findViewById(R.id.btnFragmentA)

        btnFragmentA.setOnClickListener {
            userViewModel.setData("Data from Second Fragment!")
            requireActivity().supportFragmentManager.popBackStack()
        }

    }
}