package com.co.retrofit.app.feature.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentArtistListBinding
import com.co.retrofit.app.feature.view.adapter.ArtistAdapter
import com.co.retrofit.app.feature.viewmodel.artist.ArtistViewModel
import com.co.retrofit.data.model.dto.Artist


class ArtistListFragment : Fragment(R.layout.fragment_artist_list) {

    private val artistViewModel by viewModelProvider(ArtistViewModel::class)
    private var binding: FragmentArtistListBinding? = null
    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentArtistListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Add an observer on the LiveData returned by getFavoriteDishesList.
         * The onChanged() method fires when the observed data changes and the activity is in the foreground.
         */

        // Set the LayoutManager that this RecyclerView will use.
        binding!!.rvArtistsList.layoutManager =
            GridLayoutManager(requireActivity(), 2)
        // Adapter class is initialized and list is passed in the param.
        artistAdapter = ArtistAdapter(this@ArtistListFragment) { item ->
            artistViewModel.saveSelectionItem(item)
        };
        // adapter instance is set to the recyclerview to inflate the items.
        binding!!.rvArtistsList.adapter = artistAdapter

        getArtist()
    }

    private fun addArtistView(artists: List<Artist>) {
        if (artists.isNotEmpty()) {
            binding!!.rvArtistsList.visibility = View.VISIBLE
            binding!!.tvArtistAvailable.visibility = View.GONE

            artistAdapter.addArtist(artists)
        } else {
            binding!!.rvArtistsList.visibility = View.GONE
            binding!!.tvArtistAvailable.visibility = View.VISIBLE
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun getArtist() {
        artistViewModel.getArtistApi()
            .observeData(this, ::setArtist)

    }

    private fun setArtist(artists: List<Artist>) {
        artistViewModel.setArtists(artists)
        addArtistView(artists)

    }

}