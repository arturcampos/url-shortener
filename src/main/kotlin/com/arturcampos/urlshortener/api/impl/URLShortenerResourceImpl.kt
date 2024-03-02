package com.arturcampos.urlshortener.api.impl

import com.arturcampos.urlshortener.dto.ShortenerRequestDto
import com.arturcampos.urlshortener.api.URLShortenerResource
import com.arturcampos.urlshortener.dto.ShortenerResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

/**
 * Implementation of the URLShortenerResource interface.
 */
@RestController
@RequestMapping("/shorten")
class URLShortenerResourceImpl : URLShortenerResource {

    @PostMapping
    override fun shorten(@RequestBody body: ShortenerRequestDto): ResponseEntity<ShortenerResponseDto> {
        return ResponseEntity
            .ok(ShortenerResponseDto("key", body.url, "http://localhost:8080/key"))
    }

    @GetMapping("/{key}")
    override fun get(@PathVariable key: String): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.FOUND)
            .location(URI.create("https://google.com"))
            .build()
    }

}