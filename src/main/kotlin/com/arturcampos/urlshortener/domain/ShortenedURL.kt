package com.arturcampos.urlshortener.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("shortened_urls")
data class ShortenedURL(@Id val key: String, val url: String)
