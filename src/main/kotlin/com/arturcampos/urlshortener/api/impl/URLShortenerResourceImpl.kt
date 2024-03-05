package com.arturcampos.urlshortener.api.impl

import com.arturcampos.urlshortener.dto.ShortenerRequestDto
import com.arturcampos.urlshortener.api.URLShortenerResource
import com.arturcampos.urlshortener.domain.ShortenedURL
import com.arturcampos.urlshortener.dto.ShortenerResponseDto
import com.arturcampos.urlshortener.dto.toResponse
import com.arturcampos.urlshortener.service.URLShortenerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

/**
 * Implementation of the URLShortenerResource interface.
 */
@RestController
@RequestMapping("/shorten")
class URLShortenerResourceImpl(private var urlShortenerService: URLShortenerService) : URLShortenerResource {

    @PostMapping
    override fun shorten(@RequestBody body: ShortenerRequestDto): ResponseEntity<ShortenerResponseDto> {
        val shortenedURL = urlShortenerService.shorten(body.url);
        return ResponseEntity.ok(shortenedURL.toResponse("http://localhost:8080/shorten"))
    }

    @GetMapping("/{key}")
    override fun get(@PathVariable key: String): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.FOUND)
            .location(URI.create(urlShortenerService.retrieveOriginal(key)))
            .build()
    }

}