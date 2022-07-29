package com.capstone.mainpackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {
    private boolean signUpStatus;
    private String signUpMessage;

    public boolean isSignUpStatus() {
        return signUpStatus;
    }

    public void setSignUpStatus(boolean signUpStatus) {
        this.signUpStatus = signUpStatus;
    }

    public String getSignUpMessage() {
        return signUpMessage;
    }

    public void setSignUpMessage(String signUpMessage) {
        this.signUpMessage = signUpMessage;
    }
}
