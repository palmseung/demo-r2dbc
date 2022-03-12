package com.example.demor2dbc.account.model

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AccountRepository: ReactiveCrudRepository<Account, Long> {

    suspend fun findByName(name: String): List<Account>
}