package com.eidorian.rawgapigames.data.entity.response


import com.eidorian.rawgapigames.data.entity.response.GamesResponse.*
import com.eidorian.rawgapigames.presentation.model.Game
import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("nofollow")
    val nofollow: Boolean,
    @SerializedName("nofollow_collections")
    val nofollowCollections: List<String>,
    @SerializedName("noindex")
    val noindex: Boolean,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("seo_description")
    val seoDescription: String,
    @SerializedName("seo_h1")
    val seoH1: String,
    @SerializedName("seo_keywords")
    val seoKeywords: String,
    @SerializedName("seo_title")
    val seoTitle: String
) {
    data class Result(
        @SerializedName("added")
        val added: Int,
        @SerializedName("added_by_status")
        val addedByStatus: AddedByStatus,
        @SerializedName("background_image")
        val backgroundImage: String,
        @SerializedName("clip")
        val clip: Clip,
        @SerializedName("dominant_color")
        val dominantColor: String,
        @SerializedName("genres")
        val genres: List<Genre>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("metacritic")
        val metacritic: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("parent_platforms")
        val parentPlatforms: List<ParentPlatform>?,
        @SerializedName("platforms")
        val platforms: List<Platform>,
        @SerializedName("playtime")
        val playtime: Int,
        @SerializedName("rating")
        val rating: Double,
        @SerializedName("rating_top")
        val ratingTop: Int,
        @SerializedName("ratings")
        val ratings: List<Rating>,
        @SerializedName("ratings_count")
        val ratingsCount: Int,
        @SerializedName("released")
        val released: String,
        @SerializedName("reviews_count")
        val reviewsCount: Int,
        @SerializedName("reviews_text_count")
        val reviewsTextCount: Int,
        @SerializedName("saturated_color")
        val saturatedColor: String,
        @SerializedName("short_screenshots")
        val shortScreenshots: List<ShortScreenshot>,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("stores")
        val stores: List<Store>,
        @SerializedName("suggestions_count")
        val suggestionsCount: Int,
        @SerializedName("tags")
        val tags: List<Tag>,
        @SerializedName("tba")
        val tba: Boolean,
        @SerializedName("user_game")
        val userGame: Any
    ) {
        data class AddedByStatus(
            @SerializedName("beaten")
            val beaten: Int,
            @SerializedName("dropped")
            val dropped: Int,
            @SerializedName("owned")
            val owned: Int,
            @SerializedName("playing")
            val playing: Int,
            @SerializedName("toplay")
            val toplay: Int,
            @SerializedName("yet")
            val yet: Int
        )

        data class Clip(
            @SerializedName("clip")
            val clip: String,
            @SerializedName("clips")
            val clips: Clips,
            @SerializedName("preview")
            val preview: String,
            @SerializedName("video")
            val video: String
        ) {
            data class Clips(
                @SerializedName("full")
                val full: String,
                @SerializedName("320")
                val x320: String,
                @SerializedName("640")
                val x640: String
            )
        }

        data class Genre(
            @SerializedName("games_count")
            val gamesCount: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_background")
            val imageBackground: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("slug")
            val slug: String
        )

        data class ParentPlatform(
            @SerializedName("platform")
            val platform: Platform
        ) {
            data class Platform(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("slug")
                val slug: String
            )
        }

        data class Platform(
            @SerializedName("platform")
            val platform: Platform,
            @SerializedName("released_at")
            val releasedAt: String,
            @SerializedName("requirements_en")
            val requirementsEn: RequirementsEn,
            @SerializedName("requirements_ru")
            val requirementsRu: Any
        ) {
            data class Platform(
                @SerializedName("games_count")
                val gamesCount: Int,
                @SerializedName("id")
                val id: Int,
                @SerializedName("image")
                val image: Any,
                @SerializedName("image_background")
                val imageBackground: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("slug")
                val slug: String,
                @SerializedName("year_end")
                val yearEnd: Any,
                @SerializedName("year_start")
                val yearStart: Any
            )

            data class RequirementsEn(
                @SerializedName("minimum")
                val minimum: String,
                @SerializedName("recommended")
                val recommended: String
            )
        }

        data class Rating(
            @SerializedName("count")
            val count: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("percent")
            val percent: Double,
            @SerializedName("title")
            val title: String
        )

        data class ShortScreenshot(
            @SerializedName("id")
            val id: Int,
            @SerializedName("image")
            val image: String
        )

        data class Store(
            @SerializedName("id")
            val id: Int,
            @SerializedName("store")
            val store: Store,
            @SerializedName("url_en")
            val urlEn: String,
            @SerializedName("url_ru")
            val urlRu: Any
        ) {
            data class Store(
                @SerializedName("domain")
                val domain: String,
                @SerializedName("games_count")
                val gamesCount: Int,
                @SerializedName("id")
                val id: Int,
                @SerializedName("image_background")
                val imageBackground: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("slug")
                val slug: String
            )
        }

        data class Tag(
            @SerializedName("games_count")
            val gamesCount: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image_background")
            val imageBackground: String,
            @SerializedName("language")
            val language: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("slug")
            val slug: String
        )
    }
}

fun GamesResponse.toGame() = this.results.map {
    Game(
        it.id,
        it.name,
        it.released,
        it.backgroundImage,
        it.rating,
        it.ratingTop,
        it.parentPlatforms?.map { parent ->
            Game.Platform(
                parent.platform.id,
                parent.platform.slug
            )
        }
    )
}