package com.jb.myapplication.ui.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jb.myapplication.R
import com.jb.myapplication.databinding.FragmentSavedMatchesBinding
import com.jb.myapplication.ui.viewModel.SavedMatchesViewModel
import com.jb.myapplication.ui.views.adapter.AllMatchesAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SavedMatchesFragment : Fragment() {
    private lateinit var binding : FragmentSavedMatchesBinding
    private val savedMatchesViewModel : SavedMatchesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.e("frag","SavedMatchesFragment")

        binding = FragmentSavedMatchesBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedMatchesViewModel.invoke()
        savedMatchesViewModel.getSavedMatchesData.observe(requireActivity()) {

            if(it != null){
                binding.rvSavedMatches.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    setHasFixedSize(true)
                    adapter = AllMatchesAdapter(requireContext(),it,object : AllMatchesAdapter.onSelect{
                        override fun onEnable(value: Int,id:String) {
                           savedMatchesViewModel.enableMatch(value,id)
                        }

                        override fun onDisable(value: Int,id: String) {
                            savedMatchesViewModel.disableMatch(value,id)
                        }


                    })
                }
            }


        }
    }


}