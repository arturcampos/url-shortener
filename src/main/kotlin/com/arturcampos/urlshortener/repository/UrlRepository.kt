package com.arturcampos.urlshortener.repository

import com.arturcampos.urlshortener.domain.ShortenedURL
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : CrudRepository<ShortenedURL, String>{
}