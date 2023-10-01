package com.lirio.kotlinspringpostgres

import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name="pessoas")
data class Pessoa(
    @Id var id: UUID? = null,
    var apelido: String? = null,
    var nome: String? = null,
    var nascimento: String? = null,
    @Convert(converter = StringConverter::class) var stack: List<String>? = null,
)