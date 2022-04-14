package com.example.demor2dbc.account

import com.example.demor2dbc.account.model.Account
import com.example.demor2dbc.account.model.AccountRepository
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.r2dbc.core.DatabaseClient

@DataR2dbcTest
class AccountRepositoryTest {

    @Autowired
    lateinit var databaseClient: DatabaseClient

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun test() {

        runBlocking {
            accountRepository.save(Account(name = "nameeee")).awaitSingle()
            val fetch = databaseClient.sql("select * from accounts").fetch().first().awaitSingle()

            println("fetch = ${fetch}")
        }

    }
}