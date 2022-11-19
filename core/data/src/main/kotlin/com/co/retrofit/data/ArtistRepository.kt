package com.co.retrofit.data

import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Artist

interface ArtistRepository {

    fun getArtistApi(artist: Artist): ResponseLiveData<Artist> = throw NotImplementedError()

    fun getArtistSelected(): ResponseLiveData<Artist> = throw NotImplementedError()

    fun getArtists(): ResponseLiveData<List<Artist>> = throw NotImplementedError()

    fun getArtistsApi(): ResponseLiveData<List<Artist>> = throw NotImplementedError()

    fun setArtist(artists : List<Artist>): Unit = throw NotImplementedError()

    fun saveSelectionArtistItem(artist: Artist): Unit = throw NotImplementedError()
}