package com.lirio.kotlinspringpostgres

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PessoaRepository : JpaRepository<Pessoa, UUID>, JpaSpecificationExecutor<Pessoa> {

    fun findByApelidoLikeOrNomeLikeOrStackLike(apelido: String, nome: String, stack: String): Iterable<Pessoa>

    @Query(
        nativeQuery = true,
        value = "Select * from pessoas " +
                "where apelido like %:t% " +
                "   or nome like %:t% " +
                "   or stack like %:t% " +
                "limit 50"
        //value = "SELECT * FROM pessoa e WHERE :t IS NULL OR :t = '' OR EXISTS (SELECT 1 FROM unnest(e.stack) s WHERE LOWER(s) LIKE LOWER(CONCAT('%', :t, '%')))"
    )
    fun findBy(@Param("t") t: String): Iterable<Pessoa>

    @Query(nativeQuery = true, value = "select * from pessoa limit 50")
    fun find50First(): Iterable<Pessoa>

}
