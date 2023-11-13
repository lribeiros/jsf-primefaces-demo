package com.github.lribeiros.web;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.github.lribeiros.model.User;
import com.github.lribeiros.service.UserService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class UserView implements Serializable {

  private User selectedUser;
  private List<User> users;
  private List<User> selectedUsers;

  @Inject
  private UserService userService;

  @PostConstruct
  public void init() {
    this.users = this.userService.getClonedUsers(100);
  }

  public void openNew() {
    this.selectedUser = new User();
  }

  public void saveUser() {
    if (this.selectedUser.getId() == null) {
      this.selectedUser.setId(UUID.randomUUID());
      this.users.add(this.selectedUser);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Added"));
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Updated"));
    }

    PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
    PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
  }

  public void deleteUser() {
    this.users.remove(this.selectedUser);
    this.selectedUsers.remove(this.selectedUser);
    this.selectedUser = null;
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Removed"));
    PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
  }

  public String getDeleteButtonMessage() {
    if (hasSelectedUsers()) {
      int size = this.selectedUsers.size();
      return size > 1 ? size + " users selected" : "1 user selected";
    }

    return "Delete";
  }

  public boolean hasSelectedUsers() {
    return this.selectedUsers != null && !this.selectedUsers.isEmpty();
  }

  public void deleteSelectedUsers() {
    this.users.removeAll(this.selectedUsers);
    this.selectedUsers = null;
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Removed"));
    PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    PrimeFaces.current().executeScript("PF('dtUsers').clearFilters()");
  }

}

