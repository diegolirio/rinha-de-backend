//package com.lirio.kotlinspringpostgres
//
//import org.springframework.data.jpa.domain.Specification
//import javax.persistence.criteria.Predicate
//
//class PessoaSpecificationExecutor {
//    fun fieldsLike(param: String): Specification<Pessoa> {
//        return Specification { root, _, criteriaBuilder ->
//            val predicates = mutableListOf<Predicate>()
//            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("campo1")), "%${param.toLowerCase()}%"))
//            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("campo2")), "%${param.toLowerCase()}%"))
//            criteriaBuilder.or(*predicates.toTypedArray())
//        }
//    }
//
//}