package com.arturcampos.urlshortener.service

import com.arturcampos.urlshortener.domain.ShortenedURL
import com.arturcampos.urlshortener.repository.UrlRepository
import com.arturcampos.urlshortener.service.impl.URLShortenerServiceImpl
import com.arturcampos.urlshortener.utils.HashingUtility
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import java.util.*


class URLShortenerServiceImplTest {

    @org.junit.jupiter.api.Test
    fun shouldShortenAnUrl() {
        //given
        val givenShortenedURL = createShortenedURL()
        val urlRepository: UrlRepository = Mockito.mock(UrlRepository::class.java)
        whenever(urlRepository.save(Mockito.any())).thenReturn(givenShortenedURL)
        val urlShortenerService: URLShortenerService = URLShortenerServiceImpl(urlRepository)

        //when
        val shortenedURL = urlShortenerService.shorten(givenShortenedURL.url)

        //then
        assertEquals(7, shortenedURL.key.length)
        assertEquals(givenShortenedURL.key, shortenedURL.key)
        assertEquals(givenShortenedURL.url, shortenedURL.url)

    }

    @org.junit.jupiter.api.Test
    fun retrieveOriginal() {
        //given
        val givenShortenedURL = createShortenedURL()
        val urlRepository: UrlRepository = Mockito.mock(UrlRepository::class.java)
        whenever(urlRepository.findById(Mockito.any())).thenReturn(Optional.of(givenShortenedURL))
        val urlShortenerService: URLShortenerService = URLShortenerServiceImpl(urlRepository)

        //when
        val originalURL = urlShortenerService.retrieveOriginal(givenShortenedURL.key)

        //then
        assertEquals(givenShortenedURL.url, originalURL)
    }

    private fun createShortenedURL(): ShortenedURL {
        val key = HashingUtility.hash()
        val url = "http://www.google.com"
        return ShortenedURL(key, url)
    }


}