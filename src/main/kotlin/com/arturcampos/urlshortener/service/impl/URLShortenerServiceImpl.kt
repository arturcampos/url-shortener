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
class   URLShortenerServiceImpl(private var urlRepository: UrlRepository) : URLShortenerService {

    override fun shorten(url: String): ShortenedURL = urlRepository.save(ShortenedURL(generateSingleKey(), url))

    override fun retrieveOriginal(key: String): String = urlRepository.findById(key)
        .getOrElse { throw IllegalArgumentException("URL not found")}
        .url

    private fun generateSingleKey(): String {
        System.out.println("PASSEI AQUI!")
        var key = HashingUtility.hash()
        while (urlRepository.existsById(key)) {
            key = HashingUtility.hash()
        }
        return key
    }
}