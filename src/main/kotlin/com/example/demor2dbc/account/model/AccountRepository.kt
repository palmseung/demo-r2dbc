package com.example.demor2dbc.account.model

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AccountRepository: ReactiveCrudRepository<Account, Long> {

    suspend fun findByName(name: String): List<Account>

    @Query("SELECT SUM(A.AGE) as sum, AVG(A.AGE) as avg, A.name FROM accounts A GROUP BY name ")
    suspend fun getSumOfAge(): List<ResponseDto>

}