package com.co.retrofit.data

import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Artist

interface ArtistRepository {
    fun getArtists(): ResponseLiveData<List<Artist>> = throw NotImplementedError()

    fun getArtistsApi(): ResponseLiveData<List<Artist>> = throw NotImplementedError()

    fun setArtist(artists : List<Artist>): Unit = throw NotImplementedError()
}