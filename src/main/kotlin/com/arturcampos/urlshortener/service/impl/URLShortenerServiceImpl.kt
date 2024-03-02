package com.arturcampos.urlshortener.service.impl

import com.arturcampos.urlshortener.domain.ShortenedURL
import com.arturcampos.urlshortener.repository.UrlRepository
import com.arturcampos.urlshortener.service.URLShortenerService
import com.arturcampos.urlshortener.utils.HashingUtility
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

/**
 * Service responsible for shortening URLs
 */
@Service
class URLShortenerServiceImpl(private var urlRepository: UrlRepository) : URLShortenerService {

    override fun shorten(url: String): ShortenedURL {
        val shortenedURL = ShortenedURL(HashingUtility.hash(), url)
        return urlRepository.save(shortenedURL)
    }

    override fun retrieveOriginal(key: String): String {
        return urlRepository
            .findById(key).getOrElse { throw IllegalArgumentException("URL not found")}
            .url
    }
}