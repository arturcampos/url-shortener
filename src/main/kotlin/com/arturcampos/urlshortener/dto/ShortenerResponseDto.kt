package com.arturcampos.urlshortener.dto

import com.arturcampos.urlshortener.domain.ShortenedURL

data class ShortenerResponseDto(val key: String, val url: String, val shortUrl: String)

fun ShortenedURL.toResponse(shorUrlPrefix: String) = ShortenerResponseDto(
    key = key,
    url = url,
    shortUrl = "$shorUrlPrefix/$key"
)