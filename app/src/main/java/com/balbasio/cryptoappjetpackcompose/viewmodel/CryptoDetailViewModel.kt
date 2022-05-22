package com.balbasio.cryptoappjetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.balbasio.cryptoappjetpackcompose.model.Crypto
import com.balbasio.cryptoappjetpackcompose.repository.CryptoRepository
import com.balbasio.cryptoappjetpackcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }
}