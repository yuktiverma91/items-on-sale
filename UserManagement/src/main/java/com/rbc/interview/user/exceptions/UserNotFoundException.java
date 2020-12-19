
package com.rbc.interview.user.exceptions;

public class UserNotFoundException extends Exception {

        private String userId;
        public UserNotFoundException(String userId) {
            super(String.format("User is not found with id : '%s'", userId));
        }
    }

