package com.fyayc.Interview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.catalina.User;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ProductDto {
    @JsonProperty("id")
    private int Id;


    @NotBlank(message = "Name cannot be empty or null.")
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("code")
    @NotBlank(message = "Product Code cannot be empty or null.")
    private String code;

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    private List<UserDto> users;



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
