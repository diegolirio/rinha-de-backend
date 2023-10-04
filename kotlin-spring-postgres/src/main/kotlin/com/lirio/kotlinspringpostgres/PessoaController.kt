package com.lirio.kotlinspringpostgres

import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.NumberFormatException
import java.net.URI
import java.util.*


@RestController
@RequestMapping
class PessoaController(
    private val pessoaRepository: PessoaRepository
) {

    @PostMapping("/pessoas")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun post(@RequestBody pessoa: Pessoa): ResponseEntity<Nothing> {
        pessoa.id = UUID.randomUUID()
        restricoes(pessoa)
        pessoaRepository.save(pessoa)
        return ResponseEntity.created(URI("/pessoas/${pessoa.id}")).build()
    }

    @GetMapping("/pessoas/{id}")
    fun getById(@PathVariable("id") id: String): Pessoa {
        return pessoaRepository.findById(UUID.fromString(id)).get()
    }

    @GetMapping("/pessoas/s")
    fun getAll(): Iterable<Pessoa> {
        //return pessoaRepository.find50First()
        return pessoaRepository.findAll(PageRequest.of(0, 50)).content
    }

    @GetMapping("/pessoas")
    fun getAllFilter(@RequestParam("t") t: String): Iterable<Pessoa> {
        //return pessoaRepository.findByApelidoLikeOrNomeLikeOrStackLike(t, t, t)
        return pessoaRepository.findBy(t)
    }

    @GetMapping("/contagem-pessoas")
    fun count(): Long {
        return pessoaRepository.count()
    }

    private fun restricoes(pessoa: Pessoa) {
        if(pessoa.nome == null || pessoa.apelido == null) throw Quatro22Excpeption()
        naoDeveSerNumerico(pessoa.nome!!)
        pessoa.stack?.forEach { naoDeveSerNumerico(it) }
    }

    private fun naoDeveSerNumerico(text: String) {
        try {
            var t = text.toLong()
            throw Quatro22Excpeption()
        } catch (e: NumberFormatException) {}
    }
}