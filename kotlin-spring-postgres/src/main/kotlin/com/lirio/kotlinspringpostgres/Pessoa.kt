package com.lirio.kotlinspringpostgres

import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name="PESSOAS")
data class Pessoa(
    @Id @Column(name="ID") var id: UUID? = null,
    @Column(name="APELIDO") var apelido: String? = null,
    @Column(name="NOME") var nome: String? = null,
    @Column(name="NASCIMENTO") var nascimento: String? = null,
    @Column(name="STACK") @Convert(converter = StringConverter::class) var stack: List<String>? = null,
)