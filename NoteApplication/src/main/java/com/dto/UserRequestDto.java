package com.dto;

public class UserRequestDto {

    private String name;
    private String email;
    private String password;
    private Boolean isActive;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
  
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
  
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
  
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
