package com.example.demor2dbc.account

import com.example.demor2dbc.account.model.Account
import com.example.demor2dbc.account.model.AccountRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactor.awaitSingle
import mu.KotlinLogging
import org.springframework.stereotype.Service


@Service
class AccountService(
    val accountRepository: AccountRepository
) {

    val log = KotlinLogging.logger { }

    suspend fun getAccount(name: String): List<Account> {
        log.info { "get account" }
        return accountRepository.findByName(name)
    }

    suspend fun save(): Account {
        log.info { "save account" }
        return accountRepository
            .save(Account(name = "member3", active = true))
            .awaitSingle()
    }

    suspend fun test0(): List<Account> = retrieve()

    suspend fun test(): List<Account> = coroutineScope {
        return@coroutineScope listOf(
            async { retrieve() }
        ).awaitAll()
            .run {
                this[0]
            }
    }

    suspend fun test2(): List<Account> = coroutineScope {
        return@coroutineScope listOf(
            async { retrieve() },
            async { retrieve() }
        ).awaitAll()
            .run {
                this[0].map { it }
            }
    }

    suspend fun test2_2(): List<Account> {
        val re = retrieve()
        val re2 = retrieve()

        return re.plus(re2)
    }

    suspend fun test3(): List<Account> = coroutineScope {
        return@coroutineScope listOf(
            async { retrieve() },
            async { retrieve() },
            async { retrieve() }
        ).awaitAll()
            .run {
                this[0].map { it }
            }
    }

    private suspend fun retrieve(): List<Account> {
        log.info { "currentThread = ${Thread.currentThread()}" }
        return accountRepository.findByName("member3")
    }
}