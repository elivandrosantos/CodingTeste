package com.example.codingteste.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CodingData(
    val publicKey: String,
    val alias: String,
    val channels: Int,
    val capacity: Long,
    val firstSeen: Long,
    val updatedAt: Long,
    val city: City? = null,
    val country: Country? = null,
    @SerialName(value = "iso_code")
    val isoCode: String? = null,
    @SerialName(value = "subdivision")
    val subDivision: String? = null
)

@Serializable
data class Country(
    val de: String,
    val en: String,
    val es: String,
    val fr: String,
    val ja: String,
    @SerialName(value = "pt-BR")
    val ptBR: String,
    val ru: String,
    @SerialName(value = "zh-CN")
    val zhCN: String,
)

@Serializable
data class City(
    val de: String? = null,
    val en: String? = null,
    val es: String? = null,
    val fr: String? = null,
    val ja: String? = null,
    @SerialName(value = "pt-BR")
    val ptBR: String? = null,
    val ru: String? = null,
    @SerialName(value = "zh-CN")
    val zhCN: String? = null,
)
