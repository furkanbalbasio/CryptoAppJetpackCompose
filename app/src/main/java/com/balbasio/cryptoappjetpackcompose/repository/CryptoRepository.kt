package com.balbasio.cryptoappjetpackcompose.repository

import com.balbasio.cryptoappjetpackcompose.model.Crypto
import com.balbasio.cryptoappjetpackcompose.model.CryptoList
import com.balbasio.cryptoappjetpackcompose.service.CryptoAPI
import com.balbasio.cryptoappjetpackcompose.util.Constants.API_KEY
import com.balbasio.cryptoappjetpackcompose.util.Constants.CALL_ATTRIBUTES
import com.balbasio.cryptoappjetpackcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository@Inject constructor(
    private val api: CryptoAPI
) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY,id,CALL_ATTRIBUTES)
        } catch(e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}