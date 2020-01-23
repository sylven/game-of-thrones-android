package com.silviuchirvasa.gameofthrones.data.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NetworkCharacter(
    @Json(name = "titles")
    val titles: List<String?>? = null,
    @Json(name = "origin")
    val origin: List<String?>? = null,
    @Json(name = "siblings")
    val siblings: List<String?>? = null,
    @Json(name = "spouse")
    val spouse: List<String?>? = null,
    @Json(name = "lovers")
    val lovers: List<String?>? = null,
    @Json(name = "plod")
    val plod: Int? = null,
    @Json(name = "longevity")
    val longevity: List<String?>? = null,
    @Json(name = "plodB")
    val plodB: Double? = null,
    @Json(name = "plodC")
    val plodC: Int? = null,
    @Json(name = "longevityB")
    val longevityB: List<String?>? = null,
    @Json(name = "longevityC")
    val longevityC: List<String?>? = null,
    @Json(name = "culture")
    val culture: List<String?>? = null,
    @Json(name = "religion")
    val religion: List<String?>? = null,
    @Json(name = "allegiances")
    val allegiances: List<String?>? = null,
    @Json(name = "seasons")
    val seasons: List<Int?>? = null,
    @Json(name = "appearances")
    val appearances: List<String?>? = null,
    @Json(name = "_id")
    val _id: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "slug")
    val slug: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "gender")
    val gender: String? = null,
    @Json(name = "alive")
    val alive: Boolean? = null,
    @Json(name = "death")
    val death: Int? = null,
    @Json(name = "father")
    val father: String? = null,
    @Json(name = "house")
    val house: String? = null,
    @Json(name = "first_seen")
    val firstSeen: String? = null,
    @Json(name = "actor")
    val actor: String? = null,
    @Json(name = "related")
    val related: List<Related?>? = null,
    @Json(name = "createdAt")
    val createdAt: String? = null,
    @Json(name = "updatedAt")
    val updatedAt: String? = null,
    @Json(name = "__v")
    val __v: Int? = null,
    @Json(name = "pagerank")
    val pagerank: Pagerank? = null,
    @Json(name = "age")
    val age: Age? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "mother")
    val mother: String? = null,
    @Json(name = "birth")
    val birth: Int? = null,
    @Json(name = "longevityStartB")
    val longevityStartB: Int? = null
): Parcelable {
    @Parcelize
    data class Related(
        @Json(name = "_id")
        val _id: String? = null,
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "slug")
        val slug: String? = null,
        @Json(name = "mentions")
        val mentions: Int? = null
    ): Parcelable
    @Parcelize
    data class Pagerank(
        @Json(name = "title")
        val title: String? = null,
        @Json(name = "rank")
        val rank: Int? = null
    ): Parcelable
    @Parcelize
    data class Age(
        @Json(name = "name")
        val name: String? = null,
        @Json(name = "age")
        val age: Int? = null
    ): Parcelable
}