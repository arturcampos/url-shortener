package com.arturcampos.urlshortener.utils

import com.github.f4b6a3.uuid.codec.base.Base62Codec
import java.util.UUID

class HashingUtility {
    companion object {
        fun hash(): String {
            return Base62Codec.INSTANCE.encode(UUID.randomUUID()).substring(0, 7)
        }
    }
}