package com.example.demor2dbc.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.pool.ConnectionPool
import io.r2dbc.pool.ConnectionPoolConfiguration
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class H2R2dbcConfig : AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory {
        val config = H2ConnectionConfiguration.builder()
            .inMemory("testdb")
            .property(H2ConnectionOption.DB_CLOSE_DELAY, "-1")
            .username("sa")
            .build()

        val factory = H2ConnectionFactory(config)

        return ConnectionPool(
            ConnectionPoolConfiguration.builder()
                .connectionFactory(factory)
                .maxSize(30)
                .initialSize(10)
                .acquireRetry(5)
                .build()
        )
    }

}