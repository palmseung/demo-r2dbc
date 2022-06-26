package com.example.demor2dbc.account

import com.example.demor2dbc.account.model.Account
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(
    val accountService: AccountService
) {

    val log = KotlinLogging.logger {  }

    @GetMapping("/accounts")
    suspend fun getAccountsByName(@RequestParam("name") name: String): List<Account> {
        return accountService.getAccount(name)
    }

    @PostMapping("/accounts")
    suspend fun saveAccount(): Account {
        return accountService.save()
    }

    @GetMapping("/accounts/test0")
    suspend fun test0(): List<Account> {
        log.info { "test suspend alone >> " }
        return accountService.test0()
    }

    @GetMapping("/accounts/test")
    suspend fun test(): List<Account> {
        log.info { "test 1 async >> " }
        return accountService.test()
    }

    @GetMapping("/accounts/test2")
    suspend fun test2(): List<Account> {
        log.info { "test 2 async >> " }
        return accountService.test2()
    }

    @GetMapping("/accounts/test2-2")
    suspend fun test2_2(): List<Account> {
        log.info { "test 2-2 async >> " }
        return accountService.test2_2()
    }

    @GetMapping("/accounts/test3")
    suspend fun test3(): List<Account> {
        log.info { "test 3 async >> " }
        return accountService.test3()
    }
}