package com.example.demor2dbc.account

import com.example.demor2dbc.account.model.Account
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(
    val accountService: AccountService
) {

    @GetMapping("/accounts")
    suspend fun getAccountsByName(@RequestParam("name") name: String): List<Account> {
        return accountService.getAccount(name)
    }

    @PostMapping("accounts")
    suspend fun saveAccount(): Account {
        return accountService.save()
    }
}