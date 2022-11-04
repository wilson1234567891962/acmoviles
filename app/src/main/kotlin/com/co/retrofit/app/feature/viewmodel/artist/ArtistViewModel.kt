package com.co.retrofit.app.feature.viewmodel.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Artist

class ArtistViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun getArtistsCache(): ResponseLiveData<List<Artist>> {
        return RepositoryProvider.artistRepository.getArtists()
    }

    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }

    fun getArtistApi(): ResponseLiveData<List<Artist>> {
        return RepositoryProvider.artistRepository.getArtistsApi()
    }

    fun setArtists(artists: List<Artist>) {
        return RepositoryProvider.artistRepository.setArtist(artists)
    }
}