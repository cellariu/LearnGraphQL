package com.cami.graphql.learngraphql.resolver;

import com.cami.graphql.learngraphql.domain.bank.BankAccount;
import com.cami.graphql.learngraphql.domain.bank.Client;
import com.cami.graphql.learngraphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {

        log.info("Retrieving bank account id: {}", id);

        var clientCamelia = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Camelia")
                .middleNames(List.of("Delia"))
                .lastName("Ratiu")
                .build();

        var clientDan = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Dan")
                .middleNames(List.of("Florin"))
                .lastName("Ratiu")
                .build();

        clientCamelia.setClient(clientDan);
        clientDan.setClient(clientCamelia);

        return BankAccount.builder()
                .id(id)
                .client(clientCamelia)
                .currency(Currency.EUR)
                .build();
    }
}
