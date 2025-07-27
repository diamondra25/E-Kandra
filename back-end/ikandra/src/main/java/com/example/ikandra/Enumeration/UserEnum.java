package com.example.ikandra.Enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEnum {
    public enum UserType{
        @JsonProperty("CLIENT")
        CLIENT,
        @JsonProperty("FREELANCER")
        FREELANCER,
        @JsonProperty("ADMINISTRATOR")
        ADMINISTRATOR
    }
}
