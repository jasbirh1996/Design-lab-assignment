package com.jb.myapplication.ui.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jb.myapplication.databinding.FragmentAllMatchesBinding
import com.jb.myapplication.ui.viewModel.AllMatchesViewModel
import com.jb.myapplication.ui.views.adapter.AllMatchesAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AllMatchesFragment : Fragment() {

    private lateinit var binding: FragmentAllMatchesBinding
    private val viewModel : AllMatchesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.e("frag","AllMatchesFragment")
        binding = FragmentAllMatchesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.invokeApi()
        viewModel.getDataFromServer.observe(requireActivity()) {
            if(it != null){
                binding.rvAllMatches.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    setHasFixedSize(true)
                    adapter = AllMatchesAdapter(requireContext(), it,object :AllMatchesAdapter.onSelect{
                        override fun onEnable(value: Int,id : String) {
                            value
                            viewModel.enableMatch(value,id)
                        }

                        override fun onDisable(value: Int,id :String) {
                            value
                            viewModel.disableMatch(value,id)
                        }


                    })
                }
            }

        }
    }

}