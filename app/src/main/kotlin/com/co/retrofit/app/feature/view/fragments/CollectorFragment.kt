package com.co.retrofit.app.feature.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentCollectorBinding
import com.co.retrofit.app.feature.RetrofitApplication
import com.co.retrofit.app.feature.model.dto.Collector
import com.co.retrofit.app.feature.view.adapter.CollectorAdapter

import com.co.retrofit.app.feature.viewmodel.CollectorViewModel

class CollectorFragment: Fragment(R.layout.fragment_collector) {

    private var _binding: FragmentCollectorBinding? = null
    private val binding get() = _binding!!
    private var viewModelAdapter: CollectorAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        _binding = FragmentCollectorBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = CollectorAdapter(this@CollectorFragment)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}