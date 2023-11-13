package com.github.lribeiros.model;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "username"})
@NoArgsConstructor
@ToString
public class User {
  private UUID id;
  private String username;
  private String firstname;
  private String lastname;

  public User(String username, String firstname, String lastname) {
    this.id = UUID.randomUUID(); 
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
  }
}
