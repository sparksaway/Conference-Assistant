package com.conference.formvalidator;

public class SignupFormValidator {
  private String email;
  private String username;
  private String emailMessage;
  private String usernameMessage;

  private interface CheckField {
      boolean isCorrect(String field);
  }

  public SignupFormValidator(){
  }

    public SignupFormValidator(String email, String password, String username) {
        this.email = email;
        this.username = username;
    }

  public void setEmail(String email) {
      this.email = email;
  }

  public void setUsername(String username) {
      this.username = username;
  }

  public String getEmailMessage() {
      return emailMessage;
  }

  public String getUsernameMessage() {
      return usernameMessage;
  }

  public boolean isFormValid() {

      //check username min 5 characters
      CheckField checkFieldLength = field -> {
          if (field.length() < 5) {
              usernameMessage = "Username must contain at least 5 symbols!";
              return false;
          }
          return true;
      };

      //check email validity
      CheckField checkFieldEmail = field -> {
          boolean result = field.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+
                  "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
          if (!result){
              emailMessage = "Please provide valid Email address!";
          }
          return result;
      };


      return checkFieldLength.isCorrect(username)
              && checkFieldEmail.isCorrect(email);
  }
}