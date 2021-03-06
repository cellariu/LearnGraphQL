package com.cami.graphql.learngraphql.domain.bank;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Setter
@Builder
public class Client {

    UUID id;
    String firstName;
    List<String> middleNames;
    String lastName;
    Client client;

}
