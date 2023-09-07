package javaerrors;

public class ExceptionPhoneNumberFormat extends NumberFormatException {

  public ExceptionPhoneNumberFormat() {
    super("Номер телефона может содержать в себе только цифры не может быть длиннее 15 символов");
  }

  public ExceptionPhoneNumberFormat(String message) {
    super(message);
  }
}