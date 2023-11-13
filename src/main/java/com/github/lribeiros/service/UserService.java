package com.github.lribeiros.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.github.lribeiros.model.User;

@Named
@ApplicationScoped
public class UserService {

  private List<User> users;

  @PostConstruct
  public void init() {
    users = Arrays.asList(
        new User("caiowas", "Caio", "Wall Sava"),
        new User("anawas", "Ana", "Wall Sava"),
        new User("nicowas", "Nic", "Wall Sava"));
  }

  public List<User> getUsers() {
    return new ArrayList<>(users);
  }

  public List<User> getUsers(int size) {
    if (size > users.size()) {
      Random rand = new Random();

      List<User> randomList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        int randomIndex = rand.nextInt(users.size());
        randomList.add(users.get(randomIndex));
      }
      return randomList;
    } else {
      return new ArrayList<>(users.subList(0, size));
    }
  }

  public List<User> getClonedUsers(int size) {
    List<User> results = new ArrayList<>();
    List<User> originals = getUsers(size);
    for (User original : originals) {
      results.add(new User(original.getUsername(), original.getFirstname(), original.getLastname()));
    }

    return results;
  }
}

