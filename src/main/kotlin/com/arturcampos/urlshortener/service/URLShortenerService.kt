package com.arturcampos.urlshortener.service

import com.arturcampos.urlshortener.domain.ShortenedURL
import org.springframework.stereotype.Service

/**
 * Service responsible for shortening URLs
 */
interface URLShortenerService {

/**
     * Shortens a given URL
     * @param url the URL to be shortened
     * @return the shortened URL
     */
    fun shorten(url: String): ShortenedURL

    /**
     * Retrieves the original URL from a shortened key
     * @param key the shortened key
     * @return the original URL
     */
    fun retrieveOriginal(key: String): String
}