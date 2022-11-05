package com.co.retrofit.app.feature.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.ArtistItemBinding

import com.co.retrofit.app.feature.view.fragments.ArtistListFragmentDirections
import com.co.retrofit.data.model.dto.Artist

class ArtistAdapter(private val fragment: Fragment,
                    private val listener: (Artist) -> Unit):
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>(){

    var artists :List<Artist> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val withDataBinding: ArtistItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ArtistViewHolder.LAYOUT,
            parent,
            false)
        return ArtistViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {


        holder.viewDataBinding.also {
            it.artist = artists[position]

        }

        holder.bind(artists[position])


        holder.viewDataBinding.root.setOnClickListener {

            val artist = com.co.retrofit.app.feature.model.dto.Artist(
                artistId = artists[position].id,
                name = artists[position].name,
                image = artists[position].image,
                birthDate = artists[position].birthDate,
                description = artists[position].description
            )
            val action = ArtistListFragmentDirections.actionNavigationArtistToNavigationAlbumsOfArtist(artists[position].id, artist)
            // Navigate using that action
            holder.viewDataBinding.root.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return artists.size
    }

    fun addArtist( artists: List<Artist>) {
        this.artists = artists
        notifyDataSetChanged()
    }


    class ArtistViewHolder(val viewDataBinding: ArtistItemBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {
        val ivDishImage = viewDataBinding.ivDishImage
        val tvDishTitle = viewDataBinding.tvDishTitle

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.artist_item
        }
        fun bind(artist: Artist) {
            Glide.with(itemView)
                .load(artist.image.toUri().buildUpon().scheme("https").build())
                .apply(RequestOptions.circleCropTransform()
                    .placeholder(R.drawable.loading_animation)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.ic_broken_image))
                .into(viewDataBinding.ivDishImage)
        }
    }

}