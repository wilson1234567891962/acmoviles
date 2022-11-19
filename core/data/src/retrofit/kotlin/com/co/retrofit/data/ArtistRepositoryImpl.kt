package com.co.retrofit.data

import androidx.annotation.RestrictTo
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import com.co.retrofit.data.remote.api

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class ArtistRepositoryImpl : ArtistRepository {

    private var artist = MediatorResponseLiveData<List<Artist>>()
    private var salectionArtist = MediatorResponseLiveData<Artist>()

    override fun getArtists(): ResponseLiveData<List<Artist>> {
        return this.artist
    }

    override fun getArtistsApi(): ResponseLiveData<List<Artist>> {
        return makeRequest(api.getArtists())
    }

    override fun getArtistApi(artist: Artist): ResponseLiveData<Artist> {
        println(artist.id)
        return makeRequest(api.getArtist(artist.id))
    }


    override fun setArtist(artists: List<Artist>) {
        val liveData = MutableResponseLiveData<List<Artist>>()
        liveData.postData(artists)
        this.artist.swapSource(liveData)
    }

    override fun saveSelectionArtistItem(artist: Artist) {
        val liveData = MutableResponseLiveData<Artist>()
        liveData.postData(artist)
        this.salectionArtist.swapSource(liveData)
    }

    override fun getArtistSelected(): ResponseLiveData<Artist> {
        return this.salectionArtist
    }
}