package com.arturcampos.urlshortener.api

import com.arturcampos.urlshortener.dto.ShortenerRequestDto
import com.arturcampos.urlshortener.dto.ShortenerResponseDto
import org.springframework.http.ResponseEntity

/**
 * Interface Resource that holds url shortener functions such as shorten a URL and get the full url from a short code
 */
interface URLShortenerResource {
    /**
     *
     */
    fun shorten(body: ShortenerRequestDto): ResponseEntity<ShortenerResponseDto>
    fun get(key: String): ResponseEntity<Unit>


}