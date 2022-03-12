package com.example.demor2dbc.account.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("accounts")
data class Account(
    @Id
    var id: Long? = null,

    var name: String? = null,

    var active: Boolean = false,

    var createdAt: LocalDateTime = LocalDateTime.now(),

    var modifiedAt: LocalDateTime = createdAt
)
