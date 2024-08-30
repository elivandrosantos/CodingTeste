package com.example.codingteste.ui.screen

import android.text.TextUtils.replace
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingteste.network.Api
import com.example.codingteste.network.CodingData
import kotlinx.coroutines.launch
import java.util.Date
import java.io.IOException
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Locale


class AppViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    /**
     * Call getApp() on init so we can display status immediately.
     */
    init {
        getApp()
    }


    private fun getApp() {
        viewModelScope.launch {
            appUiState = try {
                val listResult = Api.retrofitService.getData()
                val subList = listResult!!.subList(0, 100)
                val index = subList.map {
                    val decimalFormat = DecimalFormat("#.########")
                    val formatDecimal = decimalFormat.format(it.capacity.toDouble() / 100_000_000)
                        val trimIndent = """
                            
                        Public Key = ${it.publicKey}
                        Alias = ${it.alias}
                        Channels = ${it.channels}
                        Capacity = $formatDecimal BTC
                        First seen = ${Date(it.firstSeen)}
                        UpdatedAt = ${Date(it.updatedAt)}
                        City = ${it.city?.en}
                        Country = ${it.country?.en}
                            
                            
                        """.trimIndent()
                    trimIndent
                }
                AppUiState.Success(
                    data = index.toString()
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")

                )

            } catch (e: IOException) {
                AppUiState.Error

            }

        }
    }
}

sealed interface AppUiState {
    data class Success(val data: String) : AppUiState
    data object Error : AppUiState
    data object Loading : AppUiState
}
