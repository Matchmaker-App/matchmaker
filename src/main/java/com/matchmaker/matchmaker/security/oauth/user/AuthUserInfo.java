package com.matchmaker.matchmaker.security.oauth.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public abstract class AuthUserInfo {
    protected Map<String, Object> attributes;
    public abstract String getId();
    public abstract String getName();
    public abstract String getEmail();
    public abstract String getImageUrl();
}
