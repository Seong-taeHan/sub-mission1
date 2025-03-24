package com.sb02.submission1.util;

public interface Patterns {
    String USER_ID = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{6,30}$";
    String PASSWORD = "^(?=(.*[A-Za-z]){2,})(?=(.*\\d){2,})(?=(.*[@$!%*?&]){2,})[A-Za-z\\d@$!%*?&]{12,50}$";
    String EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,100}$";
    String NICKNAME = "^.{1,50}$";
}
