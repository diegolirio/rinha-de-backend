package com.lirio.kotlinspringpostgres

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class StringConverter : AttributeConverter<List<String?>?, String?> {

    override fun convertToDatabaseColumn(stringList: List<String?>?): String? {
        return if (stringList != null) java.lang.String.join(SPLIT_CHAR, stringList) else null
    }

    override fun convertToEntityAttribute(string: String?): List<String?> {
        return if (string != null) listOf(*string.split(SPLIT_CHAR.toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()) else kotlin.collections.emptyList<String>()
    }

    companion object { private const val SPLIT_CHAR = ";" }
}
