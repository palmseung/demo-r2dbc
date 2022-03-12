package com.example.demor2dbc.account

import com.example.demor2dbc.account.model.Account
import com.example.demor2dbc.account.model.AccountRepository
import kotlinx.coroutines.reactor.awaitSingle
import mu.KotlinLogging
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct


@Service
class AccountService(
    val accountRepository: AccountRepository
) {

    val log = KotlinLogging.logger {  }

    suspend fun getAccount(name: String): List<Account> {
        return accountRepository.findByName(name)
    }

    suspend fun save(): Account {
        return accountRepository
            .save(Account(name = "member3", active = true))
            .awaitSingle()
    }

}