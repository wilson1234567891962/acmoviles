package com.co.retrofit.app.feature.view.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumsOfArtistBinding
import com.co.retrofit.app.feature.RetrofitApplication
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.view.activities.Maintenance
import com.co.retrofit.app.feature.view.adapter.AlbumOfArtistAdapter
import com.co.retrofit.app.feature.viewmodel.AlbumsOfArtistViewModel
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.model.dto.Artist
import java.util.Collections


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AlbumsOfArtistFragment : Fragment() {

    private var _binding: FragmentAlbumsOfArtistBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AlbumsOfArtistViewModel
    private lateinit var recyclerView: RecyclerView
    private var viewModelAdapter: AlbumOfArtistAdapter? = null
    private val back: View by viewProvider(R.id.back_detail_artist)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumsOfArtistBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModelAdapter = AlbumOfArtistAdapter(this@AlbumsOfArtistFragment)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }

        activity.actionBar?.title = getString(R.string.title_albums_of_artist)

        val args: AlbumsOfArtistFragmentArgs by navArgs()


        viewModel = ViewModelProvider(this, AlbumsOfArtistViewModel.Factory(activity.application as RetrofitApplication, args.artistId, args.artist)).get(AlbumsOfArtistViewModel::class.java)

        this.callServiceApi(Artist(args.artist.artistId,args.artist.name,args.artist.image, args.artist.description, args.artist.birthDate, Collections.emptyList()))
        viewModel.getArtistSelected()
            .observeSingleData(this,::callServiceApi)
            .observeErrorThrowable(this, ::observeErrorThrowable)
        recyclerView = binding.albumsOfArtistRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = viewModelAdapter
        setUpListenerEvent()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onNetworkError() {
        if(!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }

    private fun setUpListenerEvent() {
        back.setOnClickListener(this::backPressed)
    }

    private fun callServiceApi(artist: Artist){

        viewModel.getArtistApi(artist)
           .observeSingleData(this, ::showArtistDetail)

    }

    @Suppress("UNUSED_PARAMETER")
    private fun observeErrorThrowable(error: Throwable){
        val intent = Intent(this.activity, Maintenance::class.java)
        startActivity(intent)
    }

    private fun showArtistDetail (artist: Artist) {

        println(artist)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }

        activity.actionBar?.title = getString(R.string.title_albums_of_artist)

        activity.findViewById<TextView>(R.id.artist_name).apply{text=artist.name }
        activity.findViewById<TextView>(R.id.artist_description).apply{text=artist.description }
        activity.findViewById<TextView>(R.id.artist_creation_date).apply{text=artist.birthDate}
        Glide.with(activity)
            .load(artist.image.toUri().buildUpon().scheme("https").build())
            .apply(RequestOptions.circleCropTransform().placeholder(R.drawable.loading_animation).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.ic_broken_image))
            .into(activity.findViewById<ImageView>(R.id.artist_image))


        viewModel = ViewModelProvider(this, AlbumsOfArtistViewModel.Factory(activity.application as RetrofitApplication, artist.id, com.co.retrofit.app.feature.model.dto.Artist(artist.id, artist.name,artist.image, artist.birthDate, artist.description))).get(AlbumsOfArtistViewModel::class.java)
        viewModel.albumsOfArtist.observe(viewLifecycleOwner, Observer<List<Album>> {
            it.apply {
                viewModelAdapter!!.albums_of_artist = this
                if(this.isEmpty()){
                    binding.txtNoComments.visibility = View.VISIBLE
                }else{
                    binding.txtNoComments.visibility = View.GONE
                }
            }
        })
        viewModel.eventNetworkError.observe(viewLifecycleOwner, Observer<Boolean> { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })
    }

    @Suppress("UNUSED_PARAMETER")
    private fun backPressed(view: View) {
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_artist_list)
    }
}