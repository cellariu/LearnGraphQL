package com.cami.graphql.learngraphql.resolver.bank;

import com.cami.graphql.learngraphql.domain.bank.BankAccount;
import com.cami.graphql.learngraphql.domain.bank.Client;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount) {
        log.info("Requesting client data from bank account id {}", bankAccount.getId());

        return Client.builder()
                .id(UUID.randomUUID())
                .firstName("Camelia")
                .middleNames(List.of("Delia"))
                .lastName("Ratiu")
                .build();

    }
}
